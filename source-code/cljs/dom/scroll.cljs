
(ns dom.scroll
    (:require [dom.config      :as config]
              [fruits.math.api :as math]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-scroll-x
  ; @usage
  ; (get-scroll-x)
  ;
  ; @return (px)
  []
  (-> js/document .-documentElement .-scrollLeft))

(defn get-scroll-y
  ; @usage
  ; (get-scroll-y)
  ;
  ; @return (px)
  []
  (-> js/document .-documentElement .-scrollTop))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn scroll-direction-ttb?
  ; @param (integer) last-scroll-y
  ;
  ; @usage
  ; (scroll-direction-ttb? 100)
  ;
  ; @return (boolean)
  [last-scroll-y]
  ; If the 'scroll-y' value is at least as much greater than the value of
  ; 'config.SCROLL-DIRECTION-SENSITIVITY' as the last-scroll-y value...
  (< (+ last-scroll-y config/SCROLL-DIRECTION-SENSITIVITY)
     (-> js/document .-documentElement .-scrollTop)))

(defn scroll-direction-btt?
  ; @param (integer) last-scroll-y
  ;
  ; @usage
  ; (scroll-direction-btt? 100)
  ;
  ; @return (boolean)
  [last-scroll-y]
  ; If the 'scroll-y' value is at least as much smaller than the value of
  ; 'config.SCROLL-DIRECTION-SENSITIVITY' as the last-scroll-y value...
  (> (- last-scroll-y config/SCROLL-DIRECTION-SENSITIVITY)
     (-> js/document .-documentElement .-scrollTop)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-scroll-direction
  ; @param (integer) last-scroll-y
  ;
  ; @usage
  ; (get-scroll-direction 100)
  ;
  ; @return (keyword or nil)
  ;  nil, :btt, :ttb
  [last-scroll-y]
  (cond ; @note (#0061)
        (and (scroll-direction-ttb? last-scroll-y)
             (math/not-negative?    last-scroll-y))
        (-> :ttb)

        ; @note (#0061)
        (and (scroll-direction-btt? last-scroll-y)
             (math/not-negative?    last-scroll-y))
        (-> :btt)

        ; @note (#0061)
        ; In some browsers, there is a 'scroll bounce effect' at the top of the page
        ; when quickly scrolling upward (i.e., btt) with a strong momentum.
        ; During that bounce – when the 'scroll-y' value approaches 0 from negative direction –
        ; the 'scroll-direction' value can be ':ttb,' even though the original gesture was upward scrolling.
        ; Therefore, negative 'scroll-y' values are ... as ...
        (math/negative? last-scroll-y)
        (-> :btt)

        ; @note (#0088)
        ; If the absolute difference between the 'last-scroll-y' and 'scroll-y'
        ; values is not greater than the 'SCROLL-DIRECTION-SENSITIVITY' and the @note (#0061)
        ; case is not true, then the scroll direction cannot be determined.
        :return nil))

(defn get-scroll-progress
  ; @usage
  ; (get-scroll-progress)
  ;
  ; @return (percentage)
  []
  ; @note
  ; During the construction of the DOM structure, there are moments when the value
  ; of 'document-height' is not accurate, and as a result, the 'scroll-progress'
  ; value would be less than 0.
  ; Therefore, this function's output is limited between 0 and 100.
  (let [viewport-height (-> js/window   .-innerHeight)
        scroll-y        (-> js/document .-documentElement .-scrollTop)
        document-height (-> js/document .-documentElement .-scrollHeight)
        max-scroll-y    (- document-height viewport-height)
        scroll-progress (math/percent max-scroll-y scroll-y)]
      (math/between scroll-progress 0 100)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-scroll-x!
  ; @param (px) scroll-x
  ; @param (map)(opt) options
  ; {:smooth? (boolean)
  ;   Default: false}
  ;
  ; @usage
  ; (set-scroll-x! 100)
  ([scroll-x]
   (set-scroll-x! scroll-x {}))

  ([scroll-x {:keys [smooth?]}]
   ; @bug (#8709)
   ; Out of order!
   ; (let [scroll-behavior   (if smooth? "smooth" "auto")
   ;       scroll-to-options {"left" scroll-x "top" 0 "behavior" scroll-behavior}]
   ;      (.scrollBy js/window (clj->js scroll-to-options)))
   (-> js/document .-documentElement .-scrollLeft (set! scroll-x))))

(defn set-scroll-y!
  ; @param (px) scroll-y
  ; @param (map)(opt) options
  ; {:smooth? (boolean)
  ;   Default: false}
  ;
  ; @usage
  ; (set-scroll-y! 100)
  ([scroll-y]
   (set-scroll-y! scroll-y {}))

  ([scroll-y {:keys [smooth?]}]
   ; @bug (#8709)
   ; Out of order!
   ; (let [scroll-behavior   (if smooth? "smooth" "auto")
   ;       scroll-to-options {"left" 0 "top" scroll-y "behavior" scroll-behavior}]
   ;      (.scrollBy js/window (clj->js scroll-to-options)))
   (-> js/document .-documentElement .-scrollTop (set! scroll-y))))

(defn scroll-to-element-top!
  ; @param (DOM Element object) element
  ; @param (px)(opt) offset
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (scroll-to-element-top! my-element)
  ([element]
   (scroll-to-element-top! element 0))

  ([element offset]
   (-> js/document .-documentElement .-scrollTop
       (set! (+ offset (-> element     .getBoundingClientRect .-top)
                       (-> js/document .-documentElement      .-scrollTop))))))

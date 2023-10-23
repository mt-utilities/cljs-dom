
(ns dom.scroll
    (:require [dom.config :as config]
              [math.api   :as math]))

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
             ; XXX#0061
  (cond (and (scroll-direction-ttb? last-scroll-y)
             (math/nonnegative?     last-scroll-y))
        (-> :ttb)

             ; XXX#0061
        (and (scroll-direction-btt? last-scroll-y)
             (math/nonnegative?     last-scroll-y))
        (-> :btt)

        ; XXX#0061
        ; In certain browsers, the 'scroll bounce effect' at the top of the page,
        ; when quickly scrolling back up with a strong momentum, during the bounce
        ; – when the 'scroll-y' value approaches 0 from the negative direction –
        ; would set the 'scroll-direction' value to ':ttb,' even though the original
        ; gesture was upward scrolling.
        (math/negative? last-scroll-y)
        (-> :btt)

        ; XXX#0088
        ; If the absolute difference between the 'last-scroll-y' and 'scroll-y'
        ; values is not greater than the 'SCROLL-DIRECTION-SENSITIVITY' and the 'XXX#0061'
        ; exception is not true, then the scroll direction cannot be determined.
        :return nil))

(defn get-scroll-progress
  ; @usage
  ; (get-scroll-progress)
  ;
  ; @return (percent)
  ; 0 - 100
  []
  (let [viewport-height (-> js/window   .-innerHeight)
        scroll-y        (-> js/document .-documentElement .-scrollTop)
        document-height (-> js/document .-documentElement .-scrollHeight)
        max-scroll-y    (- document-height viewport-height)
        scroll-progress (math/percent max-scroll-y scroll-y)]
      ; During the construction of the DOM structure, there are moments when the value
      ; of 'document-height' is not accurate, and as a result, the 'scroll-progress'
      ; value would be less than 0.
      (math/between! scroll-progress 0 100)))

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
   ; BUG#8709
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
   ; BUG#8709
   ; Out of order!
   ; (let [scroll-behavior   (if smooth? "smooth" "auto")
   ;       scroll-to-options {"left" 0 "top" scroll-y "behavior" scroll-behavior}]
   ;      (.scrollBy js/window (clj->js scroll-to-options)))
   (-> js/document .-documentElement .-scrollTop (set! scroll-y))))

(defn scroll-to-element-top!
  ; @param (DOM-element) element
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


(ns dom.scroll
    (:require [dom.config      :as config]
              [fruits.math.api :as math]
              [dom.position :as position]
              [dom.dimensions :as dimensions]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-scroll-x
  ; @description
  ; Returns the scroll X position of the DOCUMENT element.
  ;
  ; @usage
  ; (get-scroll-x)
  ; =>
  ; 420
  ;
  ; @return (px)
  []
  (-> js/document .-documentElement .-scrollLeft))

(defn get-scroll-y
  ; @description
  ; Returns the scroll Y position of the DOCUMENT element.
  ;
  ; @usage
  ; (get-scroll-y)
  ; =>
  ; 420
  ;
  ; @return (px)
  []
  (-> js/document .-documentElement .-scrollTop))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn scroll-x-direction-ltr?
  ; @description
  ; Returns TRUE if the DOCUMENT element is scrolled rightward (left to right) based on the given last scroll X position.
  ;
  ; @param (px) last-scroll-x
  ; @param (px)(opt) sensitivity
  ; Default: 10
  ;
  ; @usage
  ; (scroll-x-direction-ltr? 420)
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([last-scroll-x]
   (scroll-x-direction-ltr? last-scroll-x config/DEFAULT-SCROLL-DIRECTION-SENSITIVITY))

  ([last-scroll-x sensitivity]
   (< (+  last-scroll-x sensitivity)
      (-> js/document .-documentElement .-scrollLeft))))

(defn scroll-x-direction-rtl?
  ; @description
  ; Returns TRUE if the DOCUMENT element is scrolled leftward (right to left) based on the given last scroll X position.
  ;
  ; @param (px) last-scroll-x
  ; @param (px)(opt) sensitivity
  ; Default: 10
  ;
  ; @usage
  ; (scroll-x-direction-rtl? 420)
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([last-scroll-x]
   (scroll-x-direction-rtl? last-scroll-x config/DEFAULT-SCROLL-DIRECTION-SENSITIVITY))

  ([last-scroll-x sensitivity]
   (> (-  last-scroll-x sensitivity)
      (-> js/document .-documentElement .-scrollLeft))))

(defn scroll-y-direction-ttb?
  ; @description
  ; Returns TRUE if the DOCUMENT element is scrolled downward (top to bottom) based on the given last scroll Y position.
  ;
  ; @param (px) last-scroll-y
  ; @param (px)(opt) sensitivity
  ; Default: 10
  ;
  ; @usage
  ; (scroll-y-direction-ttb? 420)
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([last-scroll-y]
   (scroll-y-direction-ttb? last-scroll-y config/DEFAULT-SCROLL-DIRECTION-SENSITIVITY))

  ([last-scroll-y sensitivity]
   (< (+  last-scroll-y sensitivity)
      (-> js/document .-documentElement .-scrollTop))))

(defn scroll-y-direction-btt?
  ; @description
  ; Returns TRUE if the DOCUMENT element is scrolled upward (bottom to top) based on the given last scroll Y position.
  ;
  ; @param (px) last-scroll-y
  ; @param (px)(opt) sensitivity
  ; Default: 10
  ;
  ; @usage
  ; (scroll-y-direction-btt? 420)
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([last-scroll-y]
   (scroll-y-direction-btt? last-scroll-y config/DEFAULT-SCROLL-DIRECTION-SENSITIVITY))

  ([last-scroll-y sensitivity]
   (> (-  last-scroll-y sensitivity)
      (-> js/document .-documentElement .-scrollTop))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-scroll-x-direction
  ; @description
  ; Returns the direction in which the DOCUMENT element was scrolled based on the given last scroll X position.
  ;
  ; @param (px) last-scroll-x
  ; @param (px)(opt) sensitivity
  ; Default: 10
  ;
  ; @usage
  ; (get-scroll-x-direction 420)
  ; =>
  ; :ltr
  ;
  ; @return (keyword)
  ; :ltr, :rtl
  ([last-scroll-x]
   (get-scroll-x-direction last-scroll-x config/DEFAULT-SCROLL-DIRECTION-SENSITIVITY))

  ([last-scroll-x sensitivity]
   (cond (scroll-x-direction-ltr? last-scroll-x sensitivity) (-> :ltr)
         (scroll-x-direction-rtl? last-scroll-x sensitivity) (-> :rtl))))

(defn get-scroll-y-direction
  ; @description
  ; Returns the direction in which the DOCUMENT element was scrolled based on the given last scroll Y position.
  ;
  ; @param (px) last-scroll-y
  ; @param (px)(opt) sensitivity
  ; Default: 10
  ;
  ; @usage
  ; (get-scroll-y-direction 420)
  ; =>
  ; :btt
  ;
  ; @return (keyword)
  ; :btt, :ttb
  ([last-scroll-y]
   (get-scroll-y-direction last-scroll-y config/DEFAULT-SCROLL-DIRECTION-SENSITIVITY))

  ([last-scroll-y sensitivity]
   (cond ; If the last scroll Y position is negative, a bounce effect occurs at the top of the page.
         (math/negative?          last-scroll-y)             (-> :btt)
         (scroll-y-direction-ttb? last-scroll-y sensitivity) (-> :ttb)
         (scroll-y-direction-btt? last-scroll-y sensitivity) (-> :btt))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-scroll-x-progress
  ; @description
  ; Returns the scroll X distance of the DOCUMENT element (in percent).
  ;
  ; @usage
  ; (get-scroll-x-progress)
  ; =>
  ; 100
  ;
  ; @return (percent)
  []
  (let [viewport-width  (-> js/window   .-innerWidth)
        scroll-x        (-> js/document .-documentElement .-scrollLeft)
        document-width  (-> js/document .-documentElement .-scrollWidth)
        max-scroll-x    (- document-width viewport-width)
        scroll-progress (math/percent max-scroll-x scroll-x)]
      ; During DOM construction, the document width might be inaccurate, leading to scroll progress values outside the 0-100 range.
      (math/between scroll-progress 0 100)))

(defn get-scroll-y-progress
  ; @description
  ; Returns the scroll Y distance of the DOCUMENT element (in percent).
  ;
  ; @usage
  ; (get-scroll-y-progress)
  ; =>
  ; 100
  ;
  ; @return (percent)
  []
  (let [viewport-height (-> js/window   .-innerHeight)
        scroll-y        (-> js/document .-documentElement .-scrollTop)
        document-height (-> js/document .-documentElement .-scrollHeight)
        max-scroll-y    (- document-height viewport-height)
        scroll-progress (math/percent max-scroll-y scroll-y)]
      ; During DOM construction, the document height might be inaccurate, leading to scroll progress values outside the 0-100 range.
      (math/between scroll-progress 0 100)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-scroll-x!
  ; @description
  ; Sets the scroll X position of the DOCUMENT element to the given value.
  ;
  ; @param (px) scroll-x
  ;
  ; @usage
  ; (set-scroll-x! 420)
  [scroll-x]
  (-> js/document .-documentElement .-scrollLeft (set! scroll-x)))

(defn set-scroll-y!
  ; @description
  ; Sets the scroll Y position of the DOCUMENT element to the given value.
  ;
  ; @param (px) scroll-y
  ;
  ; @usage
  ; (set-scroll-y! 420)
  [scroll-y]
  (-> js/document .-documentElement .-scrollTop (set! scroll-y)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn scroll-to-element-left!
  ; @description
  ; Sets the scroll X position of the DOCUMENT element to the absolute X position of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (px)(opt) offset
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (scroll-to-element-left! my-element)
  ([element]
   (scroll-to-element-left! element 0))

  ([element offset]
   (let [absolute-x (position/get-element-absolute-x element)]
        (set-scroll-x! (+ offset absolute-x)))))

(defn scroll-to-element-right!
  ; @description
  ; Sets the scroll X position of the DOCUMENT element to the absolute X position + offset width of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (px)(opt) offset
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (scroll-to-element-right! my-element)
  ([element]
   (scroll-to-element-right! element 0))

  ([element offset]
   (let [absolute-x   (position/get-element-absolute-x     element)
         offset-width (dimensions/get-element-offset-width element)]
        (set-scroll-x! (+ offset absolute-x offset-width)))))

(defn scroll-to-element-top!
  ; @description
  ; Sets the scroll y position of the DOCUMENT element to the absolute Y position of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (px)(opt) offset
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (scroll-to-element-top! my-element)
  ([element]
   (scroll-to-element-top! element 0))

  ([element offset]
   (let [absolute-y (position/get-element-absolute-y element)]
        (set-scroll-y! (+ offset absolute-y)))))

(defn scroll-to-element-bottom!
  ; @description
  ; Sets the scroll y position of the DOCUMENT element to the absolute Y position + offset height of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (px)(opt) offset
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (scroll-to-element-bottom! my-element)
  ([element]
   (scroll-to-element-bottom! element 0))

  ([element offset]
   (let [absolute-y    (position/get-element-absolute-y      element)
         offset-height (dimensions/get-element-offset-height element)]
        (set-scroll-y! (+ offset absolute-y offset-height)))))

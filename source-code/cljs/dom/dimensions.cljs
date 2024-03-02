
(ns dom.dimensions
    (:require [fruits.math.api :as math]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-width
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-width my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .-offsetWidth))

(defn get-element-height
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-height my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .-offsetHeight))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-relative-left
  ; Relative position: relative to viewport position
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-relative-left my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .getBoundingClientRect .-left math/round))

(defn get-element-relative-top
  ; Relative position: relative to viewport position
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-relative-top my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .getBoundingClientRect .-top math/round))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-absolute-left
  ; Absolute position: relative to document position
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-absolute-left my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (math/round (+ (-> element     .getBoundingClientRect .-left)
                 (-> js/document .-documentElement .-scrollLeft))))

(defn get-element-absolute-top
  ; Absolute position: relative to document position
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-absolute-top my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (math/round (+ (-> element     .getBoundingClientRect .-top)
                 (-> js/document .-documentElement .-scrollTop))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-offset-left
  ; Offset position: relative to parent position
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-offset-left my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .-offsetLeft math/round))

(defn get-element-offset-top
  ; Offset position: relative to parent position
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-offset-top my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .-offsetTop math/round))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-mass-point-x
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-mass-point-x my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (math/round (+ (-> element     .-offsetWidth (/ 2))
                 (-> element     .getBoundingClientRect .-left)
                 (-> js/document .-documentElement      .-scrollLeft))))

(defn get-element-mass-point-y
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-mass-point-y my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (math/round (+ (-> element     .-offsetHeight (/ 2))
                 (-> element     .getBoundingClientRect .-left)
                 (-> js/document .-documentElement      .-scrollTop))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-on-viewport-left?
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-on-viewport-left? my-element)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [element]
  (<= (+ (-> element     .-offsetWidth (/ 2))
         (-> element     .getBoundingClientRect .-left)
         (-> js/document .-documentElement      .-scrollLeft))
      (-> js/window .-innerWidth (/ 2))))

(defn element-on-viewport-right?
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-on-viewport-right? my-element)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [element]
  (> (+ (-> element     .-offsetWidth (/ 2))
        (-> element     .getBoundingClientRect .-left)
        (-> js/document .-documentElement      .-scrollLeft))
     (-> js/window .-innerWidth (/ 2))))

(defn element-on-viewport-top?
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-on-viewport-top? my-element)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [element]
  (<= (+ (-> element     .-offsetHeight (/ 2))
         (-> element     .getBoundingClientRect .-left)
         (-> js/document .-documentElement      .-scrollTop))
      (-> js/window .-innerWidth (/ 2))))

(defn element-on-viewport-bottom?
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-on-viewport-bottom? my-element)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [element]
  (> (+ (-> element     .-offsetHeight (/ 2))
        (-> element     .getBoundingClientRect .-left)
        (-> js/document .-documentElement      .-scrollTop))
     (-> js/window .-innerWidth (/ 2))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-mass-point-orientation
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-mass-point-orientation my-element)
  ; =>
  ; :tl
  ;
  ; @return (keyword)
  ; :bl, :br, :tl, :tr
  [element]
  (if (element-on-viewport-bottom? element)
      (if (element-on-viewport-left? element) :bl :br)
      (if (element-on-viewport-left? element) :tl :tr)))


(ns dom.position
    (:require [fruits.math.api :as math]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-relative-x
  ; @description
  ; Returns the relative X position (relative to the viewport) of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-relative-x my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .getBoundingClientRect .-left math/round))

(defn get-element-relative-y
  ; @description
  ; Returns the relative Y position (relative to the viewport) of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-relative-y my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .getBoundingClientRect .-top math/round))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-absolute-x
  ; @description
  ; Returns the absolute X position (relative to the document) of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-absolute-x my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (math/round (+ (-> element     .getBoundingClientRect .-left)
                 (-> js/document .-documentElement .-scrollLeft))))

(defn get-element-absolute-y
  ; @description
  ; Returns the absolute Y position (relative to the document) of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-absolute-y my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (math/round (+ (-> element     .getBoundingClientRect .-top)
                 (-> js/document .-documentElement .-scrollTop))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-offset-x
  ; @description
  ; Returns the offset X position (relative to the parent) of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-offset-x my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .-offsetLeft math/round))

(defn get-element-offset-y
  ; @description
  ; Returns the offset Y position (relative to the parent) of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-offset-y my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .-offsetTop math/round))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-mass-point-x
  ; @description
  ; Returns the relative X position (relative to the viewport) of the mass point of the given element.
  ;
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
  (math/round (+ (-> element .-offsetWidth (/ 2))
                 (-> element .getBoundingClientRect .-left))))

(defn get-element-mass-point-y
  ; @description
  ; Returns the relative Y position (relative to the viewport) of the mass point of the given element.
  ;
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
  (math/round (+ (-> element .-offsetHeight (/ 2))
                 (-> element .getBoundingClientRect .-top))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-on-viewport-left?
  ; @description
  ; Returns TRUE if the mass point of the given element is on the left side of the viewport.
  ;
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
  (let [mass-point-x (get-element-mass-point-x element)]
       (<= mass-point-x (-> js/window .-innerWidth (/ 2)))))

(defn element-on-viewport-right?
  ; @description
  ; Returns TRUE if the mass point of the given element is on the right side of the viewport.
  ;
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
  (let [mass-point-x (get-element-mass-point-x element)]
       (> mass-point-x (-> js/window .-innerWidth (/ 2)))))

(defn element-on-viewport-top?
  ; @description
  ; Returns TRUE if the mass point of the given element is on the top side of the viewport.
  ;
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
  (let [mass-point-y (get-element-mass-point-y element)]
       (<= mass-point-y (-> js/window .-innerWidth (/ 2)))))

(defn element-on-viewport-bottom?
  ; @description
  ; Returns TRUE if the mass point of the given element is on the bottom side of the viewport.
  ;
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
  (let [mass-point-y (get-element-mass-point-y element)]
       (> mass-point-y (-> js/window .-innerWidth (/ 2)))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-mass-point-orientation
  ; @description
  ; Returns which quarter of the viewport is the given element's mass point in.
  ;
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

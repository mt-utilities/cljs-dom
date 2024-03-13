
(ns dom.mouse
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-mouse-x
  ; @description
  ; Returns the X position of the given mouse event.
  ;
  ; @param (DOM Event object) mouse-event
  ;
  ; @usage
  ; (fn [my-mouse-event]
  ;     (get-mouse-x my-mouse-event))
  ; =>
  ; 420
  ;
  ; @return (px)
  [mouse-event]
  (-> mouse-event .-clientX))

(defn get-mouse-y
  ; @description
  ; Returns the Y position of the given mouse event.
  ;
  ; @param (DOM Event object) mouse-event
  ;
  ; @usage
  ; (fn [my-mouse-event]
  ;     (get-mouse-y my-mouse-event))
  ; =>
  ; 420
  ;
  ; @return (px)
  [mouse-event]
  (-> mouse-event .-clientY))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-mouse-viewport-quarter
  ; @description
  ; Returns in which viewport quarter was the given mouse event dispatched.
  ;
  ; @param (DOM Event object) mouse-event
  ;
  ; @usage
  ; (fn [my-mouse-event]
  ;     (get-mouse-viewport-quarter my-mouse-event))
  ; =>
  ; :tl
  ;
  ; @return (keyword)
  ; :tl, :tr, :bl, :br
  [mouse-event]
  (let [half-viewport-height (-> js/window .-innerHeight (/ 2))
        half-viewport-width  (-> js/window .-innerWidth  (/ 2))
        mouse-x              (.-clientX mouse-event)
        mouse-y              (.-clientY mouse-event)]
       (cond (and (< mouse-x half-viewport-width)
                  (< mouse-y half-viewport-height))
             :tl
             (and (>= mouse-x half-viewport-width)
                  (<  mouse-y half-viewport-height))
             :tr
             (< mouse-x half-viewport-width)
             :bl :return :br)))

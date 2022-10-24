
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns dom.viewport
    (:require [mid-fruits.candy :refer [return]]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-viewport-height
  ; @usage
  ;  (get-viewport-height)
  ;
  ; @return (px)
  []
  (.-innerHeight js/window))

(defn get-viewport-width
  ; @usage
  ;  (get-viewport-width)
  ;
  ; @return (px)
  []
  (.-innerWidth js/window))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-viewport-orientation
  ; @usage
  ;  (get-viewport-orientation)
  ;
  ; @return (keyword)
  ;  :landscape, :portrait
  []
  (if (> (.-innerHeight js/window)
         (.-innerWidth  js/window))
      (return :portrait)
      (return :landscape)))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn square-viewport?
  ; @usage
  ;  (square-viewport?)
  ;
  ; @return (boolean)
  []
  (= (.-innerHeight js/window)
     (.-innerWidth  js/window)))

(defn landscape-viewport?
  ; @usage
  ;  (landscape-viewport?)
  ;
  ; @return (boolean)
  []
  (< (.-innerHeight js/window)
     (.-innerWidth  js/window)))

(defn portrait-viewport?
  ; @usage
  ;  (portrait-viewport?)
  ;
  ; @return (boolean)
  []
  (> (.-innerHeight js/window)
     (.-innerWidth  js/window)))

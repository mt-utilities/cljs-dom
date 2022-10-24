
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns dom.units
    (:require [mid-fruits.math :as math]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn px->vh
  ; @param (px) n
  ;
  ; @usage
  ;  (px->vh 420)
  ;
  ; @return (vh)
  [n]
  (-> n (/ (-> js/window .-innerHeight (/ 100))) math/floor))

(defn px->vw
  ; @param (px) n
  ;
  ; @usage
  ;  (px->vw 420)
  ;
  ; @return (vw)
  [n]
  (-> n (/ (-> js/window .-innerWidth (/ 100))) math/floor))

(defn vh->px
  ; @param (vh) n
  ;
  ; @usage
  ;  (vh->px 42)
  ;
  ; @return (px)
  [n]
  (-> n (* (-> js/window .-innerHeight (/ 100))) math/floor))

(defn vw->px
  ; @param (vw) n
  ;
  ; @usage
  ;  (vw->px 42)
  ;
  ; @return (px)
  [n]
  (-> n (* (-> js/window .-innerWidth (/ 100))) math/floor))

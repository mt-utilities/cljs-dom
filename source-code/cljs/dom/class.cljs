
(ns dom.class
    (:require [candy.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-element-class!
  ; @param (DOM-element) element
  ; @param (string) class-name
  ;
  ; @usage
  ;  (set-element-class! my-element "my-class")
  ;
  ; @return (DOM-element)
  [element class-name]
  (->     element .-classList (.add class-name))
  (return element))

(defn remove-element-class!
  ; @param (DOM-element) element
  ; @param (string) class-name
  ;
  ; @usage
  ;  (remove-element-class! my-element "my-class")
  ;
  ; @return (DOM-element)
  [element class-name]
  (->     element .-classList (.remove class-name))
  (return element))

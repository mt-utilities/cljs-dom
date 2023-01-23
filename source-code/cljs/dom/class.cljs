
(ns dom.class
    (:require [noop.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-element-class!
  ; @param (DOM-element) element
  ; @param (string) class-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-class! my-element "my-class")
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
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-class! my-element "my-class")
  ;
  ; @return (DOM-element)
  [element class-name]
  (->     element .-classList (.remove class-name))
  (return element))

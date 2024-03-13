
(ns dom.class
    (:require [dom.utils :as utils]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-element-class!
  ; @description
  ; Appends the given class name to the class list of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) class-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-class! my-element "my-class")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element class-name]
  (-> element .-classList (.add (utils/normalize class-name)))
  (-> element))

(defn remove-element-class!
  ; @description
  ; Removes the given class name from the class list of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) class-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-class! my-element "my-class")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element class-name]
  (-> element .-classList (.remove (utils/normalize class-name)))
  (-> element))

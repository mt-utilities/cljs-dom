
(ns dom.style
    (:require [fruits.css.api :as css]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-style
  ; @important
  ; This function is incomplete and may not behave as expected.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-style my-element)
  ; =>
  ; ?
  ;
  ; @return (?)
  [element])
  ; TODO

(defn set-element-style!
  ; @param (DOM Element object) element
  ; @param (map) style
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-style! my-element {:position "fixed" :top "0"})
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element style]
  (let [parsed-style (css/unparse style)]
       (-> element (.setAttribute "style" parsed-style))
       (-> element)))

(defn remove-element-style!
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-style! my-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element]
  (-> element (.removeAttribute "style"))
  (-> element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-style-value
  ; @param (DOM Element object) element
  ; @param (string) style-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-style my-element "background-color")
  ; =>
  ; "white"
  ;
  ; @return (string)
  [element style-name]
  (-> js/window (.getComputedStyle element)
                (aget style-name)))

(defn set-element-style-value!
  ; @param (DOM Element object) element
  ; @param (string) style-name
  ; @param (*) style-value
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-style-value! my-element "background-color" "white")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element style-name style-value]
  (-> element .-style (aset style-name style-value))
  (-> element))

(defn remove-element-style-value!
  ; @param (DOM Element object) element
  ; @param (string) style-name

  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-style-value! my-element "background-color")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element style-name]
  (-> element .-style (aset style-name nil))
  (-> element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-computed-style
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-computed-style my-element)
  ; =>
  ; #object[CSSStyleDeclaration]
  ;
  ; @return (CSSStyleDeclarationObject)
  [element]
  (.getComputedStyle js/window element))

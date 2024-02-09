
(ns dom.style
    (:require [fruits.css.api :as css]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-style
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-style my-element)
  [element])
  ; ...

(defn set-element-style!
  ; @param (DOM Element object) element
  ; @param (map) style
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-style! my-element {:position "fixed" :top "0"})
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
  ; (get-element-style my-element "position")
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
  ; (set-element-style-value! my-element "position" "fixed")
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
  ; (remove-element-style-value! my-element "position")
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
  ;
  ; @return (CSSStyleDeclarationObject)
  ; The returned object updates automatically when the element's styles are changed
  [element]
  (.getComputedStyle js/window element))

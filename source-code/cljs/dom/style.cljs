
(ns dom.style
    (:require [candy.api :refer [return]]
              [css.api :as css]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-style
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (get-element-style my-element)
  [element])
  ; ...

(defn set-element-style!
  ; @param (DOM-element) element
  ; @param (map) style
  ;
  ; @usage
  ; (set-element-style! my-element {:position "fixed" :top "0"})
  ;
  ; @return (DOM-element)
  [element style]
  (let [parsed-style (css/unparse style)]
       (.setAttribute element "style" parsed-style))
  (return element))

(defn remove-element-style!
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (remove-element-style! my-element)
  ;
  ; @return (DOM-element)
  [element]
  (.removeAttribute element "style")
  (return           element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-style-value
  ; @param (DOM-element) element
  ; @param (string) style-name
  ;
  ; @usage
  ; (get-element-style my-element "position")
  ;
  ; @return (string)
  [element style-name]
  (-> js/window (.getComputedStyle element)
                (aget style-name)))

(defn set-element-style-value!
  ; @param (DOM-element) element
  ; @param (string) style-name
  ; @param (*) style-value
  ;
  ; @usage
  ; (set-element-style-value! my-element "position" "fixed")
  ;
  ; @return (DOM-element)
  [element style-name style-value]
  (->     element .-style (aset style-name style-value))
  (return element))

(defn remove-element-style-value!
  ; @param (DOM-element) element
  ; @param (string) style-name

  ; @usage
  ; (remove-element-style-value! my-element "position")
  ;
  ; @return (DOM-element)
  [element style-name]
  (->     element .-style (aset style-name nil))
  (return element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-computed-style
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (get-element-computed-style my-element)
  ;
  ; @return (CSSStyleDeclarationObject)
  ; The returned object updates automatically when the element's styles are changed
  [element]
  (.getComputedStyle js/window element))

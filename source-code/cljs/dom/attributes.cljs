
(ns dom.attributes
    (:require [noop.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-attributes
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-attributes my-element)
  ;
  ; @return (map)
  [element]
  (.getAttributes element))

(defn set-element-attributes!
  ; @param (DOM-element) element
  ; @param (map) attributes
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-attributes! my-element {"my-attribute" "my-value"})
  ;
  ; @return (DOM-element)
  [element attributes]
  (letfn [(f [_ attribute-name attribute-value]
             (if (keyword? attribute-name)
                 (.setAttribute element (name attribute-name) attribute-value)
                 (.setAttribute element       attribute-name  attribute-value)))]
         (reduce-kv f nil attributes))
  (return element))

(defn remove-element-attributes!
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-attribute! my-element)
  ;
  ; @return (DOM-element)
  [element]
  (.removeAttributes element)
  (return            element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-attribute
  ; @param (DOM-element) element
  ; @param (string) attribute-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-attribute my-element "my-attribute")
  ;
  ; @return (string)
  [element attribute-name]
  (.getAttribute element attribute-name))

(defn set-element-attribute!
  ; @param (DOM-element) element
  ; @param (string) attribute-name
  ; @param (string) attribute-value
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-attribute! my-element "my-attribute" "my-value")
  ;
  ; @return (DOM-element)
  [element attribute-name attribute-value]
  (.setAttribute element attribute-name attribute-value)
  (return        element))

(defn remove-element-attribute!
  ; @param (DOM-element) element
  ; @param (string) attribute-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-attribute! my-element "my-attribute")
  ;
  ; @return (DOM-element)
  [element attribute-name]
  (.removeAttribute element attribute-name)
  (return           element))


(ns dom.attributes
    (:require [candy.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-attributes
  ; @param (DOM-element) element
  ;
  ; @usage
  ;  (get-element-attribute my-element)
  ;
  ; @return (map)
  [element]
  (.getAttributes element))

(defn set-element-attributes!
  ; @param (DOM-element) element
  ; @param (map) attributes
  ;
  ; @usage
  ;  (set-element-attributes! my-element {"my-attribute" "my-value"})
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
  ;  (remove-element-attribute! my-element)
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
  ;  (get-element-attribute my-element "my-attribute")
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
  ;  (set-element-attribute! my-element "my-attribute" "my-value")
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
  ;  (remove-element-attribute! my-element "my-attribute")
  ;
  ; @return (DOM-element)
  [element attribute-name]
  (.removeAttribute element attribute-name)
  (return           element))

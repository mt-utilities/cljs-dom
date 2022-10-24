
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns dom.attribute)



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
  ; @return (undefined)
  [element attribute-name attribute-value]
  (.setAttribute element attribute-name attribute-value))

(defn remove-element-attribute!
  ; @param (DOM-element) element
  ; @param (string) attribute-name
  ;
  ; @usage
  ;  (remove-element-attribute! my-element "my-attribute")
  ;
  ; @return (undefined)
  [element attribute-name]
  (.removeAttribute element attribute-name))

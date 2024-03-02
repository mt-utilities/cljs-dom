
(ns dom.attributes)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-attributes
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-attributes my-element)
  ;
  ; @return (map)
  [element]
  (-> element .getAttributes))

(defn set-element-attributes!
  ; @param (DOM Element object) element
  ; @param (map) attributes
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-attributes! my-element {"my-attribute" "My value"})
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element attributes]
  (letfn [(f0 [_ attribute-name attribute-value]
              (if (keyword? attribute-name)
                  (.setAttribute element (name attribute-name) attribute-value)
                  (.setAttribute element       attribute-name  attribute-value)))]
         (reduce-kv f0 nil attributes))
  (-> element))

(defn remove-element-attributes!
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-attribute! my-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element]
  (-> element .removeAttributes)
  (-> element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-attribute
  ; @param (DOM Element object) element
  ; @param (string) attribute-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-attribute my-element "my-attribute")
  ; =>
  ; "My value"
  ;
  ; @return (string)
  [element attribute-name]
  (-> element (.getAttribute attribute-name)))

(defn set-element-attribute!
  ; @param (DOM Element object) element
  ; @param (string) attribute-name
  ; @param (string) attribute-value
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-attribute! my-element "my-attribute" "My value")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element attribute-name attribute-value]
  (-> element (.setAttribute attribute-name attribute-value))
  (-> element))

(defn remove-element-attribute!
  ; @param (DOM Element object) element
  ; @param (string) attribute-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-attribute! my-element "my-attribute")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element attribute-name]
  (-> element (.removeAttribute attribute-name))
  (-> element))

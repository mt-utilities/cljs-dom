
(ns dom.attributes
    (:require [dom.utils :as utils]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-attribute-names
  ; @description
  ; Returns the attributes of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-attribute-names my-element)
  ; =>
  ; ["class" "id"]
  ;
  ; @return (strings in vector)
  [element]
  (-> element .getAttributeNames vec))

(defn get-element-attributes
  ; @description
  ; Returns the attributes of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-attributes my-element)
  ; =>
  ; {"class" "my-class"
  ;  "id"    "my-element"}
  ;
  ; @return (map)
  [element]
  (let [attribute-names (get-element-attribute-names element)]
       (letfn [(f0 [attributes attribute-name]
                   (assoc attributes attribute-name (.getAttribute element attribute-name)))]
              (reduce f0 {} attribute-names))))

(defn remove-element-attributes!
  ; @description
  ; Removes the attributes of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-attributes! my-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element]
  (-> element .removeAttributes)
  (-> element))

(defn merge-element-attributes!
  ; @description
  ; Merges the given attributes map onto the attributes of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (map) attributes
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (merge-element-attributes! my-element {"my-attribute" "My value"})
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element attributes]
  (doseq [[attribute-name attribute-value] attributes]
         (-> element (.setAttribute (utils/normalize attribute-name)
                                    (utils/normalize attribute-value))))
  (-> element))

(defn set-element-attributes!
  ; @description
  ; Sets the given attributes as the attributes of the given element.
  ;
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
  (-> element (remove-element-attributes!))
  (-> element (merge-element-attributes! attributes))
  (-> element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-attribute
  ; @description
  ; Returns a specific attribute of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) attribute-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-attribute my-element "my-attribute")
  ; =>
  ; "My value"
  ;
  ; @return (string)
  [element attribute-name]
  (-> element (.getAttribute (utils/normalize attribute-name))))

(defn remove-element-attribute!
  ; @description
  ; Removes a specific attribute of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) attribute-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-attribute! my-element "my-attribute")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element attribute-name]
  (-> element (.removeAttribute (utils/normalize attribute-name)))
  (-> element))

(defn set-element-attribute!
  ; @description
  ; Updates a specific attribute of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) attribute-name
  ; @param (keyword or string) attribute-value
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-attribute! my-element "my-attribute" "My value")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element attribute-name attribute-value]
  (-> element (.setAttribute (utils/normalize attribute-name)
                             (utils/normalize attribute-value)))
  (-> element))

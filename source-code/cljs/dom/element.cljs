
(ns dom.element
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element->tag-name
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element->tag-name my-element)
  ; =>
  ; "div"
  ;
  ; @return (string)
  [element]
  (if-let [tag-name (.-tagName element)]
          (string/to-lowercase tag-name)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-by-id
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (string) element-id
  ;
  ; @usage
  ; (get-element-by-id "my-element")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object or nil)
  ([element-id]                (-> js/document    (.getElementById element-id)))
  ([parent-element element-id] (-> parent-element (.getElementById element-id))))

(defn get-element-by-class-name
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (string) class-name
  ;
  ; @usage
  ; (get-element-by-class-name "my-class")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  ([class-name]                (-> js/document    (.getElementsByClassName class-name) array-seq vec first))
  ([parent-element class-name] (-> parent-element (.getElementsByClassName class-name) array-seq vec first)))

(defn get-elements-by-class-name
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (string) class-name
  ;
  ; @usage
  ; (get-elements-by-class-name "my-class")
  ; =>
  ; [#object[HTMLDivElement] #object[HTMLDivElement]]
  ;
  ; @return (DOM Element objects in vector)
  ([class-name]                (-> js/document    (.getElementsByClassName class-name) array-seq vec))
  ([parent-element class-name] (-> parent-element (.getElementsByClassName class-name) array-seq vec)))

(defn get-element-by-tag-name
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (string) tag-name
  ;
  ; @usage
  ; (get-element-by-class-name "div")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  ([tag-name]                (-> js/document    (.getElementsByTagName tag-name) array-seq vec first))
  ([parent-element tag-name] (-> parent-element (.getElementsByTagName tag-name) array-seq vec first)))

(defn get-elements-by-tag-name
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (string) tag-name
  ;
  ; @usage
  ; (get-elements-by-class-name "div")
  ; =>
  ; [#object[HTMLDivElement] #object[HTMLDivElement]]
  ;
  ; @return (DOM Element objects in vector)
  ([tag-name]                (-> js/document    (.getElementsByTagName tag-name) array-seq vec))
  ([parent-element tag-name] (-> parent-element (.getElementsByTagName tag-name) array-seq vec)))

(defn get-element-by-query
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (string) query
  ;
  ; @usage
  ; (get-element-by-query ":scope > div")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @usage
  ; (get-element-by-query "[type=\"text/css\"]")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @usage
  ; (get-element-by-query "div.my-class, div.another-class")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  ([query]                (-> js/document    (.querySelector query)))
  ([parent-element query] (-> parent-element (.querySelector query))))

(defn get-elements-by-query
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (string) query
  ;
  ; @usage
  ; (get-elements-by-query ":scope > div")
  ; =>
  ; [#object[HTMLDivElement] #object[HTMLDivElement]]
  ;
  ; @usage
  ; (get-elements-by-query "[type=\"text/css\"]")
  ; =>
  ; [#object[HTMLDivElement] #object[HTMLDivElement]]
  ;
  ; @usage
  ; (get-elements-by-query "div.my-class, div.another-class")
  ; =>
  ; [#object[HTMLDivElement] #object[HTMLDivElement]]
  ;
  ; @return (DOM Element objects in vector)
  ([query]                (-> js/document    (.querySelectorAll query) array-seq vec))
  ([parent-element query] (-> parent-element (.querySelectorAll query) array-seq vec)))

(defn get-element-by-attribute
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (string) attribute-name
  ; @param (string) attribute-value
  ;
  ; @usage
  ; (get-element-by-attribute "my-attribute" "My value")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  ([attribute-name attribute-value]                (get-element-by-query                (str "["attribute-name"="attribute-value"]")))
  ([parent-element attribute-name attribute-value] (get-element-by-query parent-element (str "["attribute-name"="attribute-value"]"))))

(defn get-elements-by-attribute
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (string) attribute-name
  ; @param (string) attribute-value
  ;
  ; @usage
  ; (get-elements-by-attribute "my-attribute" "My value")
  ; =>
  ; [#object[HTMLDivElement] #object[HTMLDivElement]]
  ;
  ; @return (DOM Element objects in vector)
  ([attribute-name attribute-value]                (get-elements-by-query                (str "["attribute-name"="attribute-value"]")))
  ([parent-element attribute-name attribute-value] (get-elements-by-query parent-element (str "["attribute-name"="attribute-value"]"))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-disabled?
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-disabled? my-element)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [element]
  (-> element .-disabled boolean))

(defn element-enabled?
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-enabled? my-element)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [element]
  (-> element .-disabled not))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-element-id!
  ; @param (DOM Element object) element
  ; @param (string) element-id
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-id! my-element "my-element-id")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element element-id]
  (-> element .-id (set! element-id))
  (-> element))

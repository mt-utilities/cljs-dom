
(ns dom.element
    (:require [noop.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-by-id
  ; @param (DOM-element)(opt) parent-element
  ; Default: js/document
  ; @param (string) element-id
  ;
  ; @usage
  ; (get-element-by-id "my-element")
  ;
  ; @return (DOM-element or nil)
  ([element-id]                (.getElementById js/document    element-id))
  ([parent-element element-id] (.getElementById parent-element element-id)))

(defn get-element-by-class-name
  ; @param (DOM-element)(opt) parent-element
  ; Default: js/document
  ; @param (string) class-name
  ;
  ; @usage
  ; (get-element-by-class-name "my-class")
  ;
  ; @return (DOM-element)
  ([class-name]                (-> js/document    (.getElementsByClassName class-name) array-seq vec first))
  ([parent-element class-name] (-> parent-element (.getElementsByClassName class-name) array-seq vec first)))

(defn get-elements-by-class-name
  ; @param (DOM-element)(opt) parent-element
  ; Default: js/document
  ; @param (string) class-name
  ;
  ; @usage
  ; (get-elements-by-class-name "my-class")
  ;
  ; @return (vector)
  ([class-name]                (-> js/document    (.getElementsByClassName class-name) array-seq vec))
  ([parent-element class-name] (-> parent-element (.getElementsByClassName class-name) array-seq vec)))

(defn get-element-by-tag-name
  ; @param (DOM-element)(opt) parent-element
  ; Default: js/document
  ; @param (string) tag-name
  ;
  ; @usage
  ; (get-element-by-class-name "div")
  ;
  ; @return (DOM-element)
  ([tag-name]                (-> js/document    (.getElementsByTagName tag-name) array-seq vec first))
  ([parent-element tag-name] (-> parent-element (.getElementsByTagName tag-name) array-seq vec first)))

(defn get-elements-by-tag-name
  ; @param (DOM-element)(opt) parent-element
  ; Default: js/document
  ; @param (string) tag-name
  ;
  ; @usage
  ; (get-elements-by-class-name "div")
  ;
  ; @return (vector)
  ([tag-name]                (-> js/document    (.getElementsByTagName tag-name) array-seq vec))
  ([parent-element tag-name] (-> parent-element (.getElementsByTagName tag-name) array-seq vec)))

(defn get-element-by-query
  ; @param (DOM-element)(opt) parent-element
  ; Default: js/document
  ; @param (string) query
  ;
  ; @usage
  ; (get-element-by-query ":scope > div")
  ;
  ; @usage
  ; (get-element-by-query "[type=\"text/css\"]")
  ;
  ; @usage
  ; (get-element-by-query "div.my-class, div.your-class")
  ;
  ; @return (DOM-element)
  ([query]                (-> js/document    (.querySelector query)))
  ([parent-element query] (-> parent-element (.querySelector query))))

(defn get-elements-by-query
  ; @param (DOM-element)(opt) parent-element
  ; Default: js/document
  ; @param (string) query
  ;
  ; @usage
  ; (get-elements-by-query ":scope > div")
  ;
  ; @usage
  ; (get-elements-by-query "[type=\"text/css\"]")
  ;
  ; @usage
  ; (get-elements-by-query "div.my-class, div.your-class")
  ;
  ; @return (vector)
  ([query]                (-> js/document    (.querySelectorAll query) array-seq vec))
  ([parent-element query] (-> parent-element (.querySelectorAll query) array-seq vec)))

(defn get-element-by-attribute
  ; @param (DOM-element)(opt) parent-element
  ; Default: js/document
  ; @param (string) attribute-name
  ; @param (string) attribute-value
  ;
  ; @usage
  ; (get-element-by-attribute "my-attribute" "My value")
  ;
  ; @return (DOM-element)
  ([attribute-name attribute-value]                (get-element-by-query                (str "["attribute-name"="attribute-value"]")))
  ([parent-element attribute-name attribute-value] (get-element-by-query parent-element (str "["attribute-name"="attribute-value"]"))))

(defn get-elements-by-attribute
  ; @param (DOM-element)(opt) parent-element
  ; Default: js/document
  ; @param (string) attribute-name
  ; @param (string) attribute-value
  ;
  ; @usage
  ; (get-elements-by-attribute "my-attribute" "My value")
  ;
  ; @return (vector)
  ([attribute-name attribute-value]                (get-elements-by-query                (str "["attribute-name"="attribute-value"]")))
  ([parent-element attribute-name attribute-value] (get-elements-by-query parent-element (str "["attribute-name"="attribute-value"]"))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-disabled?
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-disabled? my-element)
  ;
  ; @return (boolean)
  [element]
  (-> element .-disabled boolean))

(defn element-enabled?
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-enabled? my-element)
  ;
  ; @return (boolean)
  [element]
  (-> element .-disabled not))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-element-id!
  ; @param (DOM-element) element
  ; @param (string) element-id
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-id! my-element "my-element-id")
  ;
  ; @return (DOM-element)
  [element element-id]
  (->     element .-id (set! element-id))
  (return element))

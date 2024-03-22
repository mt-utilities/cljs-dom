
(ns dom.element
    (:require [dom.utils         :as utils]
              [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-tag-name
  ; @description
  ; Returns the tag name of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-tag-name my-element)
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
  ; @description
  ; Returns the first element found by the given ID.
  ;
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (keyword or string) element-id
  ;
  ; @usage
  ; (get-element-by-id "my-element")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  ([element-id]                (-> js/document    (.getElementById (utils/normalize element-id))))
  ([parent-element element-id] (-> parent-element (.getElementById (utils/normalize element-id)))))

(defn get-element-by-class-name
  ; @description
  ; Returns the first element found by the given class name.
  ;
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (keyword or string) class-name
  ;
  ; @usage
  ; (get-element-by-class-name "my-class")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  ([class-name]                (-> js/document    (.getElementsByClassName (utils/normalize class-name)) array-seq vec first))
  ([parent-element class-name] (-> parent-element (.getElementsByClassName (utils/normalize class-name)) array-seq vec first)))

(defn get-elements-by-class-name
  ; @description
  ; Returns the elements found by the given class name.
  ;
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (keyword or string) class-name
  ;
  ; @usage
  ; (get-elements-by-class-name "my-class")
  ; =>
  ; [#object[HTMLDivElement] #object[HTMLDivElement]]
  ;
  ; @return (DOM Element objects in vector)
  ([class-name]                (-> js/document    (.getElementsByClassName (utils/normalize class-name)) array-seq vec))
  ([parent-element class-name] (-> parent-element (.getElementsByClassName (utils/normalize class-name)) array-seq vec)))

(defn get-element-by-tag-name
  ; @description
  ; Returns the first element found by the given tag name.
  ;
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (keyword or string) tag-name
  ;
  ; @usage
  ; (get-element-by-tag-name "div")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  ([tag-name]                (-> js/document    (.getElementsByTagName (utils/normalize tag-name)) array-seq vec first))
  ([parent-element tag-name] (-> parent-element (.getElementsByTagName (utils/normalize tag-name)) array-seq vec first)))

(defn get-elements-by-tag-name
  ; @description
  ; Returns the elements found by the given tag name.
  ;
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (keyword or string) tag-name
  ;
  ; @usage
  ; (get-elements-by-tag-name "div")
  ; =>
  ; [#object[HTMLDivElement] #object[HTMLDivElement]]
  ;
  ; @return (DOM Element objects in vector)
  ([tag-name]                (-> js/document    (.getElementsByTagName (utils/normalize tag-name)) array-seq vec))
  ([parent-element tag-name] (-> parent-element (.getElementsByTagName (utils/normalize tag-name)) array-seq vec)))

(defn get-element-by-query
  ; @description
  ; Returns the first element found by the given query.
  ;
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (keyword or string) query
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
  ([query]                (-> js/document    (.querySelector (utils/normalize query))))
  ([parent-element query] (-> parent-element (.querySelector (utils/normalize query)))))

(defn get-elements-by-query
  ; @description
  ; Returns the elements found by the given query.
  ;
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (keyword or string) query
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
  ([query]                (-> js/document    (.querySelectorAll (utils/normalize query)) array-seq vec))
  ([parent-element query] (-> parent-element (.querySelectorAll (utils/normalize query)) array-seq vec)))

(defn get-element-by-attribute
  ; @description
  ; Returns the first element found by the given attribute.
  ;
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (keyword or string) attribute-name
  ; @param (keyword or string) attribute-value
  ;
  ; @usage
  ; (get-element-by-attribute "my-attribute" "My value")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  ([attribute-name attribute-value]                (get-element-by-query                (str "["(utils/normalize attribute-name)"="(utils/normalize attribute-value)"]")))
  ([parent-element attribute-name attribute-value] (get-element-by-query parent-element (str "["(utils/normalize attribute-name)"="(utils/normalize attribute-value)"]"))))

(defn get-elements-by-attribute
  ; @description
  ; Returns the elements found by the given attribute.
  ;
  ; @param (DOM Element object)(opt) parent-element
  ; Default: js/document
  ; @param (keyword or string) attribute-name
  ; @param (keyword or string) attribute-value
  ;
  ; @usage
  ; (get-elements-by-attribute "my-attribute" "My value")
  ; =>
  ; [#object[HTMLDivElement] #object[HTMLDivElement]]
  ;
  ; @return (DOM Element objects in vector)
  ([attribute-name attribute-value]                (get-elements-by-query                (str "["(utils/normalize attribute-name)"="(utils/normalize attribute-value)"]")))
  ([parent-element attribute-name attribute-value] (get-elements-by-query parent-element (str "["(utils/normalize attribute-name)"="(utils/normalize attribute-value)"]"))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-disabled?
  ; @description
  ; Returns TRUE if the given element is disabled.
  ;
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
  ; @description
  ; Returns TRUE if the given element is NOT disabled.
  ;
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
  ; @description
  ; Updates the ID of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) element-id
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-id! my-element "my-element-id")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element element-id]
  (-> element .-id (set! (utils/normalize element-id)))
  (-> element))


(ns dom.element
    (:require [candy.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-by-id
  ; @param (DOM-element)(opt) parent-element
  ;  Default: js/document
  ; @param (string) element-id
  ;
  ; @usage
  ;  (get-element-by-id "my-element")
  ;
  ; @return (DOM-element or nil)
  ([element-id]                (.getElementById js/document    element-id))
  ([parent-element element-id] (.getElementById parent-element element-id)))

(defn get-elements-by-class-name
  ; @param (DOM-element)(opt) parent-element
  ;  Default: js/document
  ; @param (string) class-name
  ;
  ; @usage
  ;  (get-elements-by-class-name "my-class")
  ;
  ; @return (vector)
  ([class-name]                (-> js/document    (.getElementsByClassName class-name) array-seq vec))
  ([parent-element class-name] (-> parent-element (.getElementsByClassName class-name) array-seq vec)))

(defn get-elements-by-tag-name
  ; @param (DOM-element)(opt) parent-element
  ;  Default: js/document
  ; @param (string) tag-name
  ;
  ; @usage
  ;  (get-elements-by-class-name "div")
  ;
  ; @return (vector)
  ([tag-name]                (-> js/document    (.getElementsByTagName tag-name) array-seq vec))
  ([parent-element tag-name] (-> parent-element (.getElementsByTagName tag-name) array-seq vec)))

(defn get-element-by-query
  ; @param (DOM-element)(opt) parent-element
  ;  Default: js/document
  ; @param (string) query
  ;
  ; @usage
  ;  (get-element-by-query ":scope > div")
  ;
  ; @usage
  ;  (get-element-by-query "[type=\"text/css\"]")
  ;
  ; @usage
  ;  (get-element-by-query "div.my-class, div.your-class")
  ;
  ; @return (DOM-element)
  ([query]                (-> js/document    (.querySelector query)))
  ([parent-element query] (-> parent-element (.querySelector query))))

(defn get-elements-by-query
  ; @param (DOM-element)(opt) parent-element
  ;  Default: js/document
  ; @param (string) query
  ;
  ; @usage
  ;  (get-elements-by-query ":scope > div")
  ;
  ; @usage
  ;  (get-elements-by-query "[type=\"text/css\"]")
  ;
  ; @usage
  ;  (get-elements-by-query "div.my-class, div.your-class")
  ;
  ; @return (vector)
  ([query]                (-> js/document    (.querySelectorAll query) array-seq vec))
  ([parent-element query] (-> parent-element (.querySelectorAll query) array-seq vec)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-disabled?
  ; @param (DOM-element) element
  ;
  ; @usage
  ;  (element-disabled? my-element)
  ;
  ; @return (boolean)
  [element]
  (-> element .-disabled boolean))

(defn element-enabled?
  ; @param (DOM-element) element
  ;
  ; @usage
  ;  (element-enabled? my-element)
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
  ;  (set-element-id! my-element "my-element-id")
  ;
  ; @return (DOM-element)
  [element element-id]
  (->     element .-id (set! element-id))
  (return element))

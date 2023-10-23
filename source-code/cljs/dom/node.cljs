
(ns dom.node)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn insert-before!
  ; @param (DOM-element) parent-element
  ; @param (DOM-element) child-element
  ; @param (DOM-element) after-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-after-element  (get-element-by-id "my-after-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (insert-before! my-parent-element my-child-element my-after-element)
  ;
  ; @return (DOM-element)
  [parent-element child-element after-element]
  (.insertBefore parent-element child-element after-element)
  (-> parent-element))

(defn insert-after!
  ; https://www.javascripttutorial.net/javascript-dom/javascript-insertafter/
  ;
  ; @param (DOM-element) parent-element
  ; @param (DOM-element) child-element
  ; @param (DOM-element) before-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-before-element (get-element-by-id "my-before-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (insert-after! my-parent-element my-child-element my-before-element)
  ;
  ; @return (DOM-element)
  [parent-element child-element before-element]
  (.insertBefore parent-element child-element (.-nextSibling before-element))
  (-> parent-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn insert-as-first-of-type!
  ; @param (DOM-element) parent-element
  ; @param (DOM-element) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (insert-as-first-of-type! my-parent-element my-child-element)
  ;
  ; @return (DOM-element)
  [parent-element child-element]
  ; XXX#5507
  ; https://developer.mozilla.org/en-US/docs/Web/API/Document/querySelectorAll
  ; The :scope pseudo-class restores the expected behavior,
  ; only matching selectors on descendants of the base element:
  (let [tag-name (-> child-element .-tagName)
        query    (str ":scope > "tag-name)]
       (.insertBefore parent-element child-element
                      (-> parent-element (.querySelectorAll query)
                          array-seq first)))
  (-> parent-element))

(defn insert-as-last-of-type!
  ; @param (DOM-element) parent-element
  ; @param (DOM-element) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (insert-as-last-of-type! my-parent-element my-child-element)
  ;
  ; @return (DOM-element)
  [parent-element child-element]
  ; XXX#5507
  (let [tag-name (-> child-element .-tagName)
        query    (str ":scope > "tag-name)]
       (.insertBefore parent-element child-element
                      (-> parent-element (.querySelectorAll query)
                          array-seq last .-nextSibling)))
  (-> parent-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn insert-as-first-of-query-selected!
  ; @param (DOM-element) parent-element
  ; @param (DOM-element) child-element
  ; @param (string) query
  ;
  ; @usage
  ; (def head-element    (get-head-element))
  ; (def my-link-element (create-element! "link"))
  ; (insert-as-first-of-query-selected! head-element my-link-element "[type=\"text/css\"]")
  ;
  ; @usage
  ; (def body-element (get-body-element))
  ; (def my-element   (create-element! "div"))
  ; (insert-as-first-of-query-selected! body-element my-element "div.my-class, div.your-class")
  ;
  ; @return (DOM-element)
  [parent-element child-element query]
  (.insertBefore parent-element child-element
                 (-> parent-element (.querySelectorAll query) array-seq first))
  (-> parent-element))

(defn insert-as-last-of-query-selected!
  ; @param (DOM-element) parent-element
  ; @param (DOM-element) child-element
  ; @param (string) query
  ;
  ; @usage
  ; (def head-element    (get-head-element))
  ; (def my-link-element (create-element! "link"))
  ; (insert-as-first-of-query-selected! head-element my-link-element "[type=\"text/css\"]")
  ;
  ; @usage
  ; (def body-element (get-body-element))
  ; (def my-element   (create-element! "div"))
  ; (insert-as-first-of-query-selected! body-element my-element "div.my-class, div.your-class")
  ;
  ; @return (DOM-element)
  [parent-element child-element query]
  (.insertBefore parent-element child-element
                 (-> parent-element (.querySelectorAll query) array-seq last .-nextSibling))
  (-> parent-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn append-element!
  ; @param (DOM-element) parent-element
  ; @param (DOM-element) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (append-element! my-parent-element my-child-element)
  ;
  ; @return (DOM-element)
  [parent-element child-element]
  (.appendChild parent-element child-element)
  (-> parent-element))

(defn prepend-element!
  ; @param (DOM-element) parent-element
  ; @param (DOM-element) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (prepend-element! my-parent-element my-child-element)
  ;
  ; @return (DOM-element)
  [parent-element child-element]
  (.insertBefore parent-element child-element (.-firstChild parent-element))
  (-> parent-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn create-element!
  ; @param (string) nodename
  ;
  ; @usage
  ; (create-element! "div")
  ;
  ; @return (DOM-element)
  [nodename]
  (.createElement js/document nodename))

(defn remove-element!
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element! my-element)
  ;
  ; @return (undefined)
  [element]
  (.remove element))

(defn remove-child!
  ; @param (DOM-element) parent-element
  ; @param (DOM-element) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (get-element-by-id "my-child-element"))
  ; (remove-child! my-parent-element my-child-element)
  ;
  ; @return (DOM-element)
  [parent-element child-element]
  (.removeChild parent-element child-element)
  (-> parent-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn empty-element!
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (empty-element! my-element)
  ;
  ; @return (DOM-element)
  [element]
  (while (.-firstChild element)
         (.removeChild element (.-firstChild element)))
  (-> element))

(defn set-element-content!
  ; @param (DOM-element) element
  ; @param (string) content
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-content! my-element "Hakuna Matata!")
  ;
  ; @return (DOM-element)
  [element content]
  (->     element .-innerHTML (set! content))
  (-> element))

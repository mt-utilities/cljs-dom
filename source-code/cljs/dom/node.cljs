
(ns dom.node)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn insert-before!
  ; @description
  ; Inserts the given child element before the given following element within the given parent element.
  ;
  ; @param (DOM Element object) parent-element
  ; @param (DOM Element object) child-element
  ; @param (DOM Element object) following-element
  ;
  ; @usage
  ; (def my-parent-element    (get-element-by-id "my-parent-element"))
  ; (def my-following-element (get-element-by-id "my-following-element"))
  ; (def my-child-element     (create-element! "div"))
  ; (insert-before! my-parent-element my-child-element my-following-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [parent-element child-element following-element]
  (-> parent-element (.insertBefore child-element following-element))
  (-> parent-element))

(defn insert-after!
  ; @description
  ; Inserts the given child element after the given preceding element within the given parent element.
  ;
  ; @param (DOM Element object) parent-element
  ; @param (DOM Element object) child-element
  ; @param (DOM Element object) preceding-element
  ;
  ; @usage
  ; (def my-parent-element    (get-element-by-id "my-parent-element"))
  ; (def my-preceding-element (get-element-by-id "my-preceding-element"))
  ; (def my-child-element     (create-element! "div"))
  ; (insert-after! my-parent-element my-child-element my-preceding-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [parent-element child-element preceding-element]
  ; https://www.javascripttutorial.net/javascript-dom/javascript-insertafter/
  (-> parent-element (.insertBefore child-element (-> preceding-element .-nextSibling)))
  (-> parent-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn insert-as-first-of-type!
  ; @description
  ; Inserts the given child element as the first of its type within the given parent element.
  ;
  ; @param (DOM Element object) parent-element
  ; @param (DOM Element object) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (insert-as-first-of-type! my-parent-element my-child-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [parent-element child-element]
  ; @note (#5507)
  ; https://developer.mozilla.org/en-US/docs/Web/API/Document/querySelectorAll
  ; The :scope pseudo-class restores the expected behavior,
  ; only matching selectors on descendants of the base element:
  (let [tag-name (-> child-element .-tagName)
        query    (str ":scope > "tag-name)]
       (-> parent-element (.insertBefore child-element (-> parent-element (-> query .querySelectorAll) array-seq first))))
  (-> parent-element))

(defn insert-as-last-of-type!
  ; @description
  ; Inserts the given child element as the last of its type within the given parent element.
  ;
  ; @param (DOM Element object) parent-element
  ; @param (DOM Element object) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (insert-as-last-of-type! my-parent-element my-child-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [parent-element child-element]
  ; @note (#5507)
  (let [tag-name (-> child-element .-tagName)
        query    (str ":scope > "tag-name)]
       (-> parent-element (.insertBefore child-element (-> parent-element (.querySelectorAll query) array-seq last .-nextSibling)))
       (-> parent-element)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn insert-as-first-of-query-selected!
  ; @description
  ; Inserts the given child element as the first of elements that match the given query within the given parent element.
  ;
  ; @param (DOM Element object) parent-element
  ; @param (DOM Element object) child-element
  ; @param (string) query
  ;
  ; @usage
  ; (def head-element    (get-head-element))
  ; (def my-link-element (create-element! "link"))
  ; (insert-as-first-of-query-selected! head-element my-link-element "[type=\"text/css\"]")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @usage
  ; (def body-element (get-body-element))
  ; (def my-element   (create-element! "div"))
  ; (insert-as-first-of-query-selected! body-element my-element "div.my-class, div.another-class")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [parent-element child-element query]
  (-> parent-element (.insertBefore child-element (-> parent-element (-> query .querySelectorAll) array-seq first)))
  (-> parent-element))

(defn insert-as-last-of-query-selected!
  ; @description
  ; Inserts the given child element as the last of elements that match the given query within the given parent element.
  ;
  ; @param (DOM Element object) parent-element
  ; @param (DOM Element object) child-element
  ; @param (string) query
  ;
  ; @usage
  ; (def head-element    (get-head-element))
  ; (def my-link-element (create-element! "link"))
  ; (insert-as-first-of-query-selected! head-element my-link-element "[type=\"text/css\"]")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @usage
  ; (def body-element (get-body-element))
  ; (def my-element   (create-element! "div"))
  ; (insert-as-first-of-query-selected! body-element my-element "div.my-class, div.another-class")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [parent-element child-element query]
  (-> parent-element (.insertBefore child-element (-> parent-element (-> query .querySelectorAll) array-seq last .-nextSibling)))
  (-> parent-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn append-element!
  ; @description
  ; Appends the given child element to the given parent element.
  ;
  ; @param (DOM Element object) parent-element
  ; @param (DOM Element object) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (append-element! my-parent-element my-child-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [parent-element child-element]
  (-> parent-element (.appendChild child-element))
  (-> parent-element))

(defn prepend-element!
  ; @description
  ; Prepends the given child element to the given parent element.
  ;
  ; @param (DOM Element object) parent-element
  ; @param (DOM Element object) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (create-element! "div"))
  ; (prepend-element! my-parent-element my-child-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [parent-element child-element]
  (-> parent-element (.insertBefore child-element (.-firstChild parent-element)))
  (-> parent-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn create-element!
  ; @description
  ; Returns an element created based on the given tag name.
  ;
  ; @param (string) tag-name
  ;
  ; @usage
  ; (create-element! "div")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [tag-name]
  (-> js/document (.createElement tag-name)))

(defn remove-element!
  ; @description
  ; Removes the given element from the DOM tree.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element! my-element)
  ; =>
  ; nil
  ;
  ; @return (nil)
  [element]
  (-> element .remove))

(defn remove-child-element!
  ; @description
  ; Removes the given child element from the given parent element.
  ;
  ; @param (DOM Element object) parent-element
  ; @param (DOM Element object) child-element
  ;
  ; @usage
  ; (def my-parent-element (get-element-by-id "my-parent-element"))
  ; (def my-child-element  (get-element-by-id "my-child-element"))
  ; (remove-child-element! my-parent-element my-child-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [parent-element child-element]
  (-> parent-element (.removeChild child-element))
  (-> parent-element))

(defn remove-element-children!
  ; @description
  ; Removes all the child elements of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-children! my-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element]
  (while (-> element .-firstChild)
         (-> element (.removeChild (-> element .-firstChild))))
  (-> element))

(defn set-element-content!
  ; @description
  ; Updates the content of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (string) content
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-content! my-element "Hakuna Matata!")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element content]
  (-> element .-innerHTML (set! content))
  (-> element))

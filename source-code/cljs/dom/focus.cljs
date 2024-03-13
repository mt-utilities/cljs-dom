
(ns dom.focus)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-active-element
  ; @description
  ; Returns the focused element of the page.
  ;
  ; @usage
  ; (get-active-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  []
  (-> js/document .-activeElement))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-focused?
  ; @description
  ; Returns TRUE if the given element is focused.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-focused? my-element)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [element]
  (= element (get-active-element)))

(defn element-blurred?
  ; @description
  ; Returns TRUE if the given element is NOT focused.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-blurred? my-element)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [element]
  (not= element (get-active-element)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn focus-element!
  ; @description
  ; Sets the focus on the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (focus-element! my-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element]
  (-> element .focus)
  (-> element))

(defn blur-element!
  ; @description
  ; Removes the focus from the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (blur-element! my-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element]
  (-> element .blur)
  (-> element))

(defn blur-active-element!
  ; @description
  ; Removes the focus from the active element of the page.
  ;
  ; @usage
  ; (blur-active-element!)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  []
  (if-let [active-element (get-active-element)]
          (blur-element! active-element)))

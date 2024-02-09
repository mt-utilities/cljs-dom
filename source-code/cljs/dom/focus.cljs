
(ns dom.focus)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-active-element
  ; @usage
  ; (get-active-element)
  ;
  ; @return (DOM Element object)
  []
  (-> js/document .-activeElement))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-focused?
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-focused? my-element)
  ;
  ; @return (boolean)
  [element]
  (= element (get-active-element)))

(defn element-blurred?
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-blurred? my-element)
  ;
  ; @return (boolean)
  [element]
  (not= element (get-active-element)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn focus-element!
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (focus-element! my-element)
  ;
  ; @return (DOM Element object)
  [element]
  (-> element .focus)
  (-> element))

(defn blur-element!
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (blur-element! my-element)
  ;
  ; @return (DOM Element object)
  [element]
  (-> element .blur)
  (-> element))

(defn blur-active-element!
  ; @usage
  ; (blur-active-element!)
  ;
  ; @return (DOM Element object)
  []
  (if-let [active-element (get-active-element)]
          (blur-element! active-element)))


(ns dom.selection)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-selection-start
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-selection-start my-element)
  ;
  ; @return (integer)
  [element]
  (.-selectionStart element))

(defn get-selection-end
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-selection-end my-element)
  ;
  ; @return (integer)
  [element]
  (.-selectionStart element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-selection-start!
  ; @param (DOM Element object) element
  ; @param (integer) selection-start
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-selection-start! my-element 2)
  ;
  ; @return (DOM Element object)
  [element selection-start]
  (-> element .-selectionStart (set! selection-start))
  (-> element))

(defn set-selection-end!
  ; @param (DOM Element object) element
  ; @param (integer) selection-end
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-selection-end! my-element 2)
  ;
  ; @return (DOM Element object)
  [element selection-end]
  (-> element .-selectionEnd (set! selection-end))
  (-> element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-selection-range!
  ; @param (DOM Element object) element
  ; @param (integer) selection-start
  ; @param (integer) selection-end
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-selection-range! my-element 2 10)
  ;
  ; @return (DOM Element object)
  [element selection-start selection-end]
  (set-selection-start! element selection-start)
  (set-selection-end!   element selection-end)
  (->                   element))

(defn set-caret-position!
  ; @param (DOM Element object) element
  ; @param (integer) caret-position
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-caret-position! my-element 20)
  ;
  ; @return (DOM Element object)
  [element caret-position]
  (-> element (set-selection-start! caret-position))
  (-> element (set-selection-end!   caret-position))
  (-> element))

(defn move-caret-to-start!
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (move-caret-to-start! my-element)
  ;
  ; @return (DOM Element object)
  [element]
  (-> element (set-selection-range! 0 0))
  (-> element))

(defn move-caret-to-end!
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (move-caret-to-end! my-element)
  ;
  ; @return (DOM Element object)
  [element]
  (let [length (-> element .-value .-length)]
       (-> element (set-selection-range! length length))
       (-> element)))

(defn select-content!
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (select-content! my-element)
  ;
  ; @return (DOM Element object)
  [element]
  (let [length (-> element .-value .-length)]
       (-> element (set-selection-range! 0 length))
       (-> element)))

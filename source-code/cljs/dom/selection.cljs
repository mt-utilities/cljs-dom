
(ns dom.selection)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-selection-start
  ; @description
  ; Returns the starting cursor position of the selected text within the given input element, or the caret position if nothing is selected.
  ;
  ; @param (DOM Input Element object) input-element
  ;
  ; @usage
  ; (def my-input-element (get-element-by-id "my-input-element"))
  ; (get-selection-start my-input-element)
  ; =>
  ; 0
  ;
  ; @return (integer)
  [input-element]
  (.-selectionStart input-element))

(defn get-selection-end
  ; @description
  ; Returns the ending cursor position of the selected text within the given input element, or the caret position if nothing is selected.
  ;
  ; @param (DOM Input Element object) input-element
  ;
  ; @usage
  ; (def my-input-element (get-element-by-id "my-input-element"))
  ; (get-selection-end my-input-element)
  ; =>
  ; 420
  ;
  ; @return (integer)
  [input-element]
  (.-selectionStart input-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-selection-start!
  ; @description
  ; Sets the starting cursor position of the selected text within the given input element.
  ;
  ; @param (DOM Input Element object) input-element
  ; @param (integer) selection-start
  ;
  ; @usage
  ; (def my-input-element (get-element-by-id "my-input-element"))
  ; (set-selection-start! my-input-element 0)
  ; =>
  ; #object[HTMLInputElement]
  ;
  ; @return (DOM Input Element object)
  [input-element selection-start]
  (-> input-element .-selectionStart (set! selection-start))
  (-> input-element))

(defn set-selection-end!
  ; @description
  ; Sets the ending cursor position of the selected text within the given input element.
  ;
  ; @param (DOM Input Element object) input-element
  ; @param (integer) selection-end
  ;
  ; @usage
  ; (def my-input-element (get-element-by-id "my-input-element"))
  ; (set-selection-end! my-input-element 420)
  ; =>
  ; #object[HTMLInputElement]
  ;
  ; @return (DOM Input Element object)
  [input-element selection-end]
  (-> input-element .-selectionEnd (set! selection-end))
  (-> input-element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-selection-range!
  ; @description
  ; Sets both the starting and ending cursor positions of the selected text within the given input element.
  ;
  ; @param (DOM Input Element object) input-element
  ; @param (integer) selection-start
  ; @param (integer) selection-end
  ;
  ; @usage
  ; (def my-input-element (get-element-by-id "my-input-element"))
  ; (set-selection-range! my-input-element 0 420)
  ; =>
  ; #object[HTMLInputElement]
  ;
  ; @return (DOM Input Element object)
  [input-element selection-start selection-end]
  (set-selection-start! input-element selection-start)
  (set-selection-end!   input-element selection-end)
  (->                   input-element))

(defn set-caret-position!
  ; @description
  ; Sets the caret position of the given input element.
  ;
  ; @param (DOM Input Element object) input-element
  ; @param (integer) caret-position
  ;
  ; @usage
  ; (def my-input-element (get-element-by-id "my-input-element"))
  ; (set-caret-position! my-input-element 420)
  ; =>
  ; #object[HTMLInputElement]
  ;
  ; @return (DOM Input Element object)
  [input-element caret-position]
  (-> input-element (set-selection-start! caret-position))
  (-> input-element (set-selection-end!   caret-position))
  (-> input-element))

(defn move-caret-to-start!
  ; @description
  ; Moves the caret position to the beginning of the content within the given input element.
  ;
  ; @param (DOM Input Element object) input-element
  ;
  ; @usage
  ; (def my-input-element (get-element-by-id "my-input-element"))
  ; (move-caret-to-start! my-input-element)
  ; =>
  ; #object[HTMLInputElement]
  ;
  ; @return (DOM Input Element object)
  [input-element]
  (-> input-element (set-selection-range! 0 0))
  (-> input-element))

(defn move-caret-to-end!
  ; @description
  ; Moves the caret position to the end of the content within the given input element.
  ;
  ; @param (DOM Input Element object) input-element
  ;
  ; @usage
  ; (def my-input-element (get-element-by-id "my-input-element"))
  ; (move-caret-to-end! my-input-element)
  ;
  ; @return (DOM Input Element object)
  [input-element]
  (let [length (-> input-element .-value .-length)]
       (-> input-element (set-selection-range! length length))
       (-> input-element)))

(defn select-content!
  ; @description
  ; Selects all the content within the given input element.
  ;
  ; @param (DOM Input Element object) input-element
  ;
  ; @usage
  ; (def my-input-element (get-element-by-id "my-input-element"))
  ; (select-content! my-input-element)
  ; =>
  ; #object[HTMLInputElement]
  ;
  ; @return (DOM Input Element object)
  [input-element]
  (let [length (-> input-element .-value .-length)]
       (-> input-element (set-selection-range! 0 length))
       (-> input-element)))

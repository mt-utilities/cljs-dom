
(ns dom.selection
    (:require [candy.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-selection-start
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (get-selection-start my-element)
  ;
  ; @return (integer)
  [element]
  (.-selectionStart element))

(defn get-selection-end
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (get-selection-end my-element)
  ;
  ; @return (integer)
  [element]
  (.-selectionStart element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-selection-start!
  ; @param (DOM-element) element
  ; @param (integer) selection-start
  ;
  ; @usage
  ; (set-selection-start! my-element 2)
  ;
  ; @return (DOM-element)
  [element selection-start]
  (->     element .-selectionStart (set! selection-start))
  (return element))

(defn set-selection-end!
  ; @param (DOM-element) element
  ; @param (integer) selection-end
  ;
  ; @usage
  ; (set-selection-end! my-element 2)
  ;
  ; @return (DOM-element)
  [element selection-end]
  (->     element .-selectionEnd (set! selection-end))
  (return element))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-selection-range!
  ; @param (DOM-element) element
  ; @param (integer) selection-start
  ; @param (integer) selection-end
  ;
  ; @usage
  ; (set-selection-range! my-element 2 10)
  ;
  ; @return (DOM-element)
  [element selection-start selection-end]
  (set-selection-start! element selection-start)
  (set-selection-end!   element selection-end)
  (return               element))

(defn set-caret-position!
  ; @param (DOM-element) element
  ; @param (integer) caret-position
  ;
  ; @usage
  ; (set-caret-position! my-element 20)
  ;
  ; @return (DOM-element)
  [element caret-position]
  (set-selection-start! element caret-position)
  (set-selection-end!   element caret-position)
  (return               element))

(defn move-caret-to-start!
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (move-caret-to-start! my-element)
  ;
  ; @return (DOM-element)
  [element]
  (set-selection-range! element 0 0)
  (return               element))

(defn move-caret-to-end!
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (move-caret-to-end! my-element)
  ;
  ; @return (DOM-element)
  [element]
  (let [length (-> element .-value .-length)]
       (set-selection-range! element length length))
  (return element))

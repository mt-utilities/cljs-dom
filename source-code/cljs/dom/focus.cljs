
(ns dom.focus
    (:require [candy.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-active-element
  ; @usage
  ; (get-active-element)
  ;
  ; @return (DOM-element)
  []
  (.-activeElement js/document))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-focused?
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (element-focused? my-element)
  ;
  ; @return (boolean)
  [element]
  (= element (get-active-element)))

(defn element-blurred?
  ; @param (DOM-element) element
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
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (focus-element! my-element)
  ;
  ; @return (DOM-element)
  [element]
  (.focus element)
  (return element))

(defn blur-element!
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (blur-element! my-element)
  ;
  ; @return (DOM-element)
  [element]
  (.blur  element)
  (return element))

(defn blur-active-element!
  ; @usage
  ; (blur-active-element!)
  ;
  ; @return (DOM-element)
  []
  (if-let [active-element (get-active-element)]
          (blur-element! active-element)))

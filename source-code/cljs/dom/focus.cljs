
(ns dom.focus
    (:require [candy.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-active-element
  ; @usage
  ;  (get-active-element)
  ;
  ; @return (DOM-element)
  []
  (.-activeElement js/document))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn focus-element!
  ; @param (DOM-element) element
  ;
  ; @usage
  ;  (focus-element!)
  ;
  ; @return (DOM-element)
  [element]
  (.focus element)
  (return element))

(defn blur-element!
  ; @param (DOM-element) element
  ;
  ; @usage
  ;  (blur-element!)
  ;
  ; @return (DOM-element)
  [element]
  (.blur element)
  (return element))

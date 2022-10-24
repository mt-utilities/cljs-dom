
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns dom.focus)



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
  [element]
  (.focus element))

(defn blur-element!
  ; @param (DOM-element) element
  ;
  ; @usage
  ;  (blur-element!)
  [element]
  (.blur element))

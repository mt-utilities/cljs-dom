
(ns dom.dimensions)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-offset-width
  ; @description
  ; Returns the offset width of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-offset-width my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .-offsetWidth))

(defn get-element-offset-height
  ; @description
  ; Returns the offset height of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-offset-height my-element)
  ; =>
  ; 420
  ;
  ; @return (px)
  [element]
  (-> element .-offsetHeight))


(ns dom.utils)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn normalize
  ; @ignore
  ;
  ; @description
  ; Converts the given 'n' value into string.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (normalize :my-attribute)
  ; =>
  ; "my-attribute"
  ;
  ; @return (string)
  [n]
  (if (keyword? n)
      (name     n)
      (str      n)))


(ns dom.head)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-head-element
  ; @usage
  ; (get-head-element)
  ; =>
  ; #object[HTMLHeadElement]
  ;
  ; @return (DOM Element object)
  []
  (-> js/document (.getElementsByTagName "head")
                  (aget 0)))


(ns dom.body)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-body-element
  ; @usage
  ; (get-body-element)
  ; =>
  ; #object[HTMLBodyElement]
  ;
  ; @return (DOM Element object)
  []
  (-> js/document (.getElementsByTagName "body")
                  (aget 0)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-body-style-value
  ; @param (string) style-name
  ;
  ; @usage
  ; (get-body-style-value "background-color")
  ; =>
  ; "white"
  ;
  ; @return (string)
  [style-name]
  (-> js/window (.getComputedStyle (-> js/document (.getElementsByTagName "body")
                                                   (aget 0)))
                (aget style-name)))

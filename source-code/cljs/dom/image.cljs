
(ns dom.image)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-image-source!
  ; @param (DOM Element object) element
  ; @param (string) uri
  ;
  ; @usage
  ; (def my-image (get-element-by-id "my-image"))
  ; (set-image-source! my-image "/my-image.png")
  ;
  ; @return (DOM Element object)
  [element uri]
  (-> element .-src (set! uri))
  (-> element))

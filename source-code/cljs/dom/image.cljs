
(ns dom.image)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-image-source!
  ; @description
  ; Updates the source attribute of the given image.
  ;
  ; @param (DOM Element object) image
  ; @param (string) uri
  ;
  ; @usage
  ; (def my-image (get-element-by-id "my-image"))
  ; (set-image-source! my-image "/my-image.png")
  ; =>
  ; #object[HTMLImgElement]
  ;
  ; @return (DOM Element object)
  [image uri]
  (-> image .-src (set! uri))
  (-> image))

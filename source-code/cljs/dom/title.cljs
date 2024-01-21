
(ns dom.title)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-document-title
  ; @usage
  ; (get-document-title)
  ;
  ; @return (string)
  []
  (-> js/document .-title str))

(defn set-document-title!
  ; @param (string) title
  ;
  ; @usage
  ; (set-document-title! "My title")
  ;
  ; @return (string)
  [title]
  (-> js/document .-title (set! title))
  (-> title))

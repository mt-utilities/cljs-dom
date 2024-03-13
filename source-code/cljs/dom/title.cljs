
(ns dom.title)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-document-title
  ; @description
  ; Returns the DOCUMENT element title (page title).
  ;
  ; @usage
  ; (get-document-title)
  ; =>
  ; "My title"
  ;
  ; @return (string)
  []
  (-> js/document .-title str))

(defn set-document-title!
  ; @description
  ; Updates the DOCUMENT element title (page title).
  ;
  ; @param (string) title
  ;
  ; @usage
  ; (set-document-title! "My title")
  ; =>
  ; "My title"
  ;
  ; @return (string)
  [title]
  (-> js/document .-title (set! title))
  (-> title))

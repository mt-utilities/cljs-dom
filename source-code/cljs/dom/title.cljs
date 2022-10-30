
(ns dom.title)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-document-title
  ; WARNING! NOT TESTED!
  ;
  ; @usage
  ;  (get-document-title)
  ;
  ; @return (string)
  []
  (str (-> js/document .-title)))

(defn set-document-title!
  ; @param (string) title
  ;
  ; @usage
  ;  (set-document-title! "My title")
  [title]
  (set! (-> js/document .-title) title))


(ns dom.document)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-document-element
  ; @usage
  ; (get-document-element)
  ; =>
  ; #object[HTMLHtmlElement]
  ;
  ; @return (DOM Document object)
  []
  (-> js/document .-documentElement))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-document-height
  ; @usage
  ; (get-document-height)
  ; =>
  ; 420
  ;
  ; @return (px)
  []
  (-> js/document .-documentElement .-scrollHeight))

(defn get-document-width
  ; @usage
  ; (get-document-width)
  ; =>
  ; 420
  ;
  ; @return (px)
  []
  (-> js/document .-documentElement .-scrollWidth))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn toggle-design-mode!
  ; @usage
  ; (toggle-design-mode!)
  []
  (let [design-mode (-> js/document .-designMode)]
       (case design-mode "on" (aset js/document "designMode" "off")
                              (aset js/document "designMode" "on"))))

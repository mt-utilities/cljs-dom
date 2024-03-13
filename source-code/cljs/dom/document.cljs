
(ns dom.document)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-document-element
  ; @description
  ; Returns the DOCUMENT element object.
  ;
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

(defn get-document-scroll-height
  ; @description
  ; Returns the scroll height of the DOCUMENT element.
  ;
  ; @usage
  ; (get-document-height)
  ; =>
  ; 420
  ;
  ; @return (px)
  []
  (-> js/document .-documentElement .-scrollHeight))

(defn get-document-scroll-width
  ; @description
  ; Returns the scroll width of the DOCUMENT element.
  ;
  ; @usage
  ; (get-document-scroll-width)
  ; =>
  ; 420
  ;
  ; @return (px)
  []
  (-> js/document .-documentElement .-scrollWidth))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn toggle-design-mode!
  ; @description
  ; Turns on/off the desing mode of the DOCUMENT element.
  ;
  ; @usage
  ; (toggle-design-mode!)
  []
  (let [design-mode (-> js/document .-designMode)]
       (case design-mode "on" (aset js/document "designMode" "off")
                              (aset js/document "designMode" "on"))))

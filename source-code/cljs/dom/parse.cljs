
(ns dom.parse)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn parse-html
  ; @description
  ; Parses the given HTML string into an element.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (parse-html "<div>My element</div>")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [n]
  (let [wrapper (.createElement js/document "div")]
       (-> wrapper .-innerHTML (set! n))
       (-> wrapper .-firstChild)))

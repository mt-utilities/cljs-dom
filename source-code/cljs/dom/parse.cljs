
(ns dom.parse)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn parse-html
  ; @param (string) n
  ;
  ; @usage
  ; (parse-html "<div>My element</div>")
  ;
  ; @return (DOM Element object)
  [n]
  (let [wrapper (.createElement js/document "div")]
       (-> wrapper .-innerHTML (set! n))
       (-> wrapper .-firstChild)))

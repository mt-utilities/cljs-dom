
(ns dom.script
    (:require [dom.attributes :as attributes]
              [dom.body       :as body]
              [dom.node       :as node]
              [noop.api       :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn append-script!
  ; @param (string) script
  ;
  ; @usage
  ; (append-script! "console.log('420')")
  ;
  ; @return (DOM-element)
  [script]
  (let [body-element   (body/get-body-element)
        script-element (node/create-element! "script")]
       (attributes/set-element-attribute! script-element "type" "text/javascript")
       (node/set-element-content!         script-element script)
       (node/append-element!              body-element   script-element)
       (return                            script-element)))


(ns dom.script
    (:require [dom.attributes :as attributes]
              [dom.body       :as body]
              [dom.node       :as node]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn append-script!
  ; @param (string) script
  ;
  ; @usage
  ; (append-script! "console.log('420')")
  ; =>
  ; #object[HTMLScriptElement]
  ;
  ; @return (DOM Element object)
  [script]
  (let [body-element   (body/get-body-element)
        script-element (node/create-element! "script")]
       (-> script-element (attributes/set-element-attribute! "type" "text/javascript"))
       (-> script-element (node/set-element-content! script))
       (-> body-element   (node/append-element! script-element))
       (-> script-element)))


(ns dom.animations
    (:require [dom.attributes :as attributes]
              [dom.node       :as node]
              [dom.style      :as style]
              [noop.api       :refer [return]]))
              
;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn remove-element-animated!
  ; @param (DOM-element) element
  ; @param (ms) timeout
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-animated! my-element 500)
  [element timeout]
  (attributes/set-element-attribute! element "data-animation" "hide")
  (letfn [(f [] (node/remove-element! element))]
         (.setTimeout js/window f timeout)))

(defn hide-element-animated!
  ; @param (DOM-element) element
  ; @param (ms) timeout
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (hide-element-animated! my-element 500)
  ;
  ; @return (DOM-element)
  [element timeout]
  (attributes/set-element-attribute! element "data-animation" "hide")
  (letfn [(f [] (style/set-element-style-value!       element "display" "none")
                (attributes/remove-element-attribute! element "data-animation"))]
         (.setTimeout js/window f timeout))
  (return element))

(defn reveal-element-animated!
  ; @param (DOM-element) element
  ; @param (ms) timeout
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (reveal-element-animated! my-element 500)
  ;
  ; @return (DOM-element)
  [element timeout]
  (style/set-element-style-value!    element "display"        "block")
  (attributes/set-element-attribute! element "data-animation" "reveal")
  (letfn [(f [] (attributes/remove-element-attribute! element "data-animation"))]
         (.setTimeout js/window f timeout))
  (return element))

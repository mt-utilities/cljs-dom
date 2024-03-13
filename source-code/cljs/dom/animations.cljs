
(ns dom.animations
    (:require [dom.attributes :as attributes]
              [dom.node       :as node]
              [dom.style      :as style]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn remove-element-animated!
  ; @description
  ; 1. Sets the given element's 'data-animation' attribute value to 'hide'.
  ; 2. Removes the given element from the DOM tree when the given 'timeout' is elapsed.
  ;
  ; @param (DOM Element object) element
  ; @param (ms) timeout
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-animated! my-element 500)
  [element timeout]
  (attributes/set-element-attribute! element "data-animation" "hide")
  (letfn [(f0 [] (node/remove-element! element))]
         (.setTimeout js/window f0 timeout)))

(defn hide-element-animated!
  ; @description
  ; 1. Sets the given element's 'data-animation' attribute value to 'hide'.
  ; 2. Sets the given element's 'display' CSS property value to 'none' when the given 'timeout' is elapsed.
  ; 3. Removes the given element's 'data-animation' attribute when the element is hidden.
  ;
  ; @param (DOM Element object) element
  ; @param (ms) timeout
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (hide-element-animated! my-element 500)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element timeout]
  (attributes/set-element-attribute! element "data-animation" "hide")
  (letfn [(f0 [] (style/set-element-inline-style-value! element "display" "none")
                 (attributes/remove-element-attribute!  element "data-animation"))]
         (.setTimeout js/window f0 timeout))
  (-> element))

(defn reveal-element-animated!
  ; @description
  ; 1. Sets the given element's 'display' CSS property value to 'block' in case its value is 'hidden'.
  ; 2. Sets the given element's 'data-animation' attribute value to 'reveal'.
  ; 3. Removes the given element's 'data-animation' attribute when the given 'timeout' is elapsed.
  ;
  ; @param (DOM Element object) element
  ; @param (ms) timeout
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (reveal-element-animated! my-element 500)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element timeout]
  (if-let [display-value (style/get-element-inline-style-value element "display")]
          (if (= display-value "none")
              (style/set-element-inline-style-value! element "display" "block")))
  (attributes/set-element-attribute! element "data-animation" "reveal")
  (letfn [(f0 [] (attributes/remove-element-attribute! element "data-animation"))]
         (.setTimeout js/window f0 timeout))
  (-> element))

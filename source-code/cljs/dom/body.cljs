
(ns dom.body
    (:require [dom.utils :as utils]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-body-element
  ; @description
  ; Returns the BODY element object.
  ;
  ; @usage
  ; (get-body-element)
  ; =>
  ; #object[HTMLBodyElement]
  ;
  ; @return (DOM Element object)
  []
  (-> js/document (.getElementsByTagName "body")
                  (aget 0)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-body-computed-style-value
  ; @description
  ; Returns a specific computed style value of the BODY element.
  ;
  ; @param (keyword or string) style-name
  ;
  ; @usage
  ; (get-body-computed-style-value "background-color")
  ; =>
  ; "white"
  ;
  ; @return (string)
  [style-name]
  (let [body-element (get-body-element)]
       (-> js/window (.getComputedStyle body-element)
                     (aget (utils/normalize style-name)))))

(defn get-body-inline-style-value
  ; @description
  ; Returns a specific inline style value of the BODY element.
  ;
  ; @param (keyword or string) style-name
  ;
  ; @usage
  ; (get-body-inline-style-value "background-color")
  ; =>
  ; "white"
  ;
  ; @return (string)
  [style-name]
  (let [body-element (get-body-element)
        inline-style (.-style body-element)]
       (.getPropertyValue inline-style (utils/normalize style-name))))


(ns dom.style
    (:require [dom.utils      :as utils]
              [fruits.css.api :as css]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-computed-style
  ; @description
  ; Returns the computed style map of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-computed-style my-element)
  ; =>
  ; {"background-color" "white" ...}
  ;
  ; @return (map)
  [element]
  (let [computed-style (.getComputedStyle js/window element)]
       (letfn [(f0 [result style-name] (assoc result style-name (.getPropertyValue computed-style style-name)))]
              (if-not (empty? computed-style)
                      (reduce f0 {} computed-style)))))

(defn get-element-computed-style-value
  ; @description
  ; Returns a specific computed style value of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) style-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-computed-style-value my-element "background-color")
  ; =>
  ; "white"
  ;
  ; @return (string)
  [element style-name]
  (-> js/window (.getComputedStyle element)
                (aget (utils/normalize style-name))))

  ;; ----------------------------------------------------------------------------
  ;; ----------------------------------------------------------------------------

(defn get-element-inline-style
  ; @description
  ; Returns the inline style map of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-inline-style my-element)
  ; =>
  ; {"background-color" "white" ...}
  ;
  ; @return (map)
  [element]
  (let [inline-style (.-style element)]
       (letfn [(f0 [result style-name] (assoc result style-name (.getPropertyValue inline-style style-name)))]
              (if-not (empty? inline-style)
                      (reduce f0 {} inline-style)))))

(defn merge-element-inline-style!
  ; @description
  ; Merges the given style map onto the inline style of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (map) style
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (merge-element-inline-style! my-element {"position" "fixed" "top" "0"})
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element style]
  (doseq [[style-name style-value] style]
         (-> element .-style (aset (utils/normalize style-name)
                                   (utils/normalize style-value))))
  (-> element))

(defn set-element-inline-style!
  ; @description
  ; Sets the given style map as the inline style of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (map) style
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-inline-style! my-element {:position "fixed" :top "0"})
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element style]
  (let [parsed-style (css/unparse style)]
       (-> element (.setAttribute "style" parsed-style))
       (-> element)))

(defn remove-element-inline-style!
  ; @description
  ; Removes the inline style of the given element.
  ;
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-inline-style! my-element)
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element]
  (-> element (.removeAttribute "style"))
  (-> element))

(defn get-element-inline-style-value
  ; @description
  ; Returns a specific inline style value of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) style-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (get-element-inline-style-value my-element "background-color")
  ; =>
  ; "white"
  ;
  ; @return (string)
  [element style-name]
  (let [inline-style (.-style element)]
       (.getPropertyValue inline-style (utils/normalize style-name))))

(defn set-element-inline-style-value!
  ; @description
  ; Updates a specific inline style value of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) style-name
  ; @param (*) style-value
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (set-element-inline-style-value! my-element "background-color" "white")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element style-name style-value]
  (-> element .-style (aset (utils/normalize style-name)
                            (utils/normalize style-value)))
  (-> element))

(defn remove-element-inline-style-value!
  ; @description
  ; Removes a specific inline style value of the given element.
  ;
  ; @param (DOM Element object) element
  ; @param (keyword or string) style-name
  ;
  ; @usage
  ; (def my-element (get-element-by-id "my-element"))
  ; (remove-element-inline-style-value! my-element "background-color")
  ; =>
  ; #object[HTMLDivElement]
  ;
  ; @return (DOM Element object)
  [element style-name]
  (-> element .-style (aset (utils/normalize style-name) nil))
  (-> element))

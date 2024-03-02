
(ns dom.mouse
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-mouse-x
  ; @param (DOM-event) mouse-event
  ;
  ; @usage
  ; (fn [my-mouse-event]
  ;     (get-mouse-x my-mouse-event))
  ; =>
  ; 420
  ;
  ; @return (px)
  [mouse-event]
  (-> mouse-event .-clientX))

(defn get-mouse-y
  ; @param (DOM-event) mouse-event
  ;
  ; @usage
  ; (fn [my-mouse-event]
  ;     (get-mouse-y my-mouse-event))
  ; =>
  ; 420
  ;
  ; @return (px)
  [mouse-event]
  (-> mouse-event .-clientY))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-mouse-viewport-quarter
  ; @param (DOM-event) mouse-event
  ;
  ; @usage
  ; (fn [my-mouse-event]
  ;     (get-mouse-viewport-quarter my-mouse-event))
  ; =>
  ; :tl
  ;
  ; @return (keyword)
  ; :tl, :tr, :bl, :br
  [mouse-event]
  (let [half-viewport-height (-> js/window .-innerHeight (/ 2))
        half-viewport-width  (-> js/window .-innerWidth  (/ 2))
        mouse-x              (.-clientX mouse-event)
        mouse-y              (.-clientY mouse-event)]
       (cond (and (< mouse-x half-viewport-width)
                  (< mouse-y half-viewport-height))
             :tl
             (and (>= mouse-x half-viewport-width)
                  (<  mouse-y half-viewport-height))
             :tr
             (< mouse-x half-viewport-width)
             :bl :return :br)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn select-preventer
  ; @param (DOM-event) mouse-event
  ;
  ; @usage
  ; (fn [my-mouse-event]
  ;     (select-preventer my-mouse-event))
  [mouse-event]
  (let [node-name (-> mouse-event .-srcElement .-nodeName string/to-lowercase)]
       ; To use input and textarea elements, we need a mouse-down event!
       (when-not (or (= node-name "input")
                     (= node-name "textarea"))
                 (do (-> mouse-event .preventDefault)
                     (-> js/document .-activeElement .blur)))))


(ns dom.mouse
    (:require [string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-mouse-x
  ; @param (DOM-event) mouse-event
  ;
  ; @usage
  ; (fn [mouse-event]
  ;     (get-mouse-x mouse-event))
  ;
  ; @return (px)
  [mouse-event]
  (.-clientX mouse-event))

(defn get-mouse-y
  ; @param (DOM-event) mouse-event
  ;
  ; @usage
  ; (fn [mouse-event]
  ;     (get-mouse-x %))
  ;
  ; @return (px)
  [mouse-event]
  (.-clientY mouse-event))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-mouse-viewport-quarter
  ; @param (DOM-event) mouse-event
  ;
  ; @usage
  ; (fn [mouse-event]
  ;     (get-mouse-viewport-quarter mouse-event))
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
  ; (fn [mouse-event]
  ;     (select-preventer mouse-event))
  [mouse-event]
  (let [node-name (-> mouse-event .-srcElement .-nodeName string/lowercase)]
       ; Az input es textarea elemek hasznalatahoz szukseg van mouse-down eventre!
       (when-not (or (= node-name "input")
                     (= node-name "textarea"))
                 (do (-> mouse-event .preventDefault)
                     (-> js/document .-activeElement .blur)))))


(ns dom.event
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn on-mouse-left
  ; @description
  ; Applies the given function in case the given mouse event is triggered by the main button.
  ;
  ; @param (DOM Event object) mouse-event
  ; @param (function) f
  ;
  ; @usage
  ; (on-mouse-left % (fn [mouse-event] ...))
  ;
  ; @return (*)
  [mouse-event f]
  (if (= (.-button mouse-event) 0)
      (f mouse-event)))

(defn on-mouse-middle
  ; @description
  ; Applies the given function in case the given mouse event is triggered by the auxiliary button.
  ;
  ; @param (DOM Event object) mouse-event
  ; @param (function) f
  ;
  ; @usage
  ; (on-mouse-middle % (fn [mouse-event] ...))
  ;
  ; @return (*)
  [mouse-event f]
  (if (= (.-button mouse-event) 1)
      (f mouse-event)))

(defn on-mouse-right
  ; @description
  ; Applies the given function in case the given mouse event is triggered by the secondary button.
  ;
  ; @param (DOM Event object) mouse-event
  ; @param (function) f
  ;
  ; @usage
  ; (on-mouse-right % (fn [mouse-event] ...))
  ;
  ; @return (*)
  [mouse-event f]
  (if (= (.-button mouse-event) 2)
      (f mouse-event)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn stop-propagation
  ; @description
  ; Prevents further propagation of the given event.
  ;
  ; @param (DOM Event object) event
  ;
  ; @usage
  ; (fn [my-event]
  ;     (stop-propagation my-event))
  ;
  ; @return (*)
  [event]
  (-> event .stopPropagation))

(defn prevent-default
  ; @description
  ; Prevents the default action of the given event.
  ;
  ; @param (DOM Event object) event
  ;
  ; @usage
  ; (fn [my-event]
  ;     (prevent-default my-event))
  ;
  ; @return (*)
  [event]
  (-> event .preventDefault))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-event-value
  ; @description
  ; Returns the value property of the element which the given event was dispatched.
  ;
  ; @param (DOM Event object) event
  ;
  ; @usage
  ; (fn [my-event]
  ;     (get-event-value my-event))
  ;
  ; @return (*)
  [event]
  (-> event .-target .-value))

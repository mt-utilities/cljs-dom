
(ns dom.event)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn on-mouse-left
  ; @param (DOM-event) mouse-event
  ; @param (function) f
  ;
  ; @usage
  ; (on-mouse-left % (fn [mouse-event] ...))
  ;
  ; @return (*)
  [mouse-event f]
  (if (= (.-button mouse-event) 0)
      (f)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn stop-propagation
  ; @param (DOM-event) event
  ;
  ; @usage
  ; (fn [my-event]
  ;     (stop-propagation my-event))
  ;
  ; @return (*)
  [event]
  (-> event .stopPropagation))

(defn prevent-default
  ; @param (DOM-event) event
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

(defn event->node-name
  ; @param (DOM-event) event
  ;
  ; @usage
  ; (fn [my-event]
  ;     (event->node-name my-event))
  ; =>
  ; "DIV"
  ;
  ; @return (string)
  [event]
  (-> event .-srcElement .-nodeName))

(defn event->value
  ; @param (dom-event) n
  ;
  ; @usage
  ; (fn [my-event]
  ;     (event->value my-event))
  ;
  ; @return (*)
  [n]
  (-> n .-target .-value))

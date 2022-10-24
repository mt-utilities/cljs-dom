
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns dom.event)



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn on-mouse-left
  ; @param (DOM event) mouse-event
  ; @param (function) f
  ;
  ; @usage
  ;  (on-mouse-left % (fn [] ...))
  ;
  ; @return (*)
  [mouse-event f]
  (if (= (.-button mouse-event) 0)
      (f)))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn stop-propagation!
  ; @param (DOM event) event
  ;
  ; @usage
  ;  (stop-propagation! my-event)
  ;
  ; @return (*)
  [event]
  (.stopPropagation event))

(defn prevent-default!
  ; @param (DOM event) event
  ;
  ; @usage
  ;  (prevent-default! my-event)
  ;
  ; @return (*)
  [event]
  (.preventDefault event))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn event->node-name
  ; @param (DOM event) event
  ;
  ; @usage
  ;  (event->node-name %)
  ;
  ; @return (string)
  [event]
  (-> event .-srcElement .-nodeName))

(defn event->value
  ; @param (dom-event) n
  ;
  ; @usage
  ;  (event->value %)
  ;
  ; @return (*)
  [n]
  (-> n .-target .-value))

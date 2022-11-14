
(ns dom.listeners
    (:require [candy.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn add-event-listener!
  ; @param (string) type
  ; @param (function) listener-f
  ; @param (DOM-element)(opt) target
  ;  Default: js/window
  ;
  ; @usage
  ;  (add-event-listener! "mousemove" (fn [] ...))
  ;
  ; @return (DOM-element)
  ([type listener-f]
   (add-event-listener! type listener-f js/window))

  ([type listener-f target]
   (.addEventListener target type listener-f false)
   (return            target)))

(defn remove-event-listener!
  ; @param (string) type
  ; @param (function) listener-f
  ; @param (DOM-element)(opt) target
  ;  Default: js/window
  ;
  ; @usage
  ;  (def my-listener-f (fn []))
  ;  (remove-event-listener! "mousemove" my-listener-f)
  ;
  ; @return (DOM-element)
  ([type listener-f]
   (remove-event-listener! type listener-f js/window))

  ([type listener-f target]
   (.removeEventListener target type listener-f false)
   (return               target)))


(ns dom.form-data
    (:require [dom.utils :as utils]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn append-to-form-data!
  ; @description
  ; Appends the given value to the given form data.
  ;
  ; @param (FormData object) form-data
  ; @param (keyword, integer or string) data-key
  ; @param (*) data-value
  ;
  ; @usage
  ; (def my-form-data (js/FormData.))
  ; (append-to-form-data! my-form-data :name "John")
  ; =>
  ; #object[FormData]
  ;
  ; @return (FormData object)
  [form-data data-key data-value]
  (-> form-data (.append (utils/normalize data-key) data-value))
  (-> form-data))

(defn merge-to-form-data!
  ; @description
  ; Merges the given map(s) onto the given form data.
  ;
  ; @param (FormData object) form-data
  ; @param (list of maps) xyz
  ;
  ; @usage
  ; (def my-form-data (js/FormData.))
  ; (merge-to-form-data! my-form-data {...})
  ; =>
  ; #object[FormData]
  ;
  ; @usage
  ; (def my-form-data (js/FormData.))
  ; (merge-to-form-data! my-form-data {...} {...} {...})
  ; =>
  ; #object[FormData]
  ;
  ; @return (FormData object)
  [form-data & xyz]
  (doseq [n xyz] (doseq [[k v] n] (append-to-form-data! form-data k v)))
  (-> form-data))


(ns dom.form-data
    (:require [dom.file-selector :as file-selector]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn append-to-form-data!
  ; @param (FormData object)
  ; @param (keyword or string) prop-key
  ; @param (*) prop-value
  ;
  ; @usage
  ; (def my-form-data (js/FormData.))
  ; (append-to-form-data! my-form-data :name "John")
  ; =>
  ; #object[FormData]

  ; @return (FormData object)
  [form-data prop-key prop-value]
  (let [prop-key (if (-> prop-key keyword?)
                     (-> prop-key name)
                     (-> prop-key))]
       (-> form-data (.append prop-key prop-value))
       (-> form-data)))

(defn merge-to-form-data!
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
  (doseq [n xyz]
         (doseq [[k v] n]
                (append-to-form-data! form-data k v)))
  (-> form-data))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-selector->form-data
  ; @param (DOM Element object) file-selector
  ; @param (strings in vector)(opt) filtered-file-keys
  ;
  ; @usage
  ; (def my-file-selector (get-elementy-by-id "my-file-selector"))
  ; (file-selector->form-data my-file-selector)
  ; =>
  ; #object[FormData]
  ;
  ; @usage
  ; (def my-file-selector (get-elementy-by-id "my-file-selector"))
  ; (file-selector->form-data my-file-selector ["0" "1" "4"])
  ; =>
  ; #object[FormData]
  ;
  ; @return (FormData object)
  [file-selector & [filtered-file-keys]]
  (let [files     (file-selector/file-selector->files file-selector)
        form-data (js/FormData.)
        file-keys (.keys js/Object files)
        file-keys (or filtered-file-keys file-keys)]
       (doseq [file-key file-keys]
              (let [file (aget files file-key)]
                   (append-to-form-data! form-data file-key file)))
       (-> form-data)))

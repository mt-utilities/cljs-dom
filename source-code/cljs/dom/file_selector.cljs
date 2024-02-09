
(ns dom.file-selector
    (:require [dom.file :as file]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-selector->files
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->files my-file-selector)
  ;
  ; @return (?)
  [file-selector]
  (-> file-selector .-files))

(defn file-selector->file-list
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->file-list my-file-selector)
  ;
  ; @return (file objects in vector)
  [file-selector]
  (-> file-selector .-files array-seq))

(defn file-selector->file
  ; @param (DOM Element object) file-selector
  ; @param (integer) file-dex
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->file my-file-selector 2)
  ;
  ; @return (file object)
  [file-selector file-dex]
  (-> file-selector .-files array-seq (nth file-dex)))

(defn file-selector->files-size
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->files-size my-file-selector)
  ;
  ; @return (B)
  [file-selector]
  (letfn [(f0 [%1 %2] (+ %1 (.-size %2)))]
         (reduce f0 0 (-> file-selector .-files array-seq))))

(defn file-selector->file-count
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->file-count my-file-selector)
  ;
  ; @return (integer)
  [file-selector]
  (-> file-selector .-files .-length))

(defn file-selector->any-file-selected?
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->any-file-selected? my-file-selector)
  ;
  ; @return (boolean)
  [file-selector]
  (-> file-selector .-files .-length (> 0)))

(defn file-selector->mime-types
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->mime-types my-file-selector)
  ;
  ; @return (strings in vector)
  [file-selector]
  (letfn [(f0 [%1 %2] (conj %1 (.-type %2)))]
         (reduce f0 [] (-> file-selector .-files array-seq))))

(defn file-selector->files-data
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->files-data my-file-selector)
  ;
  ; @return (maps in vector)
  [file-selector]
  (letfn [(f0 [%1 %2 %3] (conj %1 (file/file->file-data %2 %3)))]
         (reduce-kv f0 [] (-> file-selector .-files array-seq vec))))

(defn file-selector->files-meta
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->files-meta my-file-selector)
  ;
  ; @return (map)
  ; {:file-count (integer)
  ;  :files-size (B)}
  [file-selector]
  {:file-count (file-selector->file-count file-selector)
   :files-size (file-selector->files-size file-selector)})

(defn file-selector->image-data-url
  ; @param (DOM Element object) file-selector
  ; @param (integer) file-dex
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->image-data-url my-file-selector 2)
  ;
  ; @return (string)
  [file-selector file-dex]
  (let [file        (file-selector->file file-selector file-dex)
        file-reader (js/FileReader.)]))

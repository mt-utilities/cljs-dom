
# <strong>dom.api</strong> namespace
<p>Documentation of the <strong>dom/api.cljs</strong> file</p>

<strong>[README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > dom.api</strong>



### add-event-listener!

```
@param (string) type
@param (function) listener-f
@param (DOM-element)(opt) target
Default: js/window
```

```
@usage
(add-event-listener! "mousemove" (fn [event] ...))
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn add-event-listener!
  ([type listener-f]
   (add-event-listener! type listener-f js/window))

  ([type listener-f target]
   (.addEventListener target type listener-f false)
   (return            target)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [add-event-listener!]]))

(dom/add-event-listener! ...)
(add-event-listener!     ...)
```

</details>

---

### append-element!

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (create-element! "div"))
(append-element! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn append-element!
  [parent-element child-element]
  (.appendChild parent-element child-element)
  (return       parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [append-element!]]))

(dom/append-element! ...)
(append-element!     ...)
```

</details>

---

### append-script!

```
@param (string) script
```

```
@usage
(append-script! "console.log('420')")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn append-script!
  [script]
  (let [body-element   (body/get-body-element)
        script-element (node/create-element! "script")]
       (attributes/set-element-attribute! script-element "type" "text/javascript")
       (node/set-element-content!         script-element script)
       (node/append-element!              body-element   script-element)
       (return                            script-element)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [append-script!]]))

(dom/append-script! ...)
(append-script!     ...)
```

</details>

---

### append-to-form-data!

```
@param (FormData object) 
@param (keyword or string) prop-key
@param (*) prop-value
```

```
@usage
(def my-form-data (js/FormData.))
(append-to-form-data! my-form-data :name "John")
```

```
@return (FormData object)
```

<details>
<summary>Source code</summary>

```
(defn append-to-form-data!
  [form-data prop-key prop-value]
  (let [prop-key (if (keyword? prop-key)
                     (name     prop-key)
                     (return   prop-key))]
       (.append form-data prop-key prop-value))
  (return form-data))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [append-to-form-data!]]))

(dom/append-to-form-data! ...)
(append-to-form-data!     ...)
```

</details>

---

### blur-element!

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(blur-element! my-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn blur-element!
  [element]
  (.blur  element)
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [blur-element!]]))

(dom/blur-element! ...)
(blur-element!     ...)
```

</details>

---

### create-element!

```
@param (string) nodename
```

```
@usage
(create-element! "div")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn create-element!
  [nodename]
  (.createElement js/document nodename))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [create-element!]]))

(dom/create-element! ...)
(create-element!     ...)
```

</details>

---

### element-blurred?

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-blurred? my-element)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn element-blurred?
  [element]
  (not= element (get-active-element)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [element-blurred?]]))

(dom/element-blurred? ...)
(element-blurred?     ...)
```

</details>

---

### element-disabled?

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-disabled? my-element)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn element-disabled?
  [element]
  (-> element .-disabled boolean))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [element-disabled?]]))

(dom/element-disabled? ...)
(element-disabled?     ...)
```

</details>

---

### element-enabled?

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-enabled? my-element)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn element-enabled?
  [element]
  (-> element .-disabled not))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [element-enabled?]]))

(dom/element-enabled? ...)
(element-enabled?     ...)
```

</details>

---

### element-focused?

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-focused? my-element)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn element-focused?
  [element]
  (= element (get-active-element)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [element-focused?]]))

(dom/element-focused? ...)
(element-focused?     ...)
```

</details>

---

### element-on-viewport-bottom?

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-on-viewport-bottom? my-element)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn element-on-viewport-bottom?
  [element]
  (> (+ (-> element     .-offsetHeight (/ 2))
        (-> element     .getBoundingClientRect .-left)
        (-> js/document .-documentElement      .-scrollTop))
     (-> js/window .-innerWidth (/ 2))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [element-on-viewport-bottom?]]))

(dom/element-on-viewport-bottom? ...)
(element-on-viewport-bottom?     ...)
```

</details>

---

### element-on-viewport-left?

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-on-viewport-left? my-element)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn element-on-viewport-left?
  [element]
  (<= (+ (-> element     .-offsetWidth (/ 2))
         (-> element     .getBoundingClientRect .-left)
         (-> js/document .-documentElement      .-scrollLeft))
      (-> js/window .-innerWidth (/ 2))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [element-on-viewport-left?]]))

(dom/element-on-viewport-left? ...)
(element-on-viewport-left?     ...)
```

</details>

---

### element-on-viewport-right?

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-on-viewport-right? my-element)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn element-on-viewport-right?
  [element]
  (> (+ (-> element     .-offsetWidth (/ 2))
        (-> element     .getBoundingClientRect .-left)
        (-> js/document .-documentElement      .-scrollLeft))
     (-> js/window .-innerWidth (/ 2))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [element-on-viewport-right?]]))

(dom/element-on-viewport-right? ...)
(element-on-viewport-right?     ...)
```

</details>

---

### element-on-viewport-top?

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-on-viewport-top? my-element)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn element-on-viewport-top?
  [element]
  (<= (+ (-> element     .-offsetHeight (/ 2))
         (-> element     .getBoundingClientRect .-left)
         (-> js/document .-documentElement      .-scrollTop))
      (-> js/window .-innerWidth (/ 2))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [element-on-viewport-top?]]))

(dom/element-on-viewport-top? ...)
(element-on-viewport-top?     ...)
```

</details>

---

### empty-element!

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(empty-element! my-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn empty-element!
  [element]
  (while (.-firstChild element)
         (.removeChild element (.-firstChild element)))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [empty-element!]]))

(dom/empty-element! ...)
(empty-element!     ...)
```

</details>

---

### event->node-name

```
@param (DOM-event) event
```

```
@usage
(fn [my-event]
    (event->node-name my-event))
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn event->node-name
  [event]
  (-> event .-srcElement .-nodeName))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [event->node-name]]))

(dom/event->node-name ...)
(event->node-name     ...)
```

</details>

---

### event->value

```
@param (dom-event) n
```

```
@usage
(fn [my-event]
    (event->value my-event))
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn event->value
  [n]
  (-> n .-target .-value))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [event->value]]))

(dom/event->value ...)
(event->value     ...)
```

</details>

---

### file->file-data

```
@param (integer)(opt) file-dex
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->file-data 2 my-file)
```

```
@return (map)
{:file-dex (integer)
 :filename (string)
 :filesize (B)
 :mime-type (string)
 :object-url (string)}
```

<details>
<summary>Source code</summary>

```
(defn file->file-data
  ([file]
   (file->file-data nil file))

  ([file-dex file]
   {:file-dex   file-dex
    :filename   (.-name file)
    :filesize   (.-size file)
    :mime-type  (.-type file)
    :object-url (.createObjectURL js/URL file)}))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file->file-data]]))

(dom/file->file-data ...)
(file->file-data     ...)
```

</details>

---

### file->filename

```
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->filename my-file)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn file->filename
  [file]
  (.-name file))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file->filename]]))

(dom/file->filename ...)
(file->filename     ...)
```

</details>

---

### file->filesize

```
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->filesize my-file)
```

```
@return (B)
```

<details>
<summary>Source code</summary>

```
(defn file->filesize
  [file]
  (.-size file))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file->filesize]]))

(dom/file->filesize ...)
(file->filesize     ...)
```

</details>

---

### file->image?

```
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->image? my-file)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn file->image?
  [file]
  (-> file .-type io/mime-type->image?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file->image?]]))

(dom/file->image? ...)
(file->image?     ...)
```

</details>

---

### file->mime-type

```
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->mime-type my-file)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn file->mime-type
  [file]
  (.-type file))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file->mime-type]]))

(dom/file->mime-type ...)
(file->mime-type     ...)
```

</details>

---

### file-selector->any-file-selected?

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->any-file-selected? my-file-selector)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->any-file-selected?
  [file-selector]
  (-> file-selector .-files .-length (> 0)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->any-file-selected?]]))

(dom/file-selector->any-file-selected? ...)
(file-selector->any-file-selected?     ...)
```

</details>

---

### file-selector->file

```
@param (DOM-element) file-selector
@param (integer) file-dex
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->file my-file-selector 2)
```

```
@return (file object)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->file
  [file-selector file-dex]
  (-> file-selector .-files array-seq (nth file-dex)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->file]]))

(dom/file-selector->file ...)
(file-selector->file     ...)
```

</details>

---

### file-selector->file-count

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->file-count my-file-selector)
```

```
@return (integer)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->file-count
  [file-selector]
  (-> file-selector .-files .-length))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->file-count]]))

(dom/file-selector->file-count ...)
(file-selector->file-count     ...)
```

</details>

---

### file-selector->file-list

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->file-list my-file-selector)
```

```
@return (file objects in vector)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->file-list
  [file-selector]
  (-> file-selector .-files array-seq))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->file-list]]))

(dom/file-selector->file-list ...)
(file-selector->file-list     ...)
```

</details>

---

### file-selector->files

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->files my-file-selector)
```

```
@return (?)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->files
  [file-selector]
  (-> file-selector .-files))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->files]]))

(dom/file-selector->files ...)
(file-selector->files     ...)
```

</details>

---

### file-selector->files-data

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->files-data my-file-selector)
```

```
@return (maps in vector)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->files-data
  [file-selector]
  (letfn [(f [%1 %2 %3] (conj %1 (file/file->file-data %2 %3)))]
         (reduce-kv f [] (-> file-selector .-files array-seq vec))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->files-data]]))

(dom/file-selector->files-data ...)
(file-selector->files-data     ...)
```

</details>

---

### file-selector->files-meta

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->files-meta my-file-selector)
```

```
@return (map)
{:file-count (integer)
 :files-size (B)}
```

<details>
<summary>Source code</summary>

```
(defn file-selector->files-meta
  [file-selector]
  {:file-count (file-selector->file-count file-selector)
   :files-size (file-selector->files-size file-selector)})
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->files-meta]]))

(dom/file-selector->files-meta ...)
(file-selector->files-meta     ...)
```

</details>

---

### file-selector->files-size

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->files-size my-file-selector)
```

```
@return (B)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->files-size
  [file-selector]
  (letfn [(f [%1 %2] (+ %1 (.-size %2)))]
         (reduce f 0 (-> file-selector .-files array-seq))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->files-size]]))

(dom/file-selector->files-size ...)
(file-selector->files-size     ...)
```

</details>

---

### file-selector->form-data

```
@param (DOM-element) file-selector
@param (strings in vector)(opt) filtered-file-keys
```

```
@usage
(def my-file-selector (get-elementy-by-id "my-file-selector"))
(file-selector->form-data my-file-selector)
```

```
@usage
(def my-file-selector (get-elementy-by-id "my-file-selector"))
(file-selector->form-data my-file-selector ["0" "1" "4"])
```

```
@return (FormData object)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->form-data
  [file-selector & [filtered-file-keys]]
  (let [files     (file-selector/file-selector->files file-selector)
        form-data (js/FormData.)
        file-keys (.keys js/Object files)
        file-keys (or filtered-file-keys file-keys)]
       (doseq [file-key file-keys]
              (let [file (aget files file-key)]
                   (append-to-form-data! form-data file-key file)))
       (return form-data)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->form-data]]))

(dom/file-selector->form-data ...)
(file-selector->form-data     ...)
```

</details>

---

### file-selector->image-data-url

```
@param (DOM-element) file-selector
@param (integer) file-dex
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->image-data-url my-file-selector 2)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->image-data-url
  [file-selector file-dex]
  (let [file        (file-selector->file file-selector file-dex)
        file-reader (js/FileReader.)]))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->image-data-url]]))

(dom/file-selector->image-data-url ...)
(file-selector->image-data-url     ...)
```

</details>

---

### file-selector->mime-types

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->mime-types my-file-selector)
```

```
@return (strings in vector)
```

<details>
<summary>Source code</summary>

```
(defn file-selector->mime-types
  [file-selector]
  (letfn [(f [%1 %2] (conj %1 (.-type %2)))]
         (reduce f [] (-> file-selector .-files array-seq))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->mime-types]]))

(dom/file-selector->mime-types ...)
(file-selector->mime-types     ...)
```

</details>

---

### focus-element!

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(focus-element! my-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn focus-element!
  [element]
  (.focus element)
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [focus-element!]]))

(dom/focus-element! ...)
(focus-element!     ...)
```

</details>

---

### get-active-element

```
@usage
(get-active-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn get-active-element
  []
  (.-activeElement js/document))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-active-element]]))

(dom/get-active-element)
(get-active-element)
```

</details>

---

### get-body-element

```
@usage
(get-body-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn get-body-element
  []
  (-> js/document (.getElementsByTagName "body")
                  (aget 0)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-body-element]]))

(dom/get-body-element)
(get-body-element)
```

</details>

---

### get-body-style-value

```
@param (string) style-name
```

```
@usage
(get-body-style-value "background-color")
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-body-style-value
  [style-name]
  (-> js/window (.getComputedStyle (-> js/document (.getElementsByTagName "body")
                                                   (aget 0)))
                (aget style-name)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-body-style-value]]))

(dom/get-body-style-value ...)
(get-body-style-value     ...)
```

</details>

---

### get-document-element

```
@usage
(get-document-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn get-document-element
  []
  (.-documentElement js/document))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-document-element]]))

(dom/get-document-element)
(get-document-element)
```

</details>

---

### get-document-height

```
@usage
(get-document-height)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-document-height
  []
  (-> js/document .-documentElement .-scrollHeight))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-document-height]]))

(dom/get-document-height)
(get-document-height)
```

</details>

---

### get-document-title

```
@usage
(get-document-title)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-document-title
  []
  (str (-> js/document .-title)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-document-title]]))

(dom/get-document-title)
(get-document-title)
```

</details>

---

### get-document-width

```
@usage
(get-document-width)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-document-width
  []
  (-> js/document .-documentElement .-scrollWidth))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-document-width]]))

(dom/get-document-width)
(get-document-width)
```

</details>

---

### get-element-absolute-left

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-absolute-left my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-absolute-left
  [element]
  (math/round (+ (-> element     .getBoundingClientRect .-left)
                 (-> js/document .-documentElement .-scrollLeft))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-absolute-left]]))

(dom/get-element-absolute-left ...)
(get-element-absolute-left     ...)
```

</details>

---

### get-element-absolute-top

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-absolute-top my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-absolute-top
  [element]
  (math/round (+ (-> element     .getBoundingClientRect .-top)
                 (-> js/document .-documentElement .-scrollTop))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-absolute-top]]))

(dom/get-element-absolute-top ...)
(get-element-absolute-top     ...)
```

</details>

---

### get-element-attribute

```
@param (DOM-element) element
@param (string) attribute-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-attribute my-element "my-attribute")
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-element-attribute
  [element attribute-name]
  (.getAttribute element attribute-name))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-attribute]]))

(dom/get-element-attribute ...)
(get-element-attribute     ...)
```

</details>

---

### get-element-attributes

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-attributes my-element)
```

```
@return (map)
```

<details>
<summary>Source code</summary>

```
(defn get-element-attributes
  [element]
  (.getAttributes element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-attributes]]))

(dom/get-element-attributes ...)
(get-element-attributes     ...)
```

</details>

---

### get-element-by-id

```
@param (DOM-element)(opt) parent-element
Default: js/document
@param (string) element-id
```

```
@usage
(get-element-by-id "my-element")
```

```
@return (DOM-element or nil)
```

<details>
<summary>Source code</summary>

```
(defn get-element-by-id
  ([element-id]                (.getElementById js/document    element-id))
  ([parent-element element-id] (.getElementById parent-element element-id)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-by-id]]))

(dom/get-element-by-id ...)
(get-element-by-id     ...)
```

</details>

---

### get-element-by-query

```
@param (DOM-element)(opt) parent-element
Default: js/document
@param (string) query
```

```
@usage
(get-element-by-query ":scope > div")
```

```
@usage
(get-element-by-query "[type=\"text/css\"]")
```

```
@usage
(get-element-by-query "div.my-class, div.your-class")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn get-element-by-query
  ([query]                (-> js/document    (.querySelector query)))
  ([parent-element query] (-> parent-element (.querySelector query))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-by-query]]))

(dom/get-element-by-query ...)
(get-element-by-query     ...)
```

</details>

---

### get-element-computed-style

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-computed-style my-element)
```

```
@return (CSSStyleDeclarationObject)
The returned object updates automatically when the element's styles are changed
```

<details>
<summary>Source code</summary>

```
(defn get-element-computed-style
  [element]
  (.getComputedStyle js/window element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-computed-style]]))

(dom/get-element-computed-style ...)
(get-element-computed-style     ...)
```

</details>

---

### get-element-height

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-height my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-height
  [element]
  (.-offsetHeight element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-height]]))

(dom/get-element-height ...)
(get-element-height     ...)
```

</details>

---

### get-element-masspoint-orientation

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-masspoint-orientation my-element)
```

```
@return (keyword)
:bl, :br, :tl, :tr
```

<details>
<summary>Source code</summary>

```
(defn get-element-masspoint-orientation
  [element]
  (if (element-on-viewport-bottom? element)
      (if (element-on-viewport-left? element)
          (return :bl)
          (return :br))
      (if (element-on-viewport-left? element)
          (return :tl)
          (return :tr))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-masspoint-orientation]]))

(dom/get-element-masspoint-orientation ...)
(get-element-masspoint-orientation     ...)
```

</details>

---

### get-element-masspoint-x

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-masspoint-x my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-masspoint-x
  [element]
  (math/round (+ (-> element     .-offsetWidth (/ 2))
                 (-> element     .getBoundingClientRect .-left)
                 (-> js/document .-documentElement      .-scrollLeft))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-masspoint-x]]))

(dom/get-element-masspoint-x ...)
(get-element-masspoint-x     ...)
```

</details>

---

### get-element-masspoint-y

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-masspoint-y my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-masspoint-y
  [element]
  (math/round (+ (-> element     .-offsetHeight (/ 2))
                 (-> element     .getBoundingClientRect .-left)
                 (-> js/document .-documentElement      .-scrollTop))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-masspoint-y]]))

(dom/get-element-masspoint-y ...)
(get-element-masspoint-y     ...)
```

</details>

---

### get-element-offset-left

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-offset-left my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-offset-left
  [element]
  (-> element .-offsetLeft math/round))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-offset-left]]))

(dom/get-element-offset-left ...)
(get-element-offset-left     ...)
```

</details>

---

### get-element-offset-top

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-offset-top my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-offset-top
  [element]
  (-> element .-offsetTop math/round))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-offset-top]]))

(dom/get-element-offset-top ...)
(get-element-offset-top     ...)
```

</details>

---

### get-element-relative-left

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-relative-left my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-relative-left
  [element]
  (-> element .getBoundingClientRect .-left math/round))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-relative-left]]))

(dom/get-element-relative-left ...)
(get-element-relative-left     ...)
```

</details>

---

### get-element-relative-top

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-relative-top my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-relative-top
  [element]
  (-> element .getBoundingClientRect .-top math/round))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-relative-top]]))

(dom/get-element-relative-top ...)
(get-element-relative-top     ...)
```

</details>

---

### get-element-style

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-style my-element)
```

<details>
<summary>Source code</summary>

```
(defn get-element-style
  [element])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-style]]))

(dom/get-element-style ...)
(get-element-style     ...)
```

</details>

---

### get-element-style-value

```
@param (DOM-element) element
@param (string) style-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-style my-element "position")
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-element-style-value
  [element style-name]
  (-> js/window (.getComputedStyle element)
                (aget style-name)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-style-value]]))

(dom/get-element-style-value ...)
(get-element-style-value     ...)
```

</details>

---

### get-element-width

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-width my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-width
  [element]
  (.-offsetWidth element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-element-width]]))

(dom/get-element-width ...)
(get-element-width     ...)
```

</details>

---

### get-elements-by-class-name

```
@param (DOM-element)(opt) parent-element
Default: js/document
@param (string) class-name
```

```
@usage
(get-elements-by-class-name "my-class")
```

```
@return (vector)
```

<details>
<summary>Source code</summary>

```
(defn get-elements-by-class-name
  ([class-name]                (-> js/document    (.getElementsByClassName class-name) array-seq vec))
  ([parent-element class-name] (-> parent-element (.getElementsByClassName class-name) array-seq vec)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-elements-by-class-name]]))

(dom/get-elements-by-class-name ...)
(get-elements-by-class-name     ...)
```

</details>

---

### get-elements-by-query

```
@param (DOM-element)(opt) parent-element
Default: js/document
@param (string) query
```

```
@usage
(get-elements-by-query ":scope > div")
```

```
@usage
(get-elements-by-query "[type=\"text/css\"]")
```

```
@usage
(get-elements-by-query "div.my-class, div.your-class")
```

```
@return (vector)
```

<details>
<summary>Source code</summary>

```
(defn get-elements-by-query
  ([query]                (-> js/document    (.querySelectorAll query) array-seq vec))
  ([parent-element query] (-> parent-element (.querySelectorAll query) array-seq vec)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-elements-by-query]]))

(dom/get-elements-by-query ...)
(get-elements-by-query     ...)
```

</details>

---

### get-elements-by-tag-name

```
@param (DOM-element)(opt) parent-element
Default: js/document
@param (string) tag-name
```

```
@usage
(get-elements-by-class-name "div")
```

```
@return (vector)
```

<details>
<summary>Source code</summary>

```
(defn get-elements-by-tag-name
  ([tag-name]                (-> js/document    (.getElementsByTagName tag-name) array-seq vec))
  ([parent-element tag-name] (-> parent-element (.getElementsByTagName tag-name) array-seq vec)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-elements-by-tag-name]]))

(dom/get-elements-by-tag-name ...)
(get-elements-by-tag-name     ...)
```

</details>

---

### get-head-element

```
@usage
(get-head-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn get-head-element
  []
  (-> js/document (.getElementsByTagName "head")
                  (aget 0)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-head-element]]))

(dom/get-head-element)
(get-head-element)
```

</details>

---

### get-mouse-viewport-quarter

```
@param (DOM-event) mouse-event
```

```
@usage
(fn [mouse-event]
    (get-mouse-viewport-quarter mouse-event))
```

```
@return (keyword)
:tl, :tr, :bl, :br
```

<details>
<summary>Source code</summary>

```
(defn get-mouse-viewport-quarter
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
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-mouse-viewport-quarter]]))

(dom/get-mouse-viewport-quarter ...)
(get-mouse-viewport-quarter     ...)
```

</details>

---

### get-mouse-x

```
@param (DOM-event) mouse-event
```

```
@usage
(fn [mouse-event]
    (get-mouse-x mouse-event))
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-mouse-x
  [mouse-event]
  (.-clientX mouse-event))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-mouse-x]]))

(dom/get-mouse-x ...)
(get-mouse-x     ...)
```

</details>

---

### get-mouse-y

```
@param (DOM-event) mouse-event
```

```
@usage
(fn [mouse-event]
    (get-mouse-x %))
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-mouse-y
  [mouse-event]
  (.-clientY mouse-event))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-mouse-y]]))

(dom/get-mouse-y ...)
(get-mouse-y     ...)
```

</details>

---

### get-scroll-direction

```
@param (integer) last-scroll-y
```

```
@usage
(get-scroll-direction 100)
```

```
@return (keyword or nil)
 nil, :btt, :ttb
```

<details>
<summary>Source code</summary>

```
(defn get-scroll-direction
  [last-scroll-y]
  (cond (and (scroll-direction-ttb? last-scroll-y)
             (math/nonnegative?     last-scroll-y))
        (return :ttb)

        (and (scroll-direction-btt? last-scroll-y)
             (math/nonnegative?     last-scroll-y))
        (return :btt)

        (math/negative? last-scroll-y)
        (return :btt)

        :return nil))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-scroll-direction]]))

(dom/get-scroll-direction ...)
(get-scroll-direction     ...)
```

</details>

---

### get-scroll-progress

```
@usage
(get-scroll-progress)
```

```
@return (percent)
0 - 100
```

<details>
<summary>Source code</summary>

```
(defn get-scroll-progress
  []
  (let [viewport-height (-> js/window   .-innerHeight)
        scroll-y        (-> js/document .-documentElement .-scrollTop)
        document-height (-> js/document .-documentElement .-scrollHeight)
        max-scroll-y    (- document-height viewport-height)
        scroll-progress (math/percent max-scroll-y scroll-y)]
      (math/between! scroll-progress 0 100)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-scroll-progress]]))

(dom/get-scroll-progress)
(get-scroll-progress)
```

</details>

---

### get-scroll-x

```
@usage
(get-scroll-x)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-scroll-x
  []
  (-> js/document .-documentElement .-scrollLeft))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-scroll-x]]))

(dom/get-scroll-x)
(get-scroll-x)
```

</details>

---

### get-scroll-y

```
@usage
(get-scroll-y)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-scroll-y
  []
  (-> js/document .-documentElement .-scrollTop))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-scroll-y]]))

(dom/get-scroll-y)
(get-scroll-y)
```

</details>

---

### get-selection-end

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-selection-end my-element)
```

```
@return (integer)
```

<details>
<summary>Source code</summary>

```
(defn get-selection-end
  [element]
  (.-selectionStart element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-selection-end]]))

(dom/get-selection-end ...)
(get-selection-end     ...)
```

</details>

---

### get-selection-start

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-selection-start my-element)
```

```
@return (integer)
```

<details>
<summary>Source code</summary>

```
(defn get-selection-start
  [element]
  (.-selectionStart element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [get-selection-start]]))

(dom/get-selection-start ...)
(get-selection-start     ...)
```

</details>

---

### insert-after!

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
@param (DOM-element) before-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-before-element (get-element-by-id "my-before-element"))
(def my-child-element  (create-element! "div"))
(insert-after! my-parent-element my-child-element my-before-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn insert-after!
  [parent-element child-element before-element]
  (.insertBefore parent-element child-element (.-nextSibling before-element))
  (return        parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [insert-after!]]))

(dom/insert-after! ...)
(insert-after!     ...)
```

</details>

---

### insert-as-first-of-query-selected!

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
@param (string) query
```

```
@usage
(def head-element    (get-head-element))
(def my-link-element (create-element! "link"))
(insert-as-first-of-query-selected! head-element my-link-element "[type=\"text/css\"]")
```

```
@usage
(def body-element (get-body-element))
(def my-element   (create-element! "div"))
(insert-as-first-of-query-selected! body-element my-element "div.my-class, div.your-class")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn insert-as-first-of-query-selected!
  [parent-element child-element query]
  (.insertBefore parent-element child-element
                 (-> parent-element (.querySelectorAll query) array-seq first))
  (return parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [insert-as-first-of-query-selected!]]))

(dom/insert-as-first-of-query-selected! ...)
(insert-as-first-of-query-selected!     ...)
```

</details>

---

### insert-as-first-of-type!

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (create-element! "div"))
(insert-as-first-of-type! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn insert-as-first-of-type!
  [parent-element child-element]
  (let [tag-name (-> child-element .-tagName)
        query    (str ":scope > "tag-name)]
       (.insertBefore parent-element child-element
                      (-> parent-element (.querySelectorAll query)
                          array-seq first)))
  (return parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [insert-as-first-of-type!]]))

(dom/insert-as-first-of-type! ...)
(insert-as-first-of-type!     ...)
```

</details>

---

### insert-as-last-of-query-selected!

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
@param (string) query
```

```
@usage
(def head-element    (get-head-element))
(def my-link-element (create-element! "link"))
(insert-as-first-of-query-selected! head-element my-link-element "[type=\"text/css\"]")
```

```
@usage
(def body-element (get-body-element))
(def my-element   (create-element! "div"))
(insert-as-first-of-query-selected! body-element my-element "div.my-class, div.your-class")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn insert-as-last-of-query-selected!
  [parent-element child-element query]
  (.insertBefore parent-element child-element
                 (-> parent-element (.querySelectorAll query) array-seq last .-nextSibling))
  (return parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [insert-as-last-of-query-selected!]]))

(dom/insert-as-last-of-query-selected! ...)
(insert-as-last-of-query-selected!     ...)
```

</details>

---

### insert-as-last-of-type!

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (create-element! "div"))
(insert-as-last-of-type! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn insert-as-last-of-type!
  [parent-element child-element]
  (let [tag-name (-> child-element .-tagName)
        query    (str ":scope > "tag-name)]
       (.insertBefore parent-element child-element
                      (-> parent-element (.querySelectorAll query)
                          array-seq last .-nextSibling)))
  (return parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [insert-as-last-of-type!]]))

(dom/insert-as-last-of-type! ...)
(insert-as-last-of-type!     ...)
```

</details>

---

### insert-before!

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
@param (DOM-element) after-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-after-element  (get-element-by-id "my-after-element"))
(def my-child-element  (create-element! "div"))
(insert-before! my-parent-element my-child-element my-after-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn insert-before!
  [parent-element child-element after-element]
  (.insertBefore parent-element child-element after-element)
  (return        parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [insert-before!]]))

(dom/insert-before! ...)
(insert-before!     ...)
```

</details>

---

### intersection-observer

```
@param (function) callback-f
```

```
@usage
(intersection-observer (fn [intersecting?] ...))
```

```
@return (?)
```

<details>
<summary>Source code</summary>

```
(defn intersection-observer
  [callback-f]
  (letfn [(f [%] (callback-f (-> % (aget 0) .-isIntersecting)))]
         (js/IntersectionObserver. f {})))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [intersection-observer]]))

(dom/intersection-observer ...)
(intersection-observer     ...)
```

</details>

---

### merge-to-form-data!

```
@param (FormData object) form-data
@param (list of maps) xyz
```

```
@usage
(def my-form-data (js/FormData.))
(merge-to-form-data! my-form-data {...})
```

```
@usage
(def my-form-data (js/FormData.))
(merge-to-form-data! my-form-data {...} {...} {...})
```

```
@return (FormData object)
```

<details>
<summary>Source code</summary>

```
(defn merge-to-form-data!
  [form-data & xyz]
  (doseq [n xyz]
         (doseq [[k v] n]
                (append-to-form-data! form-data k v)))
  (return form-data))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [merge-to-form-data!]]))

(dom/merge-to-form-data! ...)
(merge-to-form-data!     ...)
```

</details>

---

### move-caret-to-end!

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(move-caret-to-end! my-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn move-caret-to-end!
  [element]
  (let [length (-> element .-value .-length)]
       (set-selection-range! element length length))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [move-caret-to-end!]]))

(dom/move-caret-to-end! ...)
(move-caret-to-end!     ...)
```

</details>

---

### move-caret-to-start!

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(move-caret-to-start! my-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn move-caret-to-start!
  [element]
  (set-selection-range! element 0 0)
  (return               element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [move-caret-to-start!]]))

(dom/move-caret-to-start! ...)
(move-caret-to-start!     ...)
```

</details>

---

### on-mouse-left

```
@param (DOM-event) mouse-event
@param (function) f
```

```
@usage
(on-mouse-left % (fn [mouse-event] ...))
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn on-mouse-left
  [mouse-event f]
  (if (= (.-button mouse-event) 0)
      (f)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [on-mouse-left]]))

(dom/on-mouse-left ...)
(on-mouse-left     ...)
```

</details>

---

### prepend-element!

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (create-element! "div"))
(prepend-element! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn prepend-element!
  [parent-element child-element]
  (.insertBefore parent-element child-element (.-firstChild parent-element))
  (return        parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [prepend-element!]]))

(dom/prepend-element! ...)
(prepend-element!     ...)
```

</details>

---

### prevent-default!

```
@param (DOM-event) event
```

```
@usage
(fn [my-event]
    (prevent-default! my-event))
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn prevent-default!
  [event]
  (.preventDefault event))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [prevent-default!]]))

(dom/prevent-default! ...)
(prevent-default!     ...)
```

</details>

---

### remove-child!

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (get-element-by-id "my-child-element"))
(remove-child! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn remove-child!
  [parent-element child-element]
  (.removeChild parent-element child-element)
  (return       parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [remove-child!]]))

(dom/remove-child! ...)
(remove-child!     ...)
```

</details>

---

### remove-element!

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element! my-element)
```

```
@return (undefined)
```

<details>
<summary>Source code</summary>

```
(defn remove-element!
  [element]
  (.remove element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [remove-element!]]))

(dom/remove-element! ...)
(remove-element!     ...)
```

</details>

---

### remove-element-attribute!

```
@param (DOM-element) element
@param (string) attribute-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-attribute! my-element "my-attribute")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn remove-element-attribute!
  [element attribute-name]
  (.removeAttribute element attribute-name)
  (return           element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-attribute!]]))

(dom/remove-element-attribute! ...)
(remove-element-attribute!     ...)
```

</details>

---

### remove-element-attributes!

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-attribute! my-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn remove-element-attributes!
  [element]
  (.removeAttributes element)
  (return            element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-attributes!]]))

(dom/remove-element-attributes! ...)
(remove-element-attributes!     ...)
```

</details>

---

### remove-element-class!

```
@param (DOM-element) element
@param (string) class-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-class! my-element "my-class")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn remove-element-class!
  [element class-name]
  (->     element .-classList (.remove class-name))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-class!]]))

(dom/remove-element-class! ...)
(remove-element-class!     ...)
```

</details>

---

### remove-element-style!

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-style! my-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn remove-element-style!
  [element]
  (.removeAttribute element "style")
  (return           element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-style!]]))

(dom/remove-element-style! ...)
(remove-element-style!     ...)
```

</details>

---

### remove-element-style-value!

```
@param (DOM-element) element
@param (string) style-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-style-value! my-element "position")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn remove-element-style-value!

  [element style-name]
  (->     element .-style (aset style-name nil))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-style-value!]]))

(dom/remove-element-style-value! ...)
(remove-element-style-value!     ...)
```

</details>

---

### remove-event-listener!

```
@param (string) type
@param (function) listener-f
@param (DOM-element)(opt) target
Default: js/window
```

```
@usage
(def my-listener-f (fn [event]))
(remove-event-listener! "mousemove" my-listener-f)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn remove-event-listener!
  ([type listener-f]
   (remove-event-listener! type listener-f js/window))

  ([type listener-f target]
   (.removeEventListener target type listener-f false)
   (return               target)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [remove-event-listener!]]))

(dom/remove-event-listener! ...)
(remove-event-listener!     ...)
```

</details>

---

### remove-intersection-observer!

```
@param (?) observer
@param (DOM-element) element
```

```
@usage
(def my-element  (get-element-by-id "my-element"))
(def my-observer (intersection-observer! my-element (fn [intersecting?])))
(remove-intersection-observer! my-observer my-element)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn remove-intersection-observer!
  [observer element]
  (.unobserve observer element)
  (return     observer))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [remove-intersection-observer!]]))

(dom/remove-intersection-observer! ...)
(remove-intersection-observer!     ...)
```

</details>

---

### scroll-direction-btt?

```
@param (integer) last-scroll-y
```

```
@usage
(scroll-direction-btt? 100)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn scroll-direction-btt?
  [last-scroll-y]
  (> (- last-scroll-y config/SCROLL-DIRECTION-SENSITIVITY)
     (-> js/document .-documentElement .-scrollTop)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [scroll-direction-btt?]]))

(dom/scroll-direction-btt? ...)
(scroll-direction-btt?     ...)
```

</details>

---

### scroll-direction-ttb?

```
@param (integer) last-scroll-y
```

```
@usage
(scroll-direction-ttb? 100)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn scroll-direction-ttb?
  [last-scroll-y]
  (< (+ last-scroll-y config/SCROLL-DIRECTION-SENSITIVITY)
     (-> js/document .-documentElement .-scrollTop)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [scroll-direction-ttb?]]))

(dom/scroll-direction-ttb? ...)
(scroll-direction-ttb?     ...)
```

</details>

---

### scroll-to-element-top!

```
@param (DOM-element) element
@param (px)(opt) offset
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(scroll-to-element-top! my-element)
```

<details>
<summary>Source code</summary>

```
(defn scroll-to-element-top!
  ([element]
   (scroll-to-element-top! element 0))

  ([element offset]
   (-> js/document .-documentElement .-scrollTop
       (set! (+ offset (-> element     .getBoundingClientRect .-top)
                       (-> js/document .-documentElement      .-scrollTop))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [scroll-to-element-top!]]))

(dom/scroll-to-element-top! ...)
(scroll-to-element-top!     ...)
```

</details>

---

### select-preventer

```
@param (DOM-event) mouse-event
```

```
@usage
(fn [mouse-event]
    (select-preventer mouse-event))
```

<details>
<summary>Source code</summary>

```
(defn select-preventer
  [mouse-event]
  (let [node-name (-> mouse-event .-srcElement .-nodeName string/to-lowercase)]
       (when-not (or (= node-name "input")
                     (= node-name "textarea"))
                 (do (-> mouse-event .preventDefault)
                     (-> js/document .-activeElement .blur)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [select-preventer]]))

(dom/select-preventer ...)
(select-preventer     ...)
```

</details>

---

### set-caret-position!

```
@param (DOM-element) element
@param (integer) caret-position
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-caret-position! my-element 20)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-caret-position!
  [element caret-position]
  (set-selection-start! element caret-position)
  (set-selection-end!   element caret-position)
  (return               element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-caret-position!]]))

(dom/set-caret-position! ...)
(set-caret-position!     ...)
```

</details>

---

### set-document-title!

```
@param (string) title
```

```
@usage
(set-document-title! "My title")
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn set-document-title!
  [title]
  (set! (-> js/document .-title) title)
  (return title))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-document-title!]]))

(dom/set-document-title! ...)
(set-document-title!     ...)
```

</details>

---

### set-element-attribute!

```
@param (DOM-element) element
@param (string) attribute-name
@param (string) attribute-value
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-attribute! my-element "my-attribute" "my-value")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-element-attribute!
  [element attribute-name attribute-value]
  (.setAttribute element attribute-name attribute-value)
  (return        element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-element-attribute!]]))

(dom/set-element-attribute! ...)
(set-element-attribute!     ...)
```

</details>

---

### set-element-attributes!

```
@param (DOM-element) element
@param (map) attributes
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-attributes! my-element {"my-attribute" "my-value"})
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-element-attributes!
  [element attributes]
  (letfn [(f [_ attribute-name attribute-value]
             (if (keyword? attribute-name)
                 (.setAttribute element (name attribute-name) attribute-value)
                 (.setAttribute element       attribute-name  attribute-value)))]
         (reduce-kv f nil attributes))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-element-attributes!]]))

(dom/set-element-attributes! ...)
(set-element-attributes!     ...)
```

</details>

---

### set-element-class!

```
@param (DOM-element) element
@param (string) class-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-class! my-element "my-class")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-element-class!
  [element class-name]
  (->     element .-classList (.add class-name))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-element-class!]]))

(dom/set-element-class! ...)
(set-element-class!     ...)
```

</details>

---

### set-element-content!

```
@param (DOM-element) element
@param (string) content
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-content! my-element "Hakuna Matata!")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-element-content!
  [element content]
  (->     element .-innerHTML (set! content))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-element-content!]]))

(dom/set-element-content! ...)
(set-element-content!     ...)
```

</details>

---

### set-element-id!

```
@param (DOM-element) element
@param (string) element-id
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-id! my-element "my-element-id")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-element-id!
  [element element-id]
  (->     element .-id (set! element-id))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-element-id!]]))

(dom/set-element-id! ...)
(set-element-id!     ...)
```

</details>

---

### set-element-style!

```
@param (DOM-element) element
@param (map) style
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-style! my-element {:position "fixed" :top "0"})
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-element-style!
  [element style]
  (let [parsed-style (css/unparse style)]
       (.setAttribute element "style" parsed-style))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-element-style!]]))

(dom/set-element-style! ...)
(set-element-style!     ...)
```

</details>

---

### set-element-style-value!

```
@param (DOM-element) element
@param (string) style-name
@param (*) style-value
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-style-value! my-element "position" "fixed")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-element-style-value!
  [element style-name style-value]
  (->     element .-style (aset style-name style-value))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-element-style-value!]]))

(dom/set-element-style-value! ...)
(set-element-style-value!     ...)
```

</details>

---

### set-scroll-x!

```
@param (px) scroll-x
@param (map)(opt) options
{:smooth? (boolean)
  Default: false}
```

```
@usage
(set-scroll-x! 100)
```

<details>
<summary>Source code</summary>

```
(defn set-scroll-x!
  ([scroll-x]
   (set-scroll-x! scroll-x {}))

  ([scroll-x {:keys [smooth?]}]
   (-> js/document .-documentElement .-scrollLeft (set! scroll-x))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-scroll-x!]]))

(dom/set-scroll-x! ...)
(set-scroll-x!     ...)
```

</details>

---

### set-scroll-y!

```
@param (px) scroll-y
@param (map)(opt) options
{:smooth? (boolean)
  Default: false}
```

```
@usage
(set-scroll-y! 100)
```

<details>
<summary>Source code</summary>

```
(defn set-scroll-y!
  ([scroll-y]
   (set-scroll-y! scroll-y {}))

  ([scroll-y {:keys [smooth?]}]
   (-> js/document .-documentElement .-scrollTop (set! scroll-y))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-scroll-y!]]))

(dom/set-scroll-y! ...)
(set-scroll-y!     ...)
```

</details>

---

### set-selection-end!

```
@param (DOM-element) element
@param (integer) selection-end
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-selection-end! my-element 2)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-selection-end!
  [element selection-end]
  (->     element .-selectionEnd (set! selection-end))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-selection-end!]]))

(dom/set-selection-end! ...)
(set-selection-end!     ...)
```

</details>

---

### set-selection-range!

```
@param (DOM-element) element
@param (integer) selection-start
@param (integer) selection-end
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-selection-range! my-element 2 10)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-selection-range!
  [element selection-start selection-end]
  (set-selection-start! element selection-start)
  (set-selection-end!   element selection-end)
  (return               element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-selection-range!]]))

(dom/set-selection-range! ...)
(set-selection-range!     ...)
```

</details>

---

### set-selection-start!

```
@param (DOM-element) element
@param (integer) selection-start
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-selection-start! my-element 2)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn set-selection-start!
  [element selection-start]
  (->     element .-selectionStart (set! selection-start))
  (return element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [set-selection-start!]]))

(dom/set-selection-start! ...)
(set-selection-start!     ...)
```

</details>

---

### setup-intersection-observer!

```
@param (DOM-element) element
@param (function) callback-f
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(setup-intersection-observer! my-element (fn [intersecting?] ...))
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn setup-intersection-observer!
  [element callback-f]
  (let [observer (intersection-observer callback-f)]
       (.observe observer element)
       (return   observer)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [setup-intersection-observer!]]))

(dom/setup-intersection-observer! ...)
(setup-intersection-observer!     ...)
```

</details>

---

### stop-propagation!

```
@param (DOM-event) event
```

```
@usage
(fn [my-event]
    (stop-propagation! my-event))
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn stop-propagation!
  [event]
  (.stopPropagation event))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [stop-propagation!]]))

(dom/stop-propagation! ...)
(stop-propagation!     ...)
```

</details>

---

### toggle-design-mode!

```
@usage
(toggle-design-mode!)
```

<details>
<summary>Source code</summary>

```
(defn toggle-design-mode!
  []
  (let [design-mode (-> js/document .-designMode)]
       (case design-mode "on" (aset js/document "designMode" "off")
                              (aset js/document "designMode" "on"))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :as dom :refer [toggle-design-mode!]]))

(dom/toggle-design-mode!)
(toggle-design-mode!)
```

</details>

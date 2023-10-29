
# dom.api ClojureScript namespace

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > dom.api

### Index

- [append-element!](#append-element)

- [append-script!](#append-script)

- [append-to-form-data!](#append-to-form-data)

- [blur-active-element!](#blur-active-element)

- [blur-element!](#blur-element)

- [create-element!](#create-element)

- [element-blurred?](#element-blurred)

- [element-disabled?](#element-disabled)

- [element-enabled?](#element-enabled)

- [element-focused?](#element-focused)

- [element-on-viewport-bottom?](#element-on-viewport-bottom)

- [element-on-viewport-left?](#element-on-viewport-left)

- [element-on-viewport-right?](#element-on-viewport-right)

- [element-on-viewport-top?](#element-on-viewport-top)

- [empty-element!](#empty-element)

- [event->node-name](#event-node-name)

- [event->value](#event-value)

- [file->file-data](#file-file-data)

- [file->filename](#file-filename)

- [file->filesize](#file-filesize)

- [file->image?](#file-image)

- [file->mime-type](#file-mime-type)

- [file-selector->any-file-selected?](#file-selector-any-file-selected)

- [file-selector->file](#file-selector-file)

- [file-selector->file-count](#file-selector-file-count)

- [file-selector->file-list](#file-selector-file-list)

- [file-selector->files](#file-selector-files)

- [file-selector->files-data](#file-selector-files-data)

- [file-selector->files-meta](#file-selector-files-meta)

- [file-selector->files-size](#file-selector-files-size)

- [file-selector->form-data](#file-selector-form-data)

- [file-selector->image-data-url](#file-selector-image-data-url)

- [file-selector->mime-types](#file-selector-mime-types)

- [focus-element!](#focus-element)

- [get-active-element](#get-active-element)

- [get-body-element](#get-body-element)

- [get-body-style-value](#get-body-style-value)

- [get-document-element](#get-document-element)

- [get-document-height](#get-document-height)

- [get-document-title](#get-document-title)

- [get-document-width](#get-document-width)

- [get-element-absolute-left](#get-element-absolute-left)

- [get-element-absolute-top](#get-element-absolute-top)

- [get-element-attribute](#get-element-attribute)

- [get-element-attributes](#get-element-attributes)

- [get-element-by-attribute](#get-element-by-attribute)

- [get-element-by-class-name](#get-element-by-class-name)

- [get-element-by-id](#get-element-by-id)

- [get-element-by-query](#get-element-by-query)

- [get-element-by-tag-name](#get-element-by-tag-name)

- [get-element-computed-style](#get-element-computed-style)

- [get-element-height](#get-element-height)

- [get-element-mass-point-orientation](#get-element-mass-point-orientation)

- [get-element-mass-point-x](#get-element-mass-point-x)

- [get-element-mass-point-y](#get-element-mass-point-y)

- [get-element-offset-left](#get-element-offset-left)

- [get-element-offset-top](#get-element-offset-top)

- [get-element-relative-left](#get-element-relative-left)

- [get-element-relative-top](#get-element-relative-top)

- [get-element-style](#get-element-style)

- [get-element-style-value](#get-element-style-value)

- [get-element-width](#get-element-width)

- [get-elements-by-attribute](#get-elements-by-attribute)

- [get-elements-by-class-name](#get-elements-by-class-name)

- [get-elements-by-query](#get-elements-by-query)

- [get-elements-by-tag-name](#get-elements-by-tag-name)

- [get-head-element](#get-head-element)

- [get-mouse-viewport-quarter](#get-mouse-viewport-quarter)

- [get-mouse-x](#get-mouse-x)

- [get-mouse-y](#get-mouse-y)

- [get-scroll-direction](#get-scroll-direction)

- [get-scroll-progress](#get-scroll-progress)

- [get-scroll-x](#get-scroll-x)

- [get-scroll-y](#get-scroll-y)

- [get-selection-end](#get-selection-end)

- [get-selection-start](#get-selection-start)

- [hide-element-animated!](#hide-element-animated)

- [insert-after!](#insert-after)

- [insert-as-first-of-query-selected!](#insert-as-first-of-query-selected)

- [insert-as-first-of-type!](#insert-as-first-of-type)

- [insert-as-last-of-query-selected!](#insert-as-last-of-query-selected)

- [insert-as-last-of-type!](#insert-as-last-of-type)

- [insert-before!](#insert-before)

- [intersection-observer](#intersection-observer)

- [merge-to-form-data!](#merge-to-form-data)

- [move-caret-to-end!](#move-caret-to-end)

- [move-caret-to-start!](#move-caret-to-start)

- [on-mouse-left](#on-mouse-left)

- [parse-html](#parse-html)

- [prepend-element!](#prepend-element)

- [prevent-default!](#prevent-default)

- [remove-child!](#remove-child)

- [remove-element!](#remove-element)

- [remove-element-animated!](#remove-element-animated)

- [remove-element-attribute!](#remove-element-attribute)

- [remove-element-attributes!](#remove-element-attributes)

- [remove-element-class!](#remove-element-class)

- [remove-element-style!](#remove-element-style)

- [remove-element-style-value!](#remove-element-style-value)

- [remove-intersection-observer!](#remove-intersection-observer)

- [reveal-element-animated!](#reveal-element-animated)

- [scroll-direction-btt?](#scroll-direction-btt)

- [scroll-direction-ttb?](#scroll-direction-ttb)

- [scroll-to-element-top!](#scroll-to-element-top)

- [select-preventer](#select-preventer)

- [set-caret-position!](#set-caret-position)

- [set-document-title!](#set-document-title)

- [set-element-attribute!](#set-element-attribute)

- [set-element-attributes!](#set-element-attributes)

- [set-element-class!](#set-element-class)

- [set-element-content!](#set-element-content)

- [set-element-id!](#set-element-id)

- [set-element-style!](#set-element-style)

- [set-element-style-value!](#set-element-style-value)

- [set-scroll-x!](#set-scroll-x)

- [set-scroll-y!](#set-scroll-y)

- [set-selection-end!](#set-selection-end)

- [set-selection-range!](#set-selection-range)

- [set-selection-start!](#set-selection-start)

- [setup-intersection-observer!](#setup-intersection-observer)

- [stop-propagation!](#stop-propagation)

- [toggle-design-mode!](#toggle-design-mode)

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
  (-> parent-element (.appendChild child-element))
  (-> parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [append-element!]]))

(dom.api/append-element! ...)
(append-element!         ...)
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
       (-> script-element (attributes/set-element-attribute! "type" "text/javascript"))
       (-> script-element (node/set-element-content! script))
       (-> body-element   (node/append-element! script-element))
       (-> script-element)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [append-script!]]))

(dom.api/append-script! ...)
(append-script!         ...)
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
  (let [prop-key (if (-> prop-key keyword?)
                     (-> prop-key name)
                     (-> prop-key))]
       (.append form-data prop-key prop-value))
  (-> form-data))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [append-to-form-data!]]))

(dom.api/append-to-form-data! ...)
(append-to-form-data!         ...)
```

</details>

---

### blur-active-element!

```
@usage
(blur-active-element!)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn blur-active-element!
  []
  (if-let [active-element (get-active-element)]
          (blur-element! active-element)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [blur-active-element!]]))

(dom.api/blur-active-element!)
(blur-active-element!)
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
  (-> element .blur)
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [blur-element!]]))

(dom.api/blur-element! ...)
(blur-element!         ...)
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
  (-> js/document (.createElement nodename)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [create-element!]]))

(dom.api/create-element! ...)
(create-element!         ...)
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
(ns my-namespace (:require [dom.api :refer [element-blurred?]]))

(dom.api/element-blurred? ...)
(element-blurred?         ...)
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
(ns my-namespace (:require [dom.api :refer [element-disabled?]]))

(dom.api/element-disabled? ...)
(element-disabled?         ...)
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
(ns my-namespace (:require [dom.api :refer [element-enabled?]]))

(dom.api/element-enabled? ...)
(element-enabled?         ...)
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
(ns my-namespace (:require [dom.api :refer [element-focused?]]))

(dom.api/element-focused? ...)
(element-focused?         ...)
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
(ns my-namespace (:require [dom.api :refer [element-on-viewport-bottom?]]))

(dom.api/element-on-viewport-bottom? ...)
(element-on-viewport-bottom?         ...)
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
(ns my-namespace (:require [dom.api :refer [element-on-viewport-left?]]))

(dom.api/element-on-viewport-left? ...)
(element-on-viewport-left?         ...)
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
(ns my-namespace (:require [dom.api :refer [element-on-viewport-right?]]))

(dom.api/element-on-viewport-right? ...)
(element-on-viewport-right?         ...)
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
(ns my-namespace (:require [dom.api :refer [element-on-viewport-top?]]))

(dom.api/element-on-viewport-top? ...)
(element-on-viewport-top?         ...)
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
  (while (-> element .-firstChild)
         (-> element (.removeChild (-> element .-firstChild))))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [empty-element!]]))

(dom.api/empty-element! ...)
(empty-element!         ...)
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
(ns my-namespace (:require [dom.api :refer [event->node-name]]))

(dom.api/event->node-name ...)
(event->node-name         ...)
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
(ns my-namespace (:require [dom.api :refer [event->value]]))

(dom.api/event->value ...)
(event->value         ...)
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
(file->file-data my-file)
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
(ns my-namespace (:require [dom.api :refer [file->file-data]]))

(dom.api/file->file-data ...)
(file->file-data         ...)
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
  (-> file .-name))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [file->filename]]))

(dom.api/file->filename ...)
(file->filename         ...)
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
  (-> file .-size))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [file->filesize]]))

(dom.api/file->filesize ...)
(file->filesize         ...)
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
(ns my-namespace (:require [dom.api :refer [file->image?]]))

(dom.api/file->image? ...)
(file->image?         ...)
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
  (-> file .-type))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [file->mime-type]]))

(dom.api/file->mime-type ...)
(file->mime-type         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->any-file-selected?]]))

(dom.api/file-selector->any-file-selected? ...)
(file-selector->any-file-selected?         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->file]]))

(dom.api/file-selector->file ...)
(file-selector->file         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->file-count]]))

(dom.api/file-selector->file-count ...)
(file-selector->file-count         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->file-list]]))

(dom.api/file-selector->file-list ...)
(file-selector->file-list         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->files]]))

(dom.api/file-selector->files ...)
(file-selector->files         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->files-data]]))

(dom.api/file-selector->files-data ...)
(file-selector->files-data         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->files-meta]]))

(dom.api/file-selector->files-meta ...)
(file-selector->files-meta         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->files-size]]))

(dom.api/file-selector->files-size ...)
(file-selector->files-size         ...)
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
       (-> form-data)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [file-selector->form-data]]))

(dom.api/file-selector->form-data ...)
(file-selector->form-data         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->image-data-url]]))

(dom.api/file-selector->image-data-url ...)
(file-selector->image-data-url         ...)
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
(ns my-namespace (:require [dom.api :refer [file-selector->mime-types]]))

(dom.api/file-selector->mime-types ...)
(file-selector->mime-types         ...)
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
  (-> element .focus)
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [focus-element!]]))

(dom.api/focus-element! ...)
(focus-element!         ...)
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
  (-> js/document .-activeElement))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-active-element]]))

(dom.api/get-active-element)
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
(ns my-namespace (:require [dom.api :refer [get-body-element]]))

(dom.api/get-body-element)
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
(ns my-namespace (:require [dom.api :refer [get-body-style-value]]))

(dom.api/get-body-style-value ...)
(get-body-style-value         ...)
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
  (-> js/document .-documentElement))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-document-element]]))

(dom.api/get-document-element)
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
(ns my-namespace (:require [dom.api :refer [get-document-height]]))

(dom.api/get-document-height)
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
  (-> js/document .-title str))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-document-title]]))

(dom.api/get-document-title)
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
(ns my-namespace (:require [dom.api :refer [get-document-width]]))

(dom.api/get-document-width)
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
(ns my-namespace (:require [dom.api :refer [get-element-absolute-left]]))

(dom.api/get-element-absolute-left ...)
(get-element-absolute-left         ...)
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
(ns my-namespace (:require [dom.api :refer [get-element-absolute-top]]))

(dom.api/get-element-absolute-top ...)
(get-element-absolute-top         ...)
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
  (-> element (.getAttribute attribute-name)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-attribute]]))

(dom.api/get-element-attribute ...)
(get-element-attribute         ...)
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
  (-> element .getAttributes))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-attributes]]))

(dom.api/get-element-attributes ...)
(get-element-attributes         ...)
```

</details>

---

### get-element-by-attribute

```
@param (DOM-element)(opt) parent-element
Default: js/document
@param (string) attribute-name
@param (string) attribute-value
```

```
@usage
(get-element-by-attribute "my-attribute" "My value")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn get-element-by-attribute
  ([attribute-name attribute-value]                (get-element-by-query                (str "["attribute-name"="attribute-value"]")))
  ([parent-element attribute-name attribute-value] (get-element-by-query parent-element (str "["attribute-name"="attribute-value"]"))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-by-attribute]]))

(dom.api/get-element-by-attribute ...)
(get-element-by-attribute         ...)
```

</details>

---

### get-element-by-class-name

```
@param (DOM-element)(opt) parent-element
Default: js/document
@param (string) class-name
```

```
@usage
(get-element-by-class-name "my-class")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn get-element-by-class-name
  ([class-name]                (-> js/document    (.getElementsByClassName class-name) array-seq vec first))
  ([parent-element class-name] (-> parent-element (.getElementsByClassName class-name) array-seq vec first)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-by-class-name]]))

(dom.api/get-element-by-class-name ...)
(get-element-by-class-name         ...)
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
  ([element-id]                (-> js/document    (.getElementById element-id)))
  ([parent-element element-id] (-> parent-element (.getElementById element-id))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-by-id]]))

(dom.api/get-element-by-id ...)
(get-element-by-id         ...)
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
(ns my-namespace (:require [dom.api :refer [get-element-by-query]]))

(dom.api/get-element-by-query ...)
(get-element-by-query         ...)
```

</details>

---

### get-element-by-tag-name

```
@param (DOM-element)(opt) parent-element
Default: js/document
@param (string) tag-name
```

```
@usage
(get-element-by-class-name "div")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn get-element-by-tag-name
  ([tag-name]                (-> js/document    (.getElementsByTagName tag-name) array-seq vec first))
  ([parent-element tag-name] (-> parent-element (.getElementsByTagName tag-name) array-seq vec first)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-by-tag-name]]))

(dom.api/get-element-by-tag-name ...)
(get-element-by-tag-name         ...)
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
(ns my-namespace (:require [dom.api :refer [get-element-computed-style]]))

(dom.api/get-element-computed-style ...)
(get-element-computed-style         ...)
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
  (-> element .-offsetHeight))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-height]]))

(dom.api/get-element-height ...)
(get-element-height         ...)
```

</details>

---

### get-element-mass-point-orientation

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-mass-point-orientation my-element)
```

```
@return (keyword)
:bl, :br, :tl, :tr
```

<details>
<summary>Source code</summary>

```
(defn get-element-mass-point-orientation
  [element]
  (if (element-on-viewport-bottom? element)
      (if (element-on-viewport-left? element) :bl :br)
      (if (element-on-viewport-left? element) :tl :tr)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-mass-point-orientation]]))

(dom.api/get-element-mass-point-orientation ...)
(get-element-mass-point-orientation         ...)
```

</details>

---

### get-element-mass-point-x

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-mass-point-x my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-mass-point-x
  [element]
  (math/round (+ (-> element     .-offsetWidth (/ 2))
                 (-> element     .getBoundingClientRect .-left)
                 (-> js/document .-documentElement      .-scrollLeft))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-mass-point-x]]))

(dom.api/get-element-mass-point-x ...)
(get-element-mass-point-x         ...)
```

</details>

---

### get-element-mass-point-y

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-mass-point-y my-element)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-element-mass-point-y
  [element]
  (math/round (+ (-> element     .-offsetHeight (/ 2))
                 (-> element     .getBoundingClientRect .-left)
                 (-> js/document .-documentElement      .-scrollTop))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-mass-point-y]]))

(dom.api/get-element-mass-point-y ...)
(get-element-mass-point-y         ...)
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
(ns my-namespace (:require [dom.api :refer [get-element-offset-left]]))

(dom.api/get-element-offset-left ...)
(get-element-offset-left         ...)
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
(ns my-namespace (:require [dom.api :refer [get-element-offset-top]]))

(dom.api/get-element-offset-top ...)
(get-element-offset-top         ...)
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
(ns my-namespace (:require [dom.api :refer [get-element-relative-left]]))

(dom.api/get-element-relative-left ...)
(get-element-relative-left         ...)
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
(ns my-namespace (:require [dom.api :refer [get-element-relative-top]]))

(dom.api/get-element-relative-top ...)
(get-element-relative-top         ...)
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
(ns my-namespace (:require [dom.api :refer [get-element-style]]))

(dom.api/get-element-style ...)
(get-element-style         ...)
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
(ns my-namespace (:require [dom.api :refer [get-element-style-value]]))

(dom.api/get-element-style-value ...)
(get-element-style-value         ...)
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
  (-> element .-offsetWidth))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-element-width]]))

(dom.api/get-element-width ...)
(get-element-width         ...)
```

</details>

---

### get-elements-by-attribute

```
@param (DOM-element)(opt) parent-element
Default: js/document
@param (string) attribute-name
@param (string) attribute-value
```

```
@usage
(get-elements-by-attribute "my-attribute" "My value")
```

```
@return (vector)
```

<details>
<summary>Source code</summary>

```
(defn get-elements-by-attribute
  ([attribute-name attribute-value]                (get-elements-by-query                (str "["attribute-name"="attribute-value"]")))
  ([parent-element attribute-name attribute-value] (get-elements-by-query parent-element (str "["attribute-name"="attribute-value"]"))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-elements-by-attribute]]))

(dom.api/get-elements-by-attribute ...)
(get-elements-by-attribute         ...)
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
(ns my-namespace (:require [dom.api :refer [get-elements-by-class-name]]))

(dom.api/get-elements-by-class-name ...)
(get-elements-by-class-name         ...)
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
(ns my-namespace (:require [dom.api :refer [get-elements-by-query]]))

(dom.api/get-elements-by-query ...)
(get-elements-by-query         ...)
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
(ns my-namespace (:require [dom.api :refer [get-elements-by-tag-name]]))

(dom.api/get-elements-by-tag-name ...)
(get-elements-by-tag-name         ...)
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
(ns my-namespace (:require [dom.api :refer [get-head-element]]))

(dom.api/get-head-element)
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
(ns my-namespace (:require [dom.api :refer [get-mouse-viewport-quarter]]))

(dom.api/get-mouse-viewport-quarter ...)
(get-mouse-viewport-quarter         ...)
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
  (-> mouse-event .-clientX))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-mouse-x]]))

(dom.api/get-mouse-x ...)
(get-mouse-x         ...)
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
  (-> mouse-event .-clientY))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-mouse-y]]))

(dom.api/get-mouse-y ...)
(get-mouse-y         ...)
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
        (-> :ttb)

        (and (scroll-direction-btt? last-scroll-y)
             (math/nonnegative?     last-scroll-y))
        (-> :btt)

        (math/negative? last-scroll-y)
        (-> :btt)

        :return nil))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [get-scroll-direction]]))

(dom.api/get-scroll-direction ...)
(get-scroll-direction         ...)
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
(ns my-namespace (:require [dom.api :refer [get-scroll-progress]]))

(dom.api/get-scroll-progress)
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
(ns my-namespace (:require [dom.api :refer [get-scroll-x]]))

(dom.api/get-scroll-x)
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
(ns my-namespace (:require [dom.api :refer [get-scroll-y]]))

(dom.api/get-scroll-y)
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
(ns my-namespace (:require [dom.api :refer [get-selection-end]]))

(dom.api/get-selection-end ...)
(get-selection-end         ...)
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
(ns my-namespace (:require [dom.api :refer [get-selection-start]]))

(dom.api/get-selection-start ...)
(get-selection-start         ...)
```

</details>

---

### hide-element-animated!

```
@param (DOM-element) element
@param (ms) timeout
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(hide-element-animated! my-element 500)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn hide-element-animated!
  [element timeout]
  (attributes/set-element-attribute! element "data-animation" "hide")
  (letfn [(f [] (style/set-element-style-value!       element "display" "none")
                (attributes/remove-element-attribute! element "data-animation"))]
         (.setTimeout js/window f timeout))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [hide-element-animated!]]))

(dom.api/hide-element-animated! ...)
(hide-element-animated!         ...)
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
  (-> parent-element (.insertBefore child-element (-> before-element .-nextSibling)))
  (-> parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [insert-after!]]))

(dom.api/insert-after! ...)
(insert-after!         ...)
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
  (-> parent-element (.insertBefore child-element (-> parent-element (-> query .querySelectorAll) array-seq first)))
  (-> parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [insert-as-first-of-query-selected!]]))

(dom.api/insert-as-first-of-query-selected! ...)
(insert-as-first-of-query-selected!         ...)
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
       (-> parent-element (.insertBefore child-element (-> parent-element (-> query .querySelectorAll)
                                                           array-seq first))))
  (-> parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [insert-as-first-of-type!]]))

(dom.api/insert-as-first-of-type! ...)
(insert-as-first-of-type!         ...)
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
  (-> parent-element (.insertBefore child-element (-> parent-element (-> query .querySelectorAll) array-seq last .-nextSibling)))
  (-> parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [insert-as-last-of-query-selected!]]))

(dom.api/insert-as-last-of-query-selected! ...)
(insert-as-last-of-query-selected!         ...)
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
       (-> parent-element (.insertBefore child-element (-> parent-element (.querySelectorAll query)
                                                           array-seq last .-nextSibling))))
  (-> parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [insert-as-last-of-type!]]))

(dom.api/insert-as-last-of-type! ...)
(insert-as-last-of-type!         ...)
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
  (-> parent-element (.insertBefore child-element after-element))
  (-> parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [insert-before!]]))

(dom.api/insert-before! ...)
(insert-before!         ...)
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
(ns my-namespace (:require [dom.api :refer [intersection-observer]]))

(dom.api/intersection-observer ...)
(intersection-observer         ...)
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
  (-> form-data))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [merge-to-form-data!]]))

(dom.api/merge-to-form-data! ...)
(merge-to-form-data!         ...)
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
       (-> element (set-selection-range! length length)))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [move-caret-to-end!]]))

(dom.api/move-caret-to-end! ...)
(move-caret-to-end!         ...)
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
  (-> element (set-selection-range! 0 0))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [move-caret-to-start!]]))

(dom.api/move-caret-to-start! ...)
(move-caret-to-start!         ...)
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
(ns my-namespace (:require [dom.api :refer [on-mouse-left]]))

(dom.api/on-mouse-left ...)
(on-mouse-left         ...)
```

</details>

---

### parse-html

```
@param (string) n
```

```
@usage
(parse-html "<div>My element</div>")
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn parse-html
  [n]
  (let [wrapper (.createElement js/document "div")]
       (-> wrapper .-innerHTML (set! n))
       (-> wrapper .-firstChild)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [parse-html]]))

(dom.api/parse-html ...)
(parse-html         ...)
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
  (-> parent-element (.insertBefore child-element (.-firstChild parent-element)))
  (-> parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [prepend-element!]]))

(dom.api/prepend-element! ...)
(prepend-element!         ...)
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
  (-> event .preventDefault))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [prevent-default!]]))

(dom.api/prevent-default! ...)
(prevent-default!         ...)
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
  (-> parent-element (.removeChild child-element))
  (-> parent-element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [remove-child!]]))

(dom.api/remove-child! ...)
(remove-child!         ...)
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
  (-> element .remove))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [remove-element!]]))

(dom.api/remove-element! ...)
(remove-element!         ...)
```

</details>

---

### remove-element-animated!

```
@param (DOM-element) element
@param (ms) timeout
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-animated! my-element 500)
```

<details>
<summary>Source code</summary>

```
(defn remove-element-animated!
  [element timeout]
  (attributes/set-element-attribute! element "data-animation" "hide")
  (letfn [(f [] (node/remove-element! element))]
         (.setTimeout js/window f timeout)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [remove-element-animated!]]))

(dom.api/remove-element-animated! ...)
(remove-element-animated!         ...)
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
  (-> element (.removeAttribute attribute-name))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [remove-element-attribute!]]))

(dom.api/remove-element-attribute! ...)
(remove-element-attribute!         ...)
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
  (-> element .removeAttributes)
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [remove-element-attributes!]]))

(dom.api/remove-element-attributes! ...)
(remove-element-attributes!         ...)
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
  (-> element .-classList (.remove class-name))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [remove-element-class!]]))

(dom.api/remove-element-class! ...)
(remove-element-class!         ...)
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
  (-> element (.removeAttribute "style"))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [remove-element-style!]]))

(dom.api/remove-element-style! ...)
(remove-element-style!         ...)
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
  (-> element .-style (aset style-name nil))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [remove-element-style-value!]]))

(dom.api/remove-element-style-value! ...)
(remove-element-style-value!         ...)
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
  (-> observer (.unobserve element))
  (-> observer))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [remove-intersection-observer!]]))

(dom.api/remove-intersection-observer! ...)
(remove-intersection-observer!         ...)
```

</details>

---

### reveal-element-animated!

```
@param (DOM-element) element
@param (ms) timeout
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(reveal-element-animated! my-element 500)
```

```
@return (DOM-element)
```

<details>
<summary>Source code</summary>

```
(defn reveal-element-animated!
  [element timeout]
  (style/set-element-style-value!    element "display"        "block")
  (attributes/set-element-attribute! element "data-animation" "reveal")
  (letfn [(f [] (attributes/remove-element-attribute! element "data-animation"))]
         (.setTimeout js/window f timeout))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [reveal-element-animated!]]))

(dom.api/reveal-element-animated! ...)
(reveal-element-animated!         ...)
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
(ns my-namespace (:require [dom.api :refer [scroll-direction-btt?]]))

(dom.api/scroll-direction-btt? ...)
(scroll-direction-btt?         ...)
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
(ns my-namespace (:require [dom.api :refer [scroll-direction-ttb?]]))

(dom.api/scroll-direction-ttb? ...)
(scroll-direction-ttb?         ...)
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
(ns my-namespace (:require [dom.api :refer [scroll-to-element-top!]]))

(dom.api/scroll-to-element-top! ...)
(scroll-to-element-top!         ...)
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
(ns my-namespace (:require [dom.api :refer [select-preventer]]))

(dom.api/select-preventer ...)
(select-preventer         ...)
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
  (-> element (set-selection-start! caret-position))
  (-> element (set-selection-end!   caret-position))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-caret-position!]]))

(dom.api/set-caret-position! ...)
(set-caret-position!         ...)
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
  (-> title))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-document-title!]]))

(dom.api/set-document-title! ...)
(set-document-title!         ...)
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
  (-> element (.setAttribute attribute-name attribute-value))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-element-attribute!]]))

(dom.api/set-element-attribute! ...)
(set-element-attribute!         ...)
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
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-element-attributes!]]))

(dom.api/set-element-attributes! ...)
(set-element-attributes!         ...)
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
  (-> element .-classList (.add class-name))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-element-class!]]))

(dom.api/set-element-class! ...)
(set-element-class!         ...)
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
  (-> element .-innerHTML (set! content))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-element-content!]]))

(dom.api/set-element-content! ...)
(set-element-content!         ...)
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
  (-> element .-id (set! element-id))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-element-id!]]))

(dom.api/set-element-id! ...)
(set-element-id!         ...)
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
       (-> element (.setAttribute "style" parsed-style)))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-element-style!]]))

(dom.api/set-element-style! ...)
(set-element-style!         ...)
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
  (-> element .-style (aset style-name style-value))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-element-style-value!]]))

(dom.api/set-element-style-value! ...)
(set-element-style-value!         ...)
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
(ns my-namespace (:require [dom.api :refer [set-scroll-x!]]))

(dom.api/set-scroll-x! ...)
(set-scroll-x!         ...)
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
(ns my-namespace (:require [dom.api :refer [set-scroll-y!]]))

(dom.api/set-scroll-y! ...)
(set-scroll-y!         ...)
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
  (-> element .-selectionEnd (set! selection-end))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-selection-end!]]))

(dom.api/set-selection-end! ...)
(set-selection-end!         ...)
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
  (->                   element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-selection-range!]]))

(dom.api/set-selection-range! ...)
(set-selection-range!         ...)
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
  (-> element .-selectionStart (set! selection-start))
  (-> element))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [set-selection-start!]]))

(dom.api/set-selection-start! ...)
(set-selection-start!         ...)
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
       (-> observer (.observe element))
       (-> observer)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [setup-intersection-observer!]]))

(dom.api/setup-intersection-observer! ...)
(setup-intersection-observer!         ...)
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
  (-> event .stopPropagation))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [dom.api :refer [stop-propagation!]]))

(dom.api/stop-propagation! ...)
(stop-propagation!         ...)
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
(ns my-namespace (:require [dom.api :refer [toggle-design-mode!]]))

(dom.api/toggle-design-mode!)
(toggle-design-mode!)
```

</details>

---

This documentation is generated with the [clj-docs-generator](https://github.com/bithandshake/clj-docs-generator) engine.


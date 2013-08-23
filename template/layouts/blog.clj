; @layout default
; @title Blog
; @isblog true

; // FUNCTIONS

;(defn render-tag [{:keys [url name]}]
; [:a {:href url} name])

(defn trim [post-file]
  (misaki.compiler.default.core/file->template-sexp post-file :allow-layout? false))

(defn preview-post [{:keys [url title tag date file]}]
  [:div {:class "post"}
   (post-header :h1 title url)
   (take 6 (trim file))
   [:p {:class "topmargin"} (link "[more...]" url)]])

(defn preview-posts [site]
  (map preview-post (take 5 (:posts site))))
;  (drop-last (interleave (map preview-post (take 5 (:posts site))) (repeat [:hr])))) ; old version w/ HR

; // TEMPLATES

    contents

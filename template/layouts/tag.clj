; @layout  default
; @title   tag default title

[:article
 ; page header
 [:div {:class "post"}
  (h1 (:tag-name site))

  (ul #(link (:title %) (:url %))
     (:posts site))]]


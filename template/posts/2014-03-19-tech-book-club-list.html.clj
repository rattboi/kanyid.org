; @layout post
; @title  Tech Book Club List
; @tag    personal

(defn been-read [book]
 [:span {:style "text-decoration: line-through"} book])

(defn book [title]
  (list title " " (link "Amazon" (str "http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords=" title))))

(p "Over the summer, some friends and I are planning on reading some computer texts that are considered required reading. I'll be adding to the post as we come up with other interesting books.")

(ul (list (book "Structure and Interpretation of Computer Programs")
          (book "The Art of UNIX Programming")
          (book "Gödel, Escher, Bach: An Eternal Golden Braid")))

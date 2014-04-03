; @layout post
; @title  Tech Book Club List
; @tag    personal

(defn been-read [book]
 [:span {:style "text-decoration: line-through"} book])

(defn book [title author url]
  (list (link title url) ", by " author))

(p "Over the summer, some friends and I are planning on reading some computer texts that are considered required reading. I'll be adding to the post as we come up with other interesting books.")

(ul (list (book "Structure and Interpretation of Computer Programs"
                "Harold Abelson and Gerald JaySussman with Julie Sussman"
                "http://mitpress.mit.edu/sicp/")
          (book "The Art of UNIX Programming"
                "Eric S. Raymond"
                "http://www.catb.org/~esr/writings/taoup/")
          (book "Gödel, Escher, Bach: An Eternal Golden Braid"
                "Douglas R. Hofstadter"
                "http://www.amazon.com/dp/0465026567")
))

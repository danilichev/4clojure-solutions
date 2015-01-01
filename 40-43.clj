;; #40 - Interpose a Seq
;; Write a function which separates the items of a sequence
;; by an arbitrary value.
;; !!! Special Restrictions - interpose
;; (= (__ 0 [1 2 3]) [1 0 2 0 3])
;; (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
;; (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

#(take (- (* 2 (count %2)) 1) (mapcat (fn [x] (list x %1)) %2))

;; more shorter solution from user with nick daowen:

#(next (interleave (repeat %) %2))



;; #41 - Drop Every Nth Item
;; Write a function which drops every Nth item from a sequence.
;; (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
;; (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
;; (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])

#(mapcat drop-last (partition-all %2 (conj %1 %2)))



;; #42 - Factorial Fun
;; Write a function which calculates factorials.
;; (= (__ 1) 1)
;; (= (__ 3) 6)
;; (= (__ 5) 120)
;; (= (__ 8) 40320)

(fn fact [x]
  (if (= x 1)
    1
    (* x (fact (- x 1)))))



;; #43 - Reverse Interleave
;; Write a function which reverses the interleave process into x number
;; of subsequences.
;; (= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
;; (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
;; (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

#(partition (/ (count %) %2) (apply interleave (partition %2 %)))

;; solution from user with nick 0trey:

#(apply map list (partition %2 %))



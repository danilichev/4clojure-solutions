;; #30 - Compress a Sequence
;; Write a function which removes consecutive duplicates from a sequence.
;; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
;; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

#(let [coll (atom '())]
    (doseq [i %]
      (if (not= i (first @coll))
        (swap! coll conj i)))
    (reverse @coll))

;; more elegant solution
;; (from https://clojuredocs.org/clojure.core/identity):

#(map first (partition-by identity %))



;; #31 - Pack a Sequence
;; Write a function which packs consecutive duplicates into sub-lists.
;; (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
;; (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
;; (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

#(partition-by list %)



;; #32 - Duplicate a Sequence
;; Write a function which duplicates each element of a sequence.
;; (= (__ [1 2 3]) '(1 1 2 2 3 3))
;; (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
;; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
;; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

#(mapcat (fn [x] (list x x)) %)

;; more simply way is to use interleave function



;; #33 - Replicate a Sequence
;; Write a function which replicates each element of a sequence
;; a variable number of times.
;; (= (__ [1 2 3] 2) '(1 1 2 2 3 3))
;; (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
;; (= (__ [4 5 6] 1) '(4 5 6))
;; (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
;; (= (__ [44 33] 2) [44 44 33 33])

#(mapcat (fn [x] (take %2 (repeat x))) %1)



;; #34 - Implement range
;; Write a function which creates a list of all integers in a given range.
;; !!! Special Restrictions - range
;; (= (__ 1 4) '(1 2 3))
;; (= (__ -2 2) '(-2 -1 0 1))
;; (= (__ 5 8) '(5 6 7))

(fn [x y]
  (loop [coll (list x)]
    (if (= (first coll) y)
      (reverse (rest coll))
      (recur (conj coll (inc (first coll)))))))

;; after a few minutes of reading documentation

#(take (- %2 %1) (iterate inc %1))




;; #50 - Split by Type
;;
;; Write a function which takes a sequence consisting of items with
;; different types and splits them up into a set of homogeneous
;; sub-sequences. The internal order of each sub-sequence should be
;; maintained, but the sub-sequences themselves can be returned in
;; any order (this is why 'set' is used in the test cases).
;;
;; (= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
;; (= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
;; (= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})

#(filter (fn [coll] (not (empty? coll)))
         (list (filter number? %)
               (filter keyword? %)
               (filter string? %)
               (filter vector? %)))

;; it is possible to solve more easily with using group-by funcion



;; #51 - Advanced Destructuring
;;
;; Here is an example of some more sophisticated destructuring.
;;
;; (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))

[1 2 3 4 5]



;; #52 - Intro to Destructuring
;;
;; Let bindings and function parameter lists support destructuring.
;;
;; (= [2 4] (let [[a b c d e f g] (range)] __))

[c e]

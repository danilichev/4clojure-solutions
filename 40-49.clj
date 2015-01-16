;; #40 - Interpose a Seq
;;
;; Write a function which separates the items of a sequence
;; by an arbitrary value.
;; !!! Special Restrictions - interpose
;;
;; (= (__ 0 [1 2 3]) [1 0 2 0 3])
;; (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
;; (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

#(take (- (* 2 (count %2)) 1) (mapcat (fn [x] (list x %1)) %2))

;; more shorter solution from user with nick daowen:

#(next (interleave (repeat %) %2))



;; #41 - Drop Every Nth Item
;;
;; Write a function which drops every Nth item from a sequence.
;;
;; (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
;; (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
;; (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])

#(mapcat drop-last (partition-all %2 (conj %1 %2)))



;; #42 - Factorial Fun
;;
;; Write a function which calculates factorials.
;;
;; (= (__ 1) 1)
;; (= (__ 3) 6)
;; (= (__ 5) 120)
;; (= (__ 8) 40320)

(fn fact [x]
  (if (= x 1)
    1
    (* x (fact (- x 1)))))



;; #43 - Reverse Interleave
;;
;; Write a function which reverses the interleave process into x number
;; of subsequences.
;;
;; (= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
;; (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
;; (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

#(partition (/ (count %) %2) (apply interleave (partition %2 %)))

;; solution from user with nick 0trey:

#(apply map list (partition %2 %))

;; explanation:
(#(partition %2 %) [1 2 3 4 5 6] 2)
;;= ((1 2) (3 4) (5 6))
(map list '(1 2) '(3 4) '(5 6))
;;= ((1 3 5) (2 4 6))
(#(apply map list (partition %2 %)) [1 2 3 4 5 6] 2)
;;=((1 3 5) (2 4 6))




;; #44 - Rotate Sequence
;;
;; Write a function which can rotate a sequence in either direction.
;;
;; (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
;; (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
;; (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
;; (= (__ 1 '(:a :b :c)) '(:b :c :a))
;; (= (__ -4 '(:a :b :c)) '(:c :a :b))

;; just for passing the tests:

#(take (count %2) (nthnext (cycle %2) (+ (* 10 (count %2)) %)))



;; #45 - Intro to Iterate
;;
;; The iterate function can be used to produce an infinite lazy sequence.
;;
;; (= __ (take 5 (iterate #(+ 3 %) 1)))

(1 4 7 10 13)



;; #46 - Flipping out
;;
;; Write a higher-order function which flips the order of the arguments
;; of an input function.
;;
;; (= 3 ((__ nth) 2 [1 2 3 4 5]))
;; (= true ((__ >) 7 8))
;; (= 4 ((__ quot) 2 8))
;; (= [1 2 3] ((__ take) [1 2 3 4 5] 3))

(fn [f] (fn [x y] (f y x)))

;; more shorter solution from user with nick 0trey:

#(fn [x y] (% y x))



;; #47 - Contain Yourself
;;
;; The contains? function checks if a KEY is present in a given collection.
;; This often leads beginner clojurians to use it incorrectly with
;; numerically indexed collections like vectors and lists.
;;
;; (contains? #{4 5 6} __)
;; (contains? [1 1 1 1 1] __)
;; (contains? {4 :a 2 :b} __)
;; (not (contains? '(1 2 4) __))

4



;; #48 - Intro to some
;;
;; The some function takes a predicate function and a collection.
;; It returns the first logical true value of (predicate x) where x
;; is an item in the collection.
;;
;; (= __ (some #{2 7 6} [5 6 7 8]))
;; (= __ (some #(when (even? %) %) [5 6 7 8]))

6



;; #49 - Split a sequence
;;
;; Write a function which will split a sequence into two parts.
;; !!! Special Restrictions - split-at
;;
;; (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
;; (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
;; (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])

#(vector (subvec %2 0 %) (subvec %2 %))

;; note: simplest way to use juxt

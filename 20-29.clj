;; #20
;; Write a function which returns the second to last element from a sequence.
;; (= (__ (list 1 2 3 4 5)) 4)

#(nth % (- (count %) 2))



;; #21
;; Write a function which returns the Nth element from a sequence. !!!(Special Restrictions - nth)
;; (= (__ '(4 5 6 7) 2) 6)

#(last (take (inc %2) %1))

;; other simplest solution:

#((vec %1) %2)



;; #22
;; Write a function which returns the total number of elements in a sequence. !!!(Special Restrictions - count)
;; (= (__ '(1 2 3 3 1)) 5)

#(apply + (map (fn [x] 1) %))



;; #23
;; Write a function which reverses a sequence. !!!(Special Restrictions - reverse, rseq)
;; (= (__ [1 2 3 4 5]) [5 4 3 2 1])

#(into () %)

(= (#(into () %) [1 2 3 4 5]) [5 4 3 2 1])



;; #24
;; Write a function which returns the sum of a sequence of numbers.
;; (= (__ [1 2 3]) 6)

#(apply + %)



;; #25
;; Write a function which returns only the odd numbers from a sequence
;; (= (__ #{1 2 3 4 5}) '(1 3 5))

#(filter (fn [x] (not= (mod x 2) 0)) %)



;; #26
;; Write a function which returns the first X fibonacci numbers.
;; (= (__ 3) '(1 1 2))
;; (= (__ 6) '(1 1 2 3 5 8))
;; (= (__ 8) '(1 1 2 3 5 8 13 21))

#(map (fn fib [x] (if (or (= x 0) (= x 1)) 1 (+ (fib (- x 1)) (fib (- x 2))))) (take % (iterate inc 0)))

;; where function for finding Fibonacci number:

(fn fib [x]
  (if (or (= x 0) (= x 1))
    1
    (+ (fib (- x 1)) (fib (- x 2)))))

;; simplest way from user alex_makurin:

#(take %1 (map first (rest (iterate (fn [[a b]] [b (+ a b)]) [0 1]))))



;; #27
;; Write a function which returns true if the given sequence is a palindrome.
;; Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
;; (false? (__ '(1 2 3 4 5)))
;; (true? (__ "racecar"))
;; (true? (__ [:foo :bar :foo]))
;; (true? (__ '(1 1 3 3 1 1)))
;; (false? (__ '(:a :b :c)))

#(= (vec (into () %)) (vec %))

;; or

#(= (vec (reverse %)) (vec %))



;; #28
;; Write a function which flattens a sequence. !!!(Special Restrictions - flatten)
;; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
;; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
;; (= (__ '((((:a))))) '(:a))

#(let [coll (atom '())]
   ((fn put-in-coll [x]
      (if (sequential? x)
        (doseq [i x] (put-in-coll i))
        (swap! coll conj x))) %)
    (reverse @coll))



;; #29
;; Write a function which takes a string and returns a new string containing only the capital letters.
;; (= (__ "HeLlO, WoRlD!") "HLOWRD")
;; (empty? (__ "nothing"))
;; (= (__ "$#A(*&987Zf") "AZ")

#(clojure.string/replace % #"[^A-Z]" "")

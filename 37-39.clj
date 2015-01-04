;; #37 - Regular Expressions
;; Regex patterns are supported with a special reader macro.
;; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

"ABC"



;; #38 - Maximum value
;; Write a function which takes a variable number of parameters
;; and returns the maximum value.
;; !!! Special Restrictions - max, max-key
;; (= (__ 1 8 3 4) 8)
;; (= (__ 30 20) 30)
;; (= (__ 45 67 11) 67)

(fn [& args] (last (sort args)))

;; more shorter solution from user with nick 0trey:

#(last (sort %&))



;; #39 - Interleave Two Seqs
;; Write a function which takes two sequences and returns the first item
;; from each, then the second item from each, then the third, etc.
;; !!! Special Restrictions - interleave
;; (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
;; (= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
;; (= (__ [1 2 3 4] [5]) [1 5])
;; (= (__ [30 20] [25 15]) [30 25 20 15])

#(mapcat list %1 %2)

;; or just:

mapcat list




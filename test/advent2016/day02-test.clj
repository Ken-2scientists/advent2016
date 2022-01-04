(ns advent2016.day02-test
  (:require [clojure.test :refer [deftest testing is]]
            [advent2016.day02 :as t]))

(def day02-sample
  ["ULL"
   "RRDDD"
   "LURDL"
   "UUUUD"])

(deftest bathroom-code
  (testing "Computes the bathroom code on a square 9-digit keypad"
    (is (= "1985" (t/bathroom-code day02-sample)))))

(deftest day02-part1-soln
  (testing "Reproduces the answer for day02, part1"
    (is (= "18843" (t/day02-part1-soln)))))

;; (deftest day02-part2-soln
;;   (testing "Reproduces the answer for day02, part2"
;;     (is (= 116 (t/day02-part2-soln)))))
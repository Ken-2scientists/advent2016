(ns advent2016.day02
  (:require [advent-utils.core :as u]))

(def day02-sample
  ["ULL"
   "RRDDD"
   "LURDL"
   "UUUUD"])

(def day02-input (u/puzzle-input "day02-input.txt"))

(def pos->number
  {[-1 -1] 1  [0 -1] 2  [1 -1] 3
   [-1  0] 4  [0  0] 5  [1  0] 6
   [-1  1] 7  [0  1] 8  [1  1] 9})

(defn step
  [[x y] cmd]
  (case cmd
    \U (if (= -1 y) [x y] [x (dec y)])
    \D (if (= 1 y)  [x y] [x (inc y)])
    \R (if (= 1 x)  [x y] [(inc x) y])
    \L (if (= -1 x) [x y] [(dec x) y])))

(defn move-digit
  [start cmds]
  (reduce step start cmds))

(defn all-digits
  [cmds]
  (reductions move-digit [0 0] cmds))

(defn bathroom-code
  [cmds]
  (->> cmds all-digits rest (map pos->number) (apply str)))

(defn day02-part1-soln
  []
  (bathroom-code day02-input))

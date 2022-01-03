(ns advent2016.day01
  (:require [clojure.string :as str]
            [advent-utils.core :as u]
            [advent-utils.math :as math]))

(defn parse-cmd
  [cmd]
  (let [dir  (subs cmd 0 1)
        dist (read-string (subs cmd 1))]
    {:dir dir :dist dist}))

(defn parse
  [line]
  (map parse-cmd (str/split line #", ")))

(def day01-input (-> (u/puzzle-input "day01-input.txt") first parse))

(defn rotate
  [heading dir]
  (let [rmap {:north :east :east :south :south :west :west :north}
        lmap {:north :west :west :south :south :east :east :north}]
    (case dir
      "R" (rmap heading)
      "L" (lmap heading))))

(defn step
  [{:keys [pos heading]} {:keys [dir dist]}]
  (let [new-heading (rotate heading dir)]
    {:heading new-heading
     :pos (case new-heading
            :north (update pos 1 + dist)
            :south (update pos 1 - dist)
            :east  (update pos 0 + dist)
            :west  (update pos 0 - dist))}))

(defn move
  [steps]
  (reduce step {:pos [0 0] :heading :north} steps))

(defn distance
  [steps]
  (-> steps move :pos (math/manhattan [0 0])))

(defn day01-part1-soln
  []
  (distance day01-input))
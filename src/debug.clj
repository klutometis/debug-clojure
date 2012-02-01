(ns debug
  (:use [clojure.pprint :only (pprint)]))

(defmacro debug-map
  "Map quoted expressions to their values."
  [& exprs]
  `(zipmap (reverse (list ~@(map (fn [expr] `'~expr) exprs)))
           (reverse (list ~@(map (fn [expr] expr) exprs)))))

(defmacro debug-list
  "List-associate expressions with their values."
  [& exprs]
  `(list ~@(map (fn [expr] `(list '~expr ~expr)) exprs)))

(defmacro debug [& exprs]
  "Pretty-print expression-value associations."
  `(pprint (debug-map ~@exprs)))

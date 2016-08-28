
(ns jane.schema)

(def user {:name nil, :nickname nil, :id nil})

(def database
 {:states {}, :teams {}, :topics {}, :messages {}, :users {}})

(def state
 {:router {:name :home, :params nil, :data nil},
  :nickname nil,
  :user-id nil,
  :notifications [],
  :id nil})

(def team {:name nil, :time nil, :id nil, :members (hash-set)})

(def topic {:name nil, :time nil, :id nil, :members (hash-set)})

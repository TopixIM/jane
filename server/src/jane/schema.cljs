
(ns jane.schema)

(def user {:name nil, :nickname nil, :id nil})

(def database
 {:states {}, :teams {}, :messages {}, :groups {}, :users {}})

(def state
 {:router {:name :home, :data nil},
  :nickname nil,
  :user-id nil,
  :notifications [],
  :id nil})

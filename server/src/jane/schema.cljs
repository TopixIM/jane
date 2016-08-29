
(ns jane.schema)

(def message
 {:time nil, :id nil, :topic-id nil, :author-id nil, :text nil})

(def user {:name nil, :nickname nil, :id nil})

(def database {:states {}, :teams {}, :users {}})

(def state
 {:router {:name :home, :params nil, :data nil},
  :nickname nil,
  :user-id nil,
  :notifications [],
  :id nil})

(def team
 {:name nil, :time nil, :topics {}, :id nil, :members (hash-set)})

(def topic
 {:team-id nil,
  :name nil,
  :time nil,
  :messages {},
  :id nil,
  :members (hash-set)})

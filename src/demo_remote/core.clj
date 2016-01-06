(ns demo-remote.core
  (:require [immutant.messaging :as msg]
            [immutant.util :as util])
  (:gen-class))

(defn get-context []
  (when-not (util/in-container?)
    (msg/context :host "localhost")))

(defn respond [qname callback]
  (with-open [ctx (get-context)]
    (msg/respond (msg/queue qname :context ctx) callback)))

(defn -main
  [& args]
  nil)

(ns demo-remote.core
  (:require [immutant.messaging :as msg]
            [immutant.util :as util])
  (:gen-class))

(defn respond [qname callback]
  (if (util/in-container?)
    (msg/respond (msg/queue qname) callback)
    (with-open [ctx (msg/context :host "localhost" :port 5445)]
      (msg/respond (msg/queue qname :context ctx) callback))))

(defn -main
  [& args]
  nil)

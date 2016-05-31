(ns simple-web-service.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.page :refer [html5 include-js]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojure.java.io :as io]))

(defroutes app-routes
           (GET "/" [] "Which superhero are you?")
           (route/resources "/")
           (GET "/superhero" [] (html5
                                  [:head
                                   [:title "Which Superhero are you?"]
                                   ]
                                  [:body
                                   [:h1 "Which Superhero are you?"]
                                   [:button {:id "generate-superhero"} "Tell me now!"]
                                   [:div {:id "superhero-content"}]
                                   (include-js "/js/main.js")]))
           (GET "/randomsuperhero" [] (do (print "Here") (first (file-seq (io/file "/Users/lucyfang/simple-web-service/resources/public")))))
           (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))


Fix for retrieving image file names
(->> (file-seq (file "/Users/lucyfang/simple-web-service/resources/public"))
     #_=> (map (fn [file] (.getName file)))
     #_=> (filter (fn [name] (.endsWith name ".jpg"))))
("deadpool.jpg" "kickass.jpg" "spiderman.jpg")

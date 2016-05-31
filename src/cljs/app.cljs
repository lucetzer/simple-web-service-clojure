(ns app)

(defn on-click [] (js/alert "Hello!"))

(set! (.-onclick (.getElementById js/document "generate-superhero"))
      (fn [] (set! (.-innerHTML (.getElementById js/document "superhero-content")) "<img src='/deadpool.jpg' />")))
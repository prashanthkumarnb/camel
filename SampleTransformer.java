package com.example.camel;

import java.util.HashMap;
import java.util.Map;

public class SampleTransformer {

        private final Map<String, String> messagesDictionary = new HashMap<>();

        public SampleTransformer() {
            messagesDictionary.put("L", "London");
            messagesDictionary.put("S", "Slough");
            messagesDictionary.put("B", "Birmingham");
        }

        public String transform(String key){
            if (!messagesDictionary.containsKey(key)){
                throw new IllegalArgumentException("Unknown key " + key);
            }
            return messagesDictionary.get(key);
        }
}

package com.marcussinclair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFirstNonRepeatingChar(String str) {
        // a green apple
        // {'a'=2, 'g'=1, 'r'=1 ...}

        Map<Character, Integer> map = new HashMap<>();

        for ( char ch : str.toCharArray()) {
            var count = map.containsKey(ch)? map.get(ch) : 0;
            map.put(ch, count + 1);
        }
        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }
    public char findFirstRepeatingChar(String str) {
        Set<Character> set = new HashSet<>();
        for ( char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            }
            else {
                set.add(ch);
            }
        }

        return Character.MIN_VALUE;
    }
}

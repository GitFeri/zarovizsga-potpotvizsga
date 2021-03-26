package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.*;

public class UniqueFinder {
    public List<Character> uniqueChars(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Parameter is null!");
        }

        Set<Character> characterSet = new HashSet<>();
        List<Character> result = new ArrayList<>();
        for (int i=0; i < str.length(); i++) {
            char ch = str.charAt(i);
          if (!characterSet.contains(ch)) {
              characterSet.add(ch);
              result.add(ch);
            }
        }
        return result;
    }
}

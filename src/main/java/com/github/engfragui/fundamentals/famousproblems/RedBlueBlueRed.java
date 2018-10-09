package com.github.engfragui.fundamentals.famousproblems;

import java.util.HashMap;

/**
 * Problem: You're given a pattern and an input string.
 * Return true if the input string matches the given pattern.
 * Example: pattern "abba", string "redbluebluered" should return true.
 *
 * Approach: Brute force, backtracking.
 *
 * More details:
 * Match the first letter of the pattern with the first letter of the string.
 * Take the remaining pattern and the remaining of the input string and:
 *  - If the next character in the pattern is not in the hash map yet, recurse the same (first character in pattern with first letter of string)
 *  - If it is, check if the value we assigned to that character works well with the remaing part of the input string.
 */
public class RedBlueBlueRed {

  public static boolean matchesPattern(String pattern, String input) {
    HashMap<Character, String> map = new HashMap<>();
    return matchesPattern(pattern, 0, input, 0, map);
  }

  public static boolean matchesPattern(String pattern, int patternIndex, String input, int inputStartIndex, HashMap<Character, String> map) {

    // if we're at the end of the pattern AND at the end of the input string
    if (patternIndex == pattern.length() && inputStartIndex == input.length()) {
      return true;
    }

    // if we're at the end of the pattern but not at the end of the input string (or viceversa)
    if (patternIndex == pattern.length() || inputStartIndex == input.length()) {
      return false;
    }

    for (int i=patternIndex; i<pattern.length(); i++) {

      // take character from pattern
      Character c = pattern.charAt(i);

      // if character was already assigned to a part of the input string
      if (map.containsKey(c)) {
        String value = map.get(c);

        // if the value we already assigned to this character works with the remain of the input string
        if (inputStartIndex + value.length() <= input.length()
            && value.equals(input.substring(inputStartIndex, inputStartIndex + value.length()))) {

          // continue with the check
          return matchesPattern(pattern, patternIndex + 1, input, inputStartIndex + value.length(), map);

        } else {
          // the assignment of the character to the part of the input string didn't work, this is not a good solution
          return false;
        }

      } else {

        for (int j = 1; j < (input.length() - inputStartIndex + 1); j++) {

          // 1. PICK
          // assign character from pattern to one or more letter of the input string
          String inputSubstring = input.substring(inputStartIndex, inputStartIndex + j);
          // assign character to inputSubstring
          map.put(c, inputSubstring);

          // 2. EXPLORE
          // see where I get if I make this assignment
          boolean result = matchesPattern(pattern, patternIndex + 1, input, inputStartIndex + inputSubstring.length(), map);
          if (result) {
            return true;
          }

          // 3. UNPICK
          // undo choice of assigning pattern character to inputSubstring
          map.remove(c);
        }
      }
    }

    // if I have not returned until now, it means that there's no solution
    return false;
  }

  public static void main(String[] args) throws Exception {
    System.out.println(matchesPattern("abba", "redbluebluered"));
  }
}
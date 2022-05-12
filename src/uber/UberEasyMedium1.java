package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of strings string_list and a list of words words, determine whether each word in words
 * can be formed as a concatenation of consecutive strings in string_list starting with index 0.
 * ex. word = "oneTwoThree", string_list = ["one", "Three", "Two"] is false because the words aren't consecutive in string_list
 * ex. word = "one", string_list = ["one", "Three", "Two"] is True because the concatenation stops at the first index in string_list
 * ex. word = "one", string_list = ["One", "one", "Two"] is False because the concatenation doesn't start at 0.
 * Just use the base idea from the LeetCode problem and then modify it for the consecutive concatenation requirement.
 * It's actually easier than the LeetCode problem.
 */
public class UberEasyMedium1 {
    static class UberEasyMedium1Solution {
        public boolean solution(String word, List<String> list1) {
            ArrayList<String> list = new ArrayList<>(list1);
            while(!word.isEmpty()) {
                if(list.isEmpty()) return false;
                String w = list.remove(0);
                if(!word.startsWith(w)) return false;
                while(word.startsWith(w)) {
                    word = word.substring(w.length());
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        UberEasyMedium1Solution uberEasyMedium1Solution = new UberEasyMedium1Solution();
        uberEasyMedium1Solution.solution("one", Arrays.asList("one", "Three", "Two"));
    }
}

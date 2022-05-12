import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        lengthOfLongestSubstring("abba");
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int longestSubString = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(charMap.containsKey(current)) {
                left = Math.max(left,charMap.get(current) + 1);
            }
            charMap.put(current, i);
            longestSubString = Math.max(longestSubString, i - left + 1);
        }
        return longestSubString;
    }
}

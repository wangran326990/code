import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            charCount.put(t.charAt(i), charCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        String result = s;
        int count = 0;
        for(int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if(charCount.containsKey(current)) {
                charCount.put(current,charCount.get(current) - 1);
                if(charCount.get(current) >= 0) {
                    count++;
                }
            }

            while(count == t.length()) {
                if(right-left+1 < minLen){
                    minLeft = left;
                    minLen = right-left+1;
                }
                char currentLeft = s.charAt(left);
                if(charCount.containsKey(currentLeft)) {
                    charCount.put(currentLeft, charCount.get(currentLeft) + 1);
                    if(charCount.get(currentLeft) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }

        if(minLen>s.length())
        {
            return "";
        }

        return s.substring(minLeft,minLeft+minLen);
    }
}

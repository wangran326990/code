package uber;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class UberEasy3 {
    /**
     *Given a string s, return the longest and lexicographically smallest palindromic string that can be formed from the characters.
     * ex. "abbaa" -> "abba"
     * ex. "adeadeadevue" -> "adeeaeeda"
     */
    static class UberEasy3Solution {
        public String solution(String input){
            TreeMap<Character, Integer> inputFreq = new TreeMap<>((ch1, ch2)-> {
                return ch2 - ch1;
            });
            char[] inputCharArr = input.toCharArray();
            for(int i = 0; i < inputCharArr.length; i++) {
                inputFreq.put(inputCharArr[i] ,inputFreq.getOrDefault(inputCharArr[i],0) +1);
            }
            String result = "";
            for(Map.Entry<Character, Integer> entry : inputFreq.entrySet()) {
                char key = entry.getKey();
                int freq = entry.getValue();
                if(freq > 1) {
                    int num = freq / 2;
                    String strNeedToMerge = duplicateChar(key, num);
                    result = strNeedToMerge +result + strNeedToMerge;
                    inputFreq.put(key, freq - num * 2);
                }
            }
            while(!inputFreq.isEmpty()) {
                Map.Entry<Character, Integer> entry  = inputFreq.pollLastEntry();
                if(entry.getValue() > 0) {
                    String firstHalf = result.substring(0, result.length() / 2);
                    String secondHalf = result.substring(result.length() / 2);
                    result = firstHalf + entry.getKey() + secondHalf;
                    break;
                }
            }
            return result;
        }
        private String duplicateChar(char ch, int freq) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < freq; i++) {
                sb.append(ch);
            }
            return sb.toString();
        }
        public String solution1(String input) {
            int len = input.length();
            char[] inputArr = input.toCharArray();
            boolean dp[][] = new boolean[len][len];
            PriorityQueue<String> pq = new PriorityQueue<>((s1, s2)-> {
                if(s1.length() != s2.length()) return s2.length() - s1.length();
                return s1.compareTo(s2);
            });

            for(int right = 0; right < len; right++) {
                for(int left = 0; left <= right; left++) {
                    if(inputArr[left] == inputArr[right]) {
                        if(right - left > 2) {
                            if(dp[left+1][right-1]) {
                                String subStr = input.substring(left, right +1);
                                pq.offer(subStr);
                                dp[left][right] = true;
                            }
                        }else {
                            String subStr = input.substring(left, right +1);
                            pq.offer(subStr);
                            dp[left][right] = true;
                        }
                    }
                }
            }
            return pq.peek();
        }

    }



    public static void main(String[] args) {
        UberEasy3Solution uberEasy3Solution = new UberEasy3Solution();
        System.out.println(uberEasy3Solution.solution("adeadeadevue"));
    }
}

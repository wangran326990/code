package uber;

/***
 * Given two strings a and b, merge the strings so that the letters are added in alternating order starting with string a. If one string is longer than the other, then append the letters to the end of the merged string.
 * ex. "abcd", "efghi" -> "aebfcgdhi"
 * ex. "", "abcd" -> "abcd"
 * ex. "abcdefg", "zxy" -> "azbxycdefg"
 * Pretty easy. Just interlace them like a merge sort.
 */
public class UberEasy2 {
    static class UberEasy2Solution {
        public String solution(String s1, String s2) {
            int size1 = s1.length();
            int size2 = s2.length();
            char[] resultArr = new char[size1 + size2];
            char[] s1Arr = s1.toCharArray();
            char[] s2Arr = s2.toCharArray();
            int index1 = 0;
            int index2 = 0;
            int i = 0;
            while(index1 < size1 || index2 < size2) {
                if(index1 < size1 && index2 < size2) {
                    char cur1 = s1Arr[index1++];
                    char cur2 = s2Arr[index2++];
                    resultArr[i++] = cur1;
                    resultArr[i++] = cur2;
                }else if(index1 < size1) {
                    char cur1 = s1Arr[index1++];
                    resultArr[i++] = cur1;
                }else {
                    char cur2 = s2Arr[index2++];
                    resultArr[i++] = cur2;
                }
            }
            return new String(resultArr);
        }
    }

    public static void main(String[] args) {
        UberEasy2Solution uberEasy2Solution = new UberEasy2Solution();
        System.out.println(uberEasy2Solution.solution("","efghi"));
    }
}

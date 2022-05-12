package uber;

/**
 * Ques 1 : given 2 string s , t we have to find kth character from the string formed by following process lets say x = ""
 * i = 1 append s to x 1 time
 * i = 2 append t to x 2 times
 * i = 3 append s to x 3 times
 * i = 4 append t to x 4 times
 * i = 5 append s to x 5 times
 * and so on
 *
 * you are given k <= 10^16, you have to find kth character from x formed using above process.
 * eg: s = "a", t = "bc", k = 4 ---> given input
 */


public class CharacterCountInStr {

    static class CharacterCountInStrSolution {
            public String solution(String s, String t, long k) {
                int lengthS = s.length();
                int lengthT = t.length();
                long count = 0;
                String res ="";
                for(long i = 1; i <= k; i++) {
                    if(i%2 != 0) {
                        if(k - count <= lengthS * i) {
                            int index = (int)((k - count) % lengthS);
                            if(index == 0) {
                                res = s.charAt(lengthS - 1) +"";
                            }else {
                                res = s.charAt(index - 1)+"";
                            }
                            break;
                        }
                        count += lengthS * i;
                    }else {
                        if(k - count <= lengthT * i) {
                            int index = (int)((k - count) % lengthT);
                            if(index == 0) {
                                res = t.charAt(lengthT - 1)+"";
                            }else {
                                res = t.charAt(index - 1)+"";
                            }
                            break;
                        }
                        count += lengthT * i;
                    }
                }
                return res;
            }
    }
    public static void main(String[] args) {
        CharacterCountInStrSolution characterCountInStrSolution = new CharacterCountInStrSolution();
        System.out.println(characterCountInStrSolution.solution("abaed", "bc", 100));
    }
}

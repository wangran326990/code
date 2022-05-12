import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupAnagrams = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = String.copyValueOf(strArr);
            List<String> anagrams = groupAnagrams.getOrDefault(key, new ArrayList<>());
            anagrams.add(str);
            groupAnagrams.put(key, anagrams);
        }

        for(List<String> anagrams : groupAnagrams.values()) {
            result.add(anagrams);
        }
        return result;
    }
}

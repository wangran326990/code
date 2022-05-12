import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxDeviationAmongAllSubstrings {
    public int maxDeviation(String input) {
        Map<Character, List<Integer>> appearanceMap = new HashMap<>();
        char[] inputCharArr = input.toCharArray();
        int res = -1;
        List<Character> chsInInput = new ArrayList<>();
        for(int i = 0; i<inputCharArr.length; i++ ) {
            List<Integer> indexes = appearanceMap.getOrDefault(inputCharArr[i], new ArrayList<>());
            if(indexes.isEmpty()) chsInInput.add(inputCharArr[i]);
            indexes.add(i);
            appearanceMap.put(inputCharArr[i], indexes);
        }

        for(int i = 0; i < chsInInput.size(); i++) {
            for(int j = i+1; j < chsInInput.size(); j++) {
                char ch1 = chsInInput.get(i);
                char ch2 = chsInInput.get(j);
                List<Integer> ch1List = appearanceMap.get(ch1);
                List<Integer> ch2List = appearanceMap.get(ch2);
                int max = 0;
                int min = 0;
                int ch1Start = 0;
                int ch2Start = 0;
                int count = 0;
                while (ch1Start < ch1List.size() || ch2Start < ch2List.size()) {
                    if(ch1Start == ch1List.size()) {
                        ch2Start++;
                        count -=1;
                    }else if(ch2Start == ch2List.size()) {
                        ch1Start++;
                        count +=1;
                    }else if(ch1List.get(ch1Start) < ch2List.get(ch2Start)) {
                        ch1Start++;
                        count +=1;
                    }else {
                        ch2Start++;
                        count-=1;
                    }
                    max = Math.max(max, count);
                    min = Math.min(min, count);
                    res = Math.max(res, max - min);
                }
            }
        }
        return res;
    }
}

class MaxDeviationAmongAllSubstringsSolution {
    public static void main(String[] args) {
        MaxDeviationAmongAllSubstrings maxDeviationAmongAllSubstrings = new MaxDeviationAmongAllSubstrings();
        System.out.println(maxDeviationAmongAllSubstrings.maxDeviation("abbbcacbcdce"));
    }
}

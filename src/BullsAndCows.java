import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {
    public static void main(String[] args) {
        getHint("1123","0111");
    }
    public static String  getHint(String secret, String guess) {
        Map<Character, Set<Integer>> secretMap = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        int i = 0;
        Set<Integer> bullIndexes = new HashSet<>();
        for(Character c : secret.toCharArray()) {
            Set<Integer> list = secretMap.getOrDefault(c, new HashSet<>());
            count.put(c, count.getOrDefault(c,0)+1);
            list.add(i++);
            secretMap.put(c, list);
        }
        int bulls = 0;
        int cows = 0;
        i = 0;
        for(Character c: guess.toCharArray()) {
            Set<Integer> list = secretMap.getOrDefault(c, new HashSet<>());
            if(!list.isEmpty()){
                if(list.contains(i)) {
                    bulls++;
                    list.remove(i);
                    bullIndexes.add(i);
                    count.put(c, count.getOrDefault(c,0)-1);
                }
                secretMap.put(c, list);
            }
            i++;
        }
        i = 0;
        for(Character c: guess.toCharArray()) {
            Integer ccount = count.getOrDefault(c, 0);
            if(ccount > 0 && !bullIndexes.contains(i)){
                cows++;
                ccount--;
                count.put(c, ccount);
            }
            i++;
        }
        return bulls + "A" + cows + "B";
    }
}

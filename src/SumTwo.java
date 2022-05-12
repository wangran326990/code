import java.util.HashMap;
import java.util.Map;

public class SumTwo {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        twoSum(nums, 6);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int key = target - nums[i];

            if(numsMap.containsKey(key)) {
                int index = numsMap.get(key);
                if(i == index) continue;
                result[0] = i;
                result[1] = numsMap.get(key);
                return result;
            }
        }
        return result;
    }
}

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0};
        longestConsecutive(nums);
    }

    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int longestConsecutive = 1;
        int max = longestConsecutive;
        Arrays.sort(nums);
        int firstElement = nums[0];
        for(int i= 1; i < nums.length; i++) {
            if(firstElement + 1 == nums[i]) {
                longestConsecutive ++;
            }else {
                if(firstElement != nums[i])
                    longestConsecutive = 1;
            }

            firstElement = nums[i];
            max = Math.max(max, longestConsecutive);
        }
        return max;
    }
}

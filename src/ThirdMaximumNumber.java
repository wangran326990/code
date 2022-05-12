import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        //Arrays.sort(nums, Collections.reverseOrder());
        int index = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]) {
                continue;
            }else {
                index++;
                if(index == 3) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}

import java.util.PriorityQueue;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {0,2,2,1,1};
        firstMissingPositive(nums);
    }
    public static int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int result = 1;
        for(int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        while(!minHeap.isEmpty()) {
            int num = minHeap.poll();
            if(num < result) {
                continue;
            }else {
                if(num != result) return result;
                else result++;
            }
        }
        return result;
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PermutationsSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtracking(new ArrayList<>(), results, nums);
        return results;
    }
    public void backtracking(List<Integer> temp, List<List<Integer>> results, int[] nums) {
        if(temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
        }else {
            for(int i = 0; i < nums.length; i++) {
                if(!temp.contains(nums[i])) {
                    temp.add(nums[i]);
                    backtracking(temp, results, nums);
                    temp.remove(temp.size() -1);
                }
            }
        }
    }
}

public class Permutations {
    public static void main(String[] args) {
        PermutationsSolution permutationsSolution = new PermutationsSolution();
        int[] nums = {1,2,3};
        permutationsSolution.permute(nums);
    }
}

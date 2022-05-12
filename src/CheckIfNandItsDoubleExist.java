import java.util.HashSet;
import java.util.Set;

public class CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            int d = arr[i] * arr[i];
            if(set.contains(d)) {
                return true;
            }
        }
        return false;
    }
}

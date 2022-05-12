import java.util.Arrays;
import java.util.Stack;

public class SumofSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        //save index (lep[i]) of first less element before index (i)
        int[] lep = new int[arr.length];
        Arrays.fill(lep, -1);
        //save index (len[i]) of first less element after index (i)
        int[] len = new int[arr.length];
        Arrays.fill(len, -1);

        int M = (int)1e9 + 7;

        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                len[stack.peek()] = i;
                stack.pop();
            }
            lep[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        long result = 0;
        for(int i = 0; i < arr.length; i++ ) {
            int indLEP = lep[i];
            int indLEN = len[i];
            int leftCount = (indLEP == -1)? i + 1: i - indLEP;
            int rightCount = (indLEN == -1)? arr.length - i : indLEN - i;
            result = result  + ((long)arr[i] *  leftCount  *  rightCount) % M;
            result = result % M;
        }
        return (int)result;
    }

    public int sumSubarrayMaxs(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] mep = new int[arr.length];
        int[] men = new int[arr.length];
        Arrays.fill(mep, -1);
        Arrays.fill(men, -1);
        int M = (int)1e9 + 7;
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                men[stack.peek()] = i;
                stack.pop();
            }
            mep[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(i);
        }
        long result = 0;
        for(int i = 0; i < arr.length; i++ ) {
            int indMEP = mep[i];
            int indMEN = men[i];
            int leftCount = (indMEP == -1)? i + 1: i - indMEP;
            int rightCount = (indMEN == -1)? arr.length - i : indMEN - i;
            result = result  + ((long)arr[i] *  leftCount  *  rightCount) % M;
            result = result % M;
        }
        return (int)result;

    }

    public int sumSubarrayMins1(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[A.length + 1];
        stack.push(-1);
        int result = 0, M = (int)1e9 + 7;
        for (int i = 0; i < A.length; i++) {
            while (stack.peek() != -1 && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * A[i]) % M;
            stack.push(i);
            result += dp[i + 1];
            result %= M;
        }
        return result;
    }
}

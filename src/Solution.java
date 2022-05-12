//输入一个数字n，有-1, /2, /3三种操作。输出是最少几次能得到结果1，并输出每次的结果。
public class Solution {
    public int minCount(int n) {
        if (n <= 0) return -1;
        int[] dp = new int[n + 1];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;
            int num3 = i - 1;
            if (i % 3 == 0) {
                num1 = i / 3;
            }

            if (i % 2 == 0) {
                num2 = i / 2;
            }
            dp[i] = Math.min(dp[num3], Math.min(num1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[num1], num2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[num2])) + 1;
        }
        return dp[n];
    }
}

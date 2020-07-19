import java.util.Arrays;

/**
 * @author Zeng
 * @date 2020/7/19 10:46
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length]; // dp[i] => 以 nums[i] 结尾的最长子序列长度
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = lengthOfLIS(new int[]{1, 2, 3, 4});
        System.out.println(i);
    }

}

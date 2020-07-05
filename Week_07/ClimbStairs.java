/**
 * @author Zeng
 * @date 2020/7/4 23:56
 */
public class ClimbStairs {

    public static int climbStairs(int n) {
        if (n <= 2)
            return n;
        int[] memo = new int[n + 1];
        return recrusion(n, memo);
    }

    public static int recrusion(int x, int[] memo) {
        if (x <= 2) {
            return x;
        }
        if (memo[x] != 0) {
            return memo[x];
        }
        memo[x] = recrusion(x - 1, memo) + recrusion(x - 2, memo);
        return memo[x];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

}

/**
 * @author Zeng
 * @date 2020/7/11 8:55
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int idx = 31, ans = 0;
        while (idx >= 0) {
            ans += ((n & 1) << idx);
            idx--;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(4));
    }

}

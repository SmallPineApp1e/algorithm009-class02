/**
 * @author Zeng
 * @date 2020/7/11 8:42
 */
public class NumbersOfOneBit {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= (n - 1);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(31));
    }

}

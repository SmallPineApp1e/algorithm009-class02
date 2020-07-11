/**
 * @author Zeng
 * @date 2020/7/11 8:49
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return ((n & (n - 1)) == 0) && (n > 0);
    }

}

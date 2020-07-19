/**
 * @author Zeng
 * @date 2020/7/18 8:43
 */
public class ReverseStringII {

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i += 2 * k) {
            int remain = len - i;
            int r = 0;
            if (remain < k) { // 全部反转
                r = len - 1;
            } else { // 反转前 k 个
                r = i + k - 1;
            }
            for (int j = i; j < len && j < r; j++, r--) {
                swap(arr, j, r);
            }
        }
        return new String(arr);
    }

    private static void swap(char[] arr, int j, int r) {
        char temp = arr[j];
        arr[j] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        String abcdefg = reverseStr("abcdefg", 2);
        System.out.println(abcdefg);
    }

}

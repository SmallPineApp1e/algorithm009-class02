/**
 * @author Zeng
 * @date 2020/7/19 10:26
 */
public class ValidPalindromeII {

    public static boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            if (arr[i] != arr[j]) {
                return validPalindrome(arr, i + 1, j) || validPalindrome(arr, i, j - 1);
            }
        }
        return true;
    }
    public static boolean validPalindrome(char[] arr, int i, int j) {
        for (int k = i; k <= j; k++, j--) {
            if (arr[k] != arr[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean abdbdbsa = validPalindrome("abdbdbsa");
        System.out.println(abdbdbsa);
    }

}

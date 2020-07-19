/**
 * @author Zeng
 * @date 2020/7/18 9:36
 */
public class ReverseWordInAStringIII {

    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                int j = i;
                while (j + 1 < arr.length && arr[j + 1] != ' ') {
                    j++;
                }
                reverse(arr, i, j);
                i = j;
            }
        }
        return new String(arr);
    }

    private static void reverse(char[] arr, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        String s = reverseWords("I AM THE KING OF THE BUG!");
        System.out.println(s);
    }

}

/**
 * @author Zeng
 * @date 2020/7/18 10:13
 */
public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j;) {
            while (i < j && isCharacter(arr[i]) && isCharacter(arr[j])) {
                swap(arr, i, j);
                i++;
                j--;
            }
            if (!isCharacter(arr[i])) i++;
            if (!isCharacter(arr[j])) j--;
        }
        return new String(arr);
    }

    public static boolean isCharacter(char ch) {
        return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String s = reverseOnlyLetters("asdsad=d=sad=d=d=ggd=f");
        System.out.println(s);
    }


}

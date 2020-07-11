/**
 * @author Zeng
 * @date 2020/7/11 8:41
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[27];
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            cnt[arr1[i] - 'a']++;
            cnt[arr2[i] - 'a']--;
        }
        for (int num : cnt) {
            if (num > 0) return false;
        }
        return true;
    }

}

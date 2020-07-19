/**
 * @author Zeng
 * @date 2020/7/19 12:11
 */
public class StringToIntegerAtoi {

    public static int myAtoi(String str) {
        // 去除前导空格
        int index = 0;
        char[] arr = str.toCharArray();
        while (index < arr.length && arr[index] == ' ') {
            index++;
        }
        if (index == arr.length) {
            return 0;
        }
        // 判断第一位是否符号位
        int isPositive = 1;
        if (arr[index] == '-') {
            isPositive = -1;
            index++;
        } else if (arr[index] == '+') {
            index++;
        }
        // 开始转换
        int res = 0;
        for (; index < arr.length; index++) {
            // 判断是否数字
            int num = arr[index] - '0';
            if (num < 0 || num > 9) {
                break;
            }
            // 是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer. MAX_VALUE % 10)) {
                return isPositive == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + num;
        }
        return res * isPositive;
    }

    public static void main(String[] args) {
        int abcsda = myAtoi("    +423894723 sad");
        System.out.println(abcsda);
    }

}

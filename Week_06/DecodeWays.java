/**
 * @author Zeng
 * @date 2020/7/1 0:11
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){return 0;}
        if (s.length() == 1 && !"0".equals(s)) { return 1; }
        int[] dp = new int[s.length()];
        if(s.charAt(1) == '0' && s.charAt(0) > '2'){return 0;}
        dp[0] = 1;
        if((s.charAt(1) == '0' && s.charAt(0) <= '2')||(s.charAt(0) >= '3')||(s.charAt(0) == '2' && s.charAt(1) > '6')){
            dp[1] = 1;
        }else if(s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6')){
            dp[1] = 2;
        }
        for (int i = 2; i < dp.length; i++){
            if((s.charAt(i) == '0' && s.charAt(i-1) == '0') || (s.charAt(i) == '0' && s.charAt(i-1) > '2')){return 0;}
            if(s.charAt(i-1) == '0'
                    || (s.charAt(i-1) == '2' && s.charAt(i) > '6')
                    || (s.charAt(i-1) > '2')){
                dp[i] = dp[i-1];
                continue;
            }
            if(s.charAt(i) == '0' && s.charAt(i-1) <= '2'){dp[i] = dp[i-2];continue;}
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length - 1];
    }

}

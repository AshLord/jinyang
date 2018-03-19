package org.java.practice.lintcode.medium;

import static org.java.practice.lintcode.Util.printDp;

/**
 * @author yang.jin
 * date: 15/03/2018
 * desc: 动态规划题
 */
public class 交叉字符串2 {
    public static void main(String[] args) {
        交叉字符串2 test = new 交叉字符串2();
        String s = "aadbbcbcac";
        //String s = "aadbbbaccc";
        System.out.println(test.isInterleave("aabcc", "dbbca", s));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here  
        if(s3.length()!=s1.length()+s2.length())
            return false;
        if(s1.length()==0)
            return s2.equals(s3);
        if(s2.length()==0)
            return s1.equals(s3);
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i=1;i<=s1.length();i++) {
            dp[i][0] = dp[i - 1][0] && (s3.charAt(i - 1) == s1.charAt(i - 1));
        }
        for(int i=1;i<=s2.length();i++) {
            dp[0][i] = dp[0][i - 1] && (s3.charAt(i - 1) == s2.charAt(i - 1));
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                int t = i+j;
                if(s1.charAt(i-1)==s3.charAt(t-1)) {
                    dp[i][j] = dp[i][j]||dp[i-1][j];
                }
                if(s2.charAt(j-1)==s3.charAt(t-1)) {
                    dp[i][j] = dp[i][j]||dp[i][j-1];
                }
            }
        }
        printDp(dp);
        return dp[s1.length()][s2.length()];
    }
}

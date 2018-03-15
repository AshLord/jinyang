package org.java.practice.lintcode.medium;

/**
 * @author yang.jin
 * date: 15/03/2018
 * desc:
 */
public class 交叉字符串 {
    public static void main(String[] args) {
        交叉字符串 test = new 交叉字符串();
        //String s = "aadbbcbcac";
        String s = "aadbbbaccc";
        System.out.println(test.isInterleave("aabcc","dbbca",s));
    }

    String s1 = null;
    String s2 = null;
    String s3 = null;
    boolean res = false;
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        helper(0,0,s3);
        return res;
    }
    public void helper(int idxS1,int beginS3,String subStringOfS3) {
        if (idxS1 > s1.length()-1) {
            if (s2.equals(subStringOfS3)) {
                res = true;
            }
            return;
        }
        char aim = s1.charAt(idxS1);
        char[] arrSubS3 = subStringOfS3.toCharArray();
        for (int i=beginS3;i<arrSubS3.length;i++) {
            //找到s1和s3相等元素
            if (arrSubS3[i] == aim) {
                StringBuilder sb = new StringBuilder();
                for (int j=0;j<arrSubS3.length;j++) {
                    if (j != i) {
                        sb.append(arrSubS3[j]);
                    }
                }
                idxS1++;
                helper(idxS1,i,sb.toString());
            }
        }
    }

}

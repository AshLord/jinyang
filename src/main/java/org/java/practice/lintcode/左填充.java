package org.java.practice.lintcode;

/**
 * Created by 晋阳 on 2017/12/31.
 * 左填充
 */
public class 左填充 {

    public static void main(String[] args) {

        String str = "foo";
        switch (0) {
            case 0:
                System.out.println(leftPad(str, 5));
                System.out.println(leftPad(str,5,'1'));
                break;
            default:
                return;
        }
    }

    static public String leftPad(String originalStr, int size) {
        // Write your code here
        return leftPad(originalStr,size,' ');
    }

    public static String leftPad(String originalStr, int size, char padChar) {
        // write your code here
        StringBuffer sb = new StringBuffer(originalStr);
        int padLength = size - originalStr.length() ;
        for (int i=0;i<padLength;i++) {
            sb.insert(0, padChar);
        }
        return sb.toString();
    }
}

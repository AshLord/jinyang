package org.java.practice.lintcode.easy;

/**
 * @author yang.jin
 * date: 27/02/2018
 * desc:给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 *
offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
 */
public class 旋转字符串 {

    public static void main(String[] args) {
        旋转字符串 test = new 旋转字符串();
        test.rotateString("".toCharArray(),8);
    }

    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length == 0) return;
        offset = offset % str.length;
        char[] arr = new char[str.length];
        System.arraycopy(str, 0, arr, offset, str.length - offset);
        for (int i=0;i<offset;i++) {
            arr[i] = str[str.length-offset+i];
        }
        System.arraycopy(arr, 0, str, 0, str.length);
    }
}

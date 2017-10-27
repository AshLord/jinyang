package org.java.practice.web;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yang.jin on 24/10/2017.
 */
public class Byte2Char {

    public void byte2Char() {

        try {
            StringBuffer str = new StringBuffer();
            char[] buf = new char[1024];
            FileReader f = new FileReader("file");
            while (f.read(buf) > 0) {
                str.append(buf);
            }
            f.close();
            str.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

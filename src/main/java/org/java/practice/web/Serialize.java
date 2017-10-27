package org.java.practice.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by yang.jin on 24/10/2017.
 */
public class Serialize implements Serializable{

    private static final long serialVersionUID = -4281219482089900235L;

    public int num = 1390;

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("d:/serialize.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Serialize serialize = new Serialize();
            oos.writeObject(serialize);
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

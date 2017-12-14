package org.java.practice.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 晋阳 on 2017/11/19.
 */
public class ClassReloader extends ClassLoader {

    private String classPath;

    String className = "compile.Yufa";

    public ClassReloader(String classPath) {
        this.classPath = classPath;
    }

    protected Class<?> findClass(String name) throws java.lang.ClassNotFoundException {
        byte[] classData = null;
        String path = classPath + className;
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = is.read(buffer)) != -1) {
                stream.write(buffer,0,num);
            }
            classData = stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (classData == null) {
            throw new java.lang.ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            String path = "D:/";
            ClassReloader reloader = new ClassReloader(path);
            Class r = reloader.findClass("Yufa.class");
            System.out.println(r.newInstance());
            ClassReloader reloader2 = new ClassReloader(path);
            Class r2 = reloader2.findClass("Yufa.class");
            System.out.println(r2.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

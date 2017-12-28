package org.java.practice.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by 晋阳 on 2017/11/19.
 */
public class NetClassLoader extends ClassLoader {
    private String classPath;

    private String packageName = "net.jinyang.classloader";

    public NetClassLoader(String classPath) {
        this.classPath = classPath;
    }

    /*protected Class<?> findClass(String name) {
        Class<?> aClass = findLoadedClass(name);
        if (aClass != null) {
            return aClass;
        }
        if (packageName.startsWith(name)) {
            byte[] classData = null;
            String path = classPath + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
            try {
                URL url = new URL(path);
                InputStream is = url.openStream();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                byte[] buffer = new byte[2048];
                int num = 0;
                while ((num = is.read(buffer)) != -1) {
                    stream.write(buffer,0,num);
                }
                // 网络传输安全性要求的类数据加解密
                classData = decode(stream.toByteArray());

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (classData == null) {
                throw new ClassNotFoundException();
            } else {
                return defineClass(name, classData, 0, classData.length);
            }

        } else {
            return super.loadClass(name);
        }
    }*/

    private byte[] decode(byte[] src) {
        return src;
    }
}

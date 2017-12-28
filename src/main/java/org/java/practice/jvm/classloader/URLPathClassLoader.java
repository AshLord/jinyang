package org.java.practice.jvm.classloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by 晋阳 on 2017/11/19.
 */
public class URLPathClassLoader extends URLClassLoader{

    private String packageName = "net.jinyang.classloader";

    public URLPathClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    /*protected Class<?> findClass(String name) {
        Class<?> aClass = findLoadedClass(name);
        if (aClass != null) {
            return aClass;
        }
        if (!packageName.startsWith(name)) {
            return super.loadClass(name);
        } else {
            return super.findClass(name);
        }
    }*/


}

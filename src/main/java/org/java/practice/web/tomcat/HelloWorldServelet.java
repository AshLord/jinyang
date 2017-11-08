package org.java.practice.web.tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 晋阳 on 2017/11/8.
 */
public class HelloWorldServelet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        ClassLoader classLoader = getClass().getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.getClass().getCanonicalName());
            classLoader = classLoader.getParent();
        }

    }

    public static void main(String[] args) {
        HelloWorldServelet helloWorldServelet = new HelloWorldServelet();
    }
}

package org.java.practice.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by yang.jin on 31/10/2017.
 */
public class SocketTest {

    public void socketTest() throws IOException {
        Socket socket = new Socket();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        is.close();
        os.close();
        socket.close();
    }
}

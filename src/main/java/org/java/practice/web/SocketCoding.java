package org.java.practice.web;

import java.net.Socket;

/**
 * Created by 晋阳 on 2017/10/28.
 */
public class SocketCoding {

    public void socketCoding() {
        //创建和使用socket

        //第一步：创建socket：第一个参数：设置网络层的协议，第二个参数设置传输数据的方式，第三个参数：传输层的协议

        //Socket listenSocket=new Socket(AddressFamily.InterNetwor,SocketType.Stream,ProtocolTypt.Tcp);

        //第二步：绑定一个端口和Ip地址

        //根据字符串创建一个ip地址对象

        //IpAddress ip=IpAddress.parse(this.txtIp.Text);//127.0.0.1

        //创建一个节点

        //IpEndpoint endpoint =new IpEndpoint(ip,int.Parse(this.txtport.Text));

        //listenSocket.Bind(endpoint);

        //第三步：开始监听端口

        //listensocket.Listen(10);//连接队列的最大数

        //第四步：开始接受用户的连接

        //Accept会阻塞主线程，直到客户端连接上来后，方法执行完成并返回代理Socket

        //Socket proxSocket=listenSocket.Accept();

        //给客户端传输一个字符串

        //var  buffer =Encoding.Default.GetBytes("asdf ");

        //proxSocket.Send(buffer);
    }
}

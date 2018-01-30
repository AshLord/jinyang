package org.java.practice.web.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.proxy.HttpProxyHandler;

import java.net.InetSocketAddress;

public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception{
        if (args.length != 1) {
            System.err.println("Usage:"+HttpServer.class.getSimpleName()+ "<port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        new HttpServer(port).start();
    }

    public void start() throws Exception {
        ServerBootstrap b = new ServerBootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        b.group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        System.out.println("initChannel ch: " + ch);
                        ch.pipeline()
                                .addLast("decoder", new HttpRequestDecoder())
                                .addLast("encoder", new HttpRequestEncoder())
                                /**
                                 * aggregator，消息聚合器（重要）。为什么能有FullHttpRequest这个东西，就是因为有他，HttpObjectAggregator，如果没有他，就不会有那个消息是FullHttpRequest的那段Channel，同样也不会有FullHttpResponse。
                                 如果我们将HttpObjectAggregator(512 * 1024)的参数含义是消息合并的数据大小，如此代表聚合的消息内容长度不超过512kb。
                                 */
                                .addLast("aggregator", new HttpObjectAggregator(512 * 1024))
                                .addLast("handler", new HttpProxyHandler(new InetSocketAddress(port)));
                    }
                }).option(ChannelOption.SO_BACKLOG, 128)// 确定队列的连接数。
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
        b.bind(port).sync();
    }
}

package org.java.practice.web.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

/**
 * @author yang.jin
 * date: 31/01/2018
 * desc:
 */
public class SSLChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final SslContext sslContext;

    public SSLChannelInitializer() {
        String keyStoreFilePath = "/root/.ssl/test.pkcs12";
        String keyStorePassword = "Password@123";

        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream(keyStoreFilePath), keyStorePassword.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, keyStorePassword.toCharArray());

            sslContext = SslContext.newServerContext(null,new File(keyStoreFilePath),keyStorePassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        SSLEngine sslEngine = sslContext.newEngine(ch.alloc());
        pipeline
                .addLast(new SslHandler(sslEngine))
                .addLast("decoder", new HttpRequestDecoder())
                .addLast("encoder", new HttpResponseEncoder())
                .addLast("aggregator", new HttpObjectAggregator(512 * 1024))
                .addLast("handler", new HttpHandler());

    }
}

package org.java.practice.web.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.AsciiString;
import io.netty.handler.codec.http.*;

/**
 * @author yang.jin
 * date: 31/01/2018
 * desc: Handler需要声明泛型为<FullHttpRequest>，声明之后，只有msg为FullHttpRequest的消息才能进来。
 */
public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private AsciiString contentType = HttpHeaderValues.TEXT_PLAIN;

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        System.out.println("class:" + msg.getClass().getName());
        /**
         *         生成response，这里使用的FullHttpResponse，同FullHttpRequest类似，通过这个我们就不用将response拆分成多个channel返回给请求端了。
         */
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK, Unpooled.wrappedBuffer("illidan stormrage".getBytes()));

        /**
         * 添加header描述length。这一步是很重要的一步，如果没有这一步，你会发现用postman发出请求之后就一直在刷新，因为http请求方不知道返回的数据到底有多长。
         */
        HttpHeaders heads = response.headers();
        heads.add(HttpHeaderNames.CONTENT_TYPE, contentType + "; charset=UTF-8");
        heads.add(HttpHeaderNames.CONTENT_LENGTH, String.valueOf(response.content().readableBytes()));
        heads.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);

        ctx.write(response);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel read complete ");
        super.channelReadComplete(ctx);
        /**
         * channel读取完成之后需要输出缓冲流。如果没有这一步，你会发现postman同样会一直在刷新。
         */
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("exception handle");
        if (cause != null) {
            cause.printStackTrace();
        }
        if (ctx != null) {
            ctx.close();
        }
    }
}

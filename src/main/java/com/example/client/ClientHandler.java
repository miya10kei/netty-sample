package com.example.client;

import com.example.RequestData;
import com.example.ResponseData;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        RequestData msg = new RequestData();
        msg.setIntValue(123);
        msg.setStringValue("all work and no play makes jack a dull boy");
        ChannelFuture future = ctx.writeAndFlush(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println((ResponseData) msg);
        ctx.close();
    }
}

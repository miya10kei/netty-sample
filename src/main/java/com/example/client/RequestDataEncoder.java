package com.example.client;

import com.example.RequestData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class RequestDataEncoder extends MessageToByteEncoder<RequestData> {

    @Override
    protected void encode(ChannelHandlerContext ctx, RequestData msg, ByteBuf out) {
        out.writeInt(msg.getIntValue());
        out.writeInt(msg.getStringValue().length());
        out.writeCharSequence(msg.getStringValue(), StandardCharsets.UTF_8);
    }
}

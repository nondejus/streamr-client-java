package com.streamr.client.protocol.control_layer;

import com.streamr.client.protocol.message_layer.MessageRef;

public class ResendFromRequest extends ControlMessage {
    public static final int TYPE = 12;

    private final String streamId;
    private final int streamPartition;
    private final String requestId;
    private final MessageRef fromMsgRef;
    private final String publisherId;
    private final String msgChainId;
    private final String sessionToken;

    public ResendFromRequest(String streamId, int streamPartition, String requestId, MessageRef fromMsgRef,
                             String publisherId, String msgChainId, String sessionToken) {
        super(TYPE);
        this.streamId = streamId;
        this.streamPartition = streamPartition;
        this.requestId = requestId;
        this.fromMsgRef = fromMsgRef;
        this.publisherId = publisherId;
        this.msgChainId = msgChainId;
        this.sessionToken = sessionToken;
    }

    public String getStreamId() {
        return streamId;
    }

    public int getStreamPartition() {
        return streamPartition;
    }

    public String getRequestId() {
        return requestId;
    }

    public MessageRef getFromMsgRef() {
        return fromMsgRef;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getMsgChainId() {
        return msgChainId;
    }

    public String getSessionToken() {
        return sessionToken;
    }
}

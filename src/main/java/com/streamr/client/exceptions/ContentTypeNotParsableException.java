package com.streamr.client.exceptions;

import com.streamr.client.protocol.message_layer.StreamMessage;

public class ContentTypeNotParsableException extends RuntimeException {
    public ContentTypeNotParsableException(StreamMessage.MessageType messageType) {
        super("Content with content type " + messageType.getId() + " cannot get parsed. Use serializedContent() method.");
    }
}

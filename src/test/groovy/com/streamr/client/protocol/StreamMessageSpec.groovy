package com.streamr.client.protocol


import com.streamr.client.exceptions.EncryptedContentNotParsableException
import com.streamr.client.protocol.message_layer.MessageID
import com.streamr.client.protocol.message_layer.MessageRef
import com.streamr.client.protocol.message_layer.StreamMessage
import com.streamr.client.protocol.message_layer.StreamMessage.EncryptionType
import com.streamr.client.protocol.message_layer.StreamMessageAdapter
import com.streamr.client.utils.HttpUtils
import spock.lang.Specification

class StreamMessageSpec extends Specification {

	StreamMessage msg

	void setup() {
		msg = StreamMessageExamples.InvalidSignature.helloWorld
	}

	void "constructor that takes Map content sets the correct serializedContent"() {
		String serializedContent = msg.getSerializedContent()
		Map<String, Object> mapContent = HttpUtils.mapAdapter.fromJson(serializedContent)

		when:
		msg = new StreamMessage(
				msg.getMessageID(),
				msg.getMessageRef(),
				mapContent)
		then:
		msg.getParsedContent() == mapContent
		msg.getSerializedContent() == serializedContent

	}

	void "getParsedContent() throws if message is AES encrypted"() {
		when:
		msg.setEncryptionType(EncryptionType.AES)
		msg.getParsedContent()
		then:
		thrown EncryptedContentNotParsableException

		// TODO: the whole content should be either encrypted or not encrypted
		// Address in a subsequent PR and then uncomment this test
		/*
		when:
		msg.setEncryptionType(EncryptionType.RSA)
		msg.getParsedContent()
		then:
		thrown EncryptedContentNotParsableException
		 */
	}
}

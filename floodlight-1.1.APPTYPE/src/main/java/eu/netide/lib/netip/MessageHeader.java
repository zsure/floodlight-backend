package eu.netide.lib.netip;

import eu.netide.lib.netip.MessageType;
import eu.netide.lib.netip.NetIDEProtocolVersion;
import java.nio.ByteBuffer;

public class MessageHeader implements Cloneable {
	public static final int HEADER_BYTES = 24;
	private NetIDEProtocolVersion netIDEProtocolVersion;
	private MessageType messageType;
	private short payloadLength;
	private int transactionId;
	private int apptype;
	private int moduleId;
	private long datapathId;

	public MessageHeader() {
		this.netIDEProtocolVersion = NetIDEProtocolVersion.VERSION_1_4;
	}

	public NetIDEProtocolVersion getNetIDEProtocolVersion() {
		return this.netIDEProtocolVersion;
	}

	public void setNetIDEProtocolVersion(NetIDEProtocolVersion netIDEProtocolVersion) {
		this.netIDEProtocolVersion = netIDEProtocolVersion;
	}

	public MessageType getMessageType() {
		return this.messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public short getPayloadLength() {
		return this.payloadLength;
	}

	public void setPayloadLength(short payloadLength) {
		this.payloadLength = payloadLength;
	}

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public int getApptype() {
		return this.apptype;
	}

	public void setApptype(int apptype) {
		this.apptype = apptype;
	}

	public int getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public long getDatapathId() {
		return this.datapathId;
	}

	public void setDatapathId(long datapathId) {
		this.datapathId = datapathId;
	}

	public byte[] toByteRepresentation() {
		byte[] bytes = new byte[24];
		bytes[0] = this.netIDEProtocolVersion.getValue();
		bytes[1] = this.messageType.getValue();
		System.arraycopy(ByteBuffer.allocate(2).putShort(this.payloadLength).array(), 0, bytes, 2, 2);
		System.arraycopy(ByteBuffer.allocate(4).putInt(this.transactionId).array(), 0, bytes, 4, 4);
		System.arraycopy(ByteBuffer.allocate(4).putInt(this.apptype).array(), 0, bytes, 8, 4);
		System.arraycopy(ByteBuffer.allocate(4).putInt(this.moduleId).array(), 0, bytes, 12, 4);
		System.arraycopy(ByteBuffer.allocate(8).putLong(this.datapathId).array(), 0, bytes, 16, 8);
		return bytes;
	}

	public String toString() {
		return "MessageHeader [Version=" + this.netIDEProtocolVersion.name() + ",Type=" + this.messageType.name()
				+ ",Length=" + this.payloadLength + ",ModuleId=" + this.moduleId + ",apptype=" + this.apptype + ",TransactionId="
				+ this.transactionId + ",DatapathId=" + this.datapathId + "]";
	}

}

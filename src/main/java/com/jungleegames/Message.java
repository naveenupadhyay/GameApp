package com.jungleegames;

public class Message {

    private String from;
    private String msgType;
    private String text;

    public String getText() {
        return text;
    }

    public String getFrom() {
        return from;
    }

	public void setFrom(String from) {
		this.from = from;
	}

	public String getMsgType() {
		return msgType;
	}

	@Override
	public String toString() {
		return "Message [from=" + from + ", msgType=" + msgType + ", text=" + text + "]";
	}

	
}

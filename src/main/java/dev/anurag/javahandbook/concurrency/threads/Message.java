package dev.anurag.javahandbook.concurrency.threads;

public class Message {
	public String msg;

	public Message(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}
	
	public void setMsg(String str) {
        this.msg=str;
    }

}

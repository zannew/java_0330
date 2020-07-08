package guestbook.model;

public class Message {

	private int uid;
	private String uname;
	private String pw;
	private String msg;
	
	
	public Message() {
		super();
	}

	public Message(int uid, String uname, String pw, String msg) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pw = pw;
		this.msg = msg;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [uid=" + uid + ", uname=" + uname + ", pw=" + pw + ", msg=" + msg + "]";
	}
	
	
	
	
	
}

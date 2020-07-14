package member.model;

// sql로 받음 : DB에서 받아옴
import java.sql.Date;

public class Member {
	
	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private String uphoto;
	private Date regdate;
	
	//default constructor
	public Member() {}

	//constructor
	public Member(int idx, String uid, String upw, String uname, String uphoto, Date regdate) {
		super();
		this.idx = idx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
		this.regdate = regdate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUphoto() {
		return uphoto;
	}

	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	// java.sql.Date → java.util.Date 변환	
	public java.util.Date getToDate(){		//${member.toDate}
		return new java.util.Date(regdate.getTime());	// getTime() : 기준 날짜이후 밀리세컨단위 long타입으로 리턴
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto
				+ ", regdate=" + regdate + "]";
	}
		
	
}

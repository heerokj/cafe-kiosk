package vo;

public class MemberVO {
	String id, ename, pw, gender, motive;
	
	
	public MemberVO() {}

	public MemberVO(String id, String ename, String pw, String gender, String motive) {
		super();
		this.id = id;
		this.ename = ename;
		this.pw = pw;
		this.gender = gender;
		this.motive = motive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMotive() {
		return motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

}

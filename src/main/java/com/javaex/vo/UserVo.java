package com.javaex.vo;

public class UserVo {
	
	//필드
	private int user_no;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_gender;
	private String user_age;
	private String user_hp;
	private String user_reg;
	private String user_address;
	
	//생성자
	public UserVo() {
		
	}

	public UserVo(int user_no, String user_id, String user_pw, String user_name, String user_gender, String user_age,
			String user_hp, String user_reg, String user_address) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_gender = user_gender;
		this.user_age = user_age;
		this.user_hp = user_hp;
		this.user_reg = user_reg;
		this.user_address = user_address;
	}

	
	//메소드 g/s
	
	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_age() {
		return user_age;
	}

	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}

	public String getUser_hp() {
		return user_hp;
	}

	public void setUser_hp(String user_hp) {
		this.user_hp = user_hp;
	}

	public String getUser_reg() {
		return user_reg;
	}

	public void setUser_reg(String user_reg) {
		this.user_reg = user_reg;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	
	//메소드 일반

	@Override
	public String toString() {
		return "UserVo [user_no=" + user_no + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_name="
				+ user_name + ", user_gender=" + user_gender + ", user_age=" + user_age + ", user_hp=" + user_hp
				+ ", user_reg=" + user_reg + ", user_address=" + user_address + "]";
	}
	
	
}

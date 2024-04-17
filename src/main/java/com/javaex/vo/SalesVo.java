package com.javaex.vo;

public class SalesVo {

	private int p_no;
	private String p_name;
	private int p_price;
	private String p_category;
	private String p_explanation;
	private String filePath;
	private String orgName;
	private String saveName;
	private long fileSize;
	private String p_remarks;
	private int e_no;
	private int o_no;
	private int e_amount;
	private String e_size;
	private int user_no;
	private String o_name;
	private String o_address;
	private String o_hp;
	private String o_request;
	private int totalprice;
	private String o_date;
	private String o_status;
	private String o_payment;
	
	public SalesVo() {
		super();
	}

	public SalesVo(int p_no, String p_name, int p_price, String p_category, String p_explanation, String filePath,
			String orgName, String saveName, long fileSize, String p_remarks, int e_no, int o_no, int e_amount,
			String e_size, int user_no, String o_name, String o_address, String o_hp, String o_request, int totalprice,
			String o_date, String o_status, String o_payment) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_category = p_category;
		this.p_explanation = p_explanation;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
		this.p_remarks = p_remarks;
		this.e_no = e_no;
		this.o_no = o_no;
		this.e_amount = e_amount;
		this.e_size = e_size;
		this.user_no = user_no;
		this.o_name = o_name;
		this.o_address = o_address;
		this.o_hp = o_hp;
		this.o_request = o_request;
		this.totalprice = totalprice;
		this.o_date = o_date;
		this.o_status = o_status;
		this.o_payment = o_payment;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getP_explanation() {
		return p_explanation;
	}

	public void setP_explanation(String p_explanation) {
		this.p_explanation = p_explanation;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getP_remarks() {
		return p_remarks;
	}

	public void setP_remarks(String p_remarks) {
		this.p_remarks = p_remarks;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public int getE_amount() {
		return e_amount;
	}

	public void setE_amount(int e_amount) {
		this.e_amount = e_amount;
	}

	public String getE_size() {
		return e_size;
	}

	public void setE_size(String e_size) {
		this.e_size = e_size;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getO_name() {
		return o_name;
	}

	public void setO_name(String o_name) {
		this.o_name = o_name;
	}

	public String getO_address() {
		return o_address;
	}

	public void setO_address(String o_address) {
		this.o_address = o_address;
	}

	public String getO_hp() {
		return o_hp;
	}

	public void setO_hp(String o_hp) {
		this.o_hp = o_hp;
	}

	public String getO_request() {
		return o_request;
	}

	public void setO_request(String o_request) {
		this.o_request = o_request;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

	public String getO_status() {
		return o_status;
	}

	public void setO_status(String o_status) {
		this.o_status = o_status;
	}

	public String getO_payment() {
		return o_payment;
	}

	public void setO_payment(String o_payment) {
		this.o_payment = o_payment;
	}

	@Override
	public String toString() {
		return "SalesVo [p_no=" + p_no + ", p_name=" + p_name + ", p_price=" + p_price + ", p_category=" + p_category
				+ ", p_explanation=" + p_explanation + ", filePath=" + filePath + ", orgName=" + orgName + ", saveName="
				+ saveName + ", fileSize=" + fileSize + ", p_remarks=" + p_remarks + ", e_no=" + e_no + ", o_no=" + o_no
				+ ", e_amount=" + e_amount + ", e_size=" + e_size + ", user_no=" + user_no + ", o_name=" + o_name
				+ ", o_address=" + o_address + ", o_hp=" + o_hp + ", o_request=" + o_request + ", totalprice="
				+ totalprice + ", o_date=" + o_date + ", o_status=" + o_status + ", o_payment=" + o_payment + "]";
	}
	
	
	
	
}

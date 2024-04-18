package com.javaex.vo;

public class ProductVo {

	private int p_no;
	private String p_name;
	private int p_price;
	private String p_category;
	private String p_explanation;
	private String orgName;
	private String saveName;
	private String filePath;
	private long fileSize;
	private String p_remarks;
	private int ep_no;

	public ProductVo() {
		super();
	}

	public ProductVo(String p_name, int p_price, String p_category, String p_explanation, String orgName,
			String saveName, String filePath, long fileSize) {
		super();
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_category = p_category;
		this.p_explanation = p_explanation;
		this.orgName = orgName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}

	public ProductVo(int p_no, String p_name, int p_price, String p_category, String p_explanation, String orgName,
			String saveName, String filePath, long fileSize, String p_remarks, int ep_no) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_category = p_category;
		this.p_explanation = p_explanation;
		this.orgName = orgName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.p_remarks = p_remarks;
		this.ep_no = ep_no;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	public int getEp_no() {
		return ep_no;
	}

	public void setEp_no(int ep_no) {
		this.ep_no = ep_no;
	}

	@Override
	public String toString() {
		return "ProductVo [p_no=" + p_no + ", p_name=" + p_name + ", p_price=" + p_price + ", p_category=" + p_category
				+ ", p_explanation=" + p_explanation + ", orgName=" + orgName + ", saveName=" + saveName + ", filePath="
				+ filePath + ", fileSize=" + fileSize + ", p_remarks=" + p_remarks + ", ep_no=" + ep_no + "]";
	}

}

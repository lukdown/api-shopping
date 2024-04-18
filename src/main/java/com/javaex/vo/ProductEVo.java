package com.javaex.vo;

public class ProductEVo {

	private int e_no;
	private int p_no;
	private int o_no;
	private int e_amount;
	private String e_size;
	
	private int c_p_amount;
	private String c_size;
	private int c_no;
	
	private String o_name;
	private String p_name;
	private int p_price;
	private int totalprice;
	private String o_status;
	
	public ProductEVo() {
		super();
	}

	public ProductEVo(int e_no, int p_no, int o_no, int e_amount, String e_size, int c_p_amount, String c_size,
			int c_no) {
		super();
		this.e_no = e_no;
		this.p_no = p_no;
		this.o_no = o_no;
		this.e_amount = e_amount;
		this.e_size = e_size;
		this.c_p_amount = c_p_amount;
		this.c_size = c_size;
		this.c_no = c_no;
	}

	

	public ProductEVo(int e_no, int p_no, int o_no, int e_amount, String e_size, int c_p_amount, String c_size,
			int c_no, String o_name, String p_name, int p_price, int totalprice, String o_status) {
		super();
		this.e_no = e_no;
		this.p_no = p_no;
		this.o_no = o_no;
		this.e_amount = e_amount;
		this.e_size = e_size;
		this.c_p_amount = c_p_amount;
		this.c_size = c_size;
		this.c_no = c_no;
		this.o_name = o_name;
		this.p_name = p_name;
		this.p_price = p_price;
		this.totalprice = totalprice;
		this.o_status = o_status;
	}

	public int getE_no() {
		return e_no;
	}


	public void setE_no(int e_no) {
		this.e_no = e_no;
	}


	public int getP_no() {
		return p_no;
	}


	public void setP_no(int p_no) {
		this.p_no = p_no;
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


	public int getC_p_amount() {
		return c_p_amount;
	}


	public void setC_p_amount(int c_p_amount) {
		this.c_p_amount = c_p_amount;
	}


	public String getC_size() {
		return c_size;
	}

	public void setC_size(String c_size) {
		this.c_size = c_size;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getO_name() {
		return o_name;
	}

	public void setO_name(String o_name) {
		this.o_name = o_name;
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

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getO_status() {
		return o_status;
	}

	public void setO_status(String o_status) {
		this.o_status = o_status;
	}

	@Override
	public String toString() {
		return "ProductEVo [e_no=" + e_no + ", p_no=" + p_no + ", o_no=" + o_no + ", e_amount=" + e_amount + ", e_size="
				+ e_size + ", c_p_amount=" + c_p_amount + ", c_size=" + c_size + ", c_no=" + c_no + "]";
	}

	

	
}

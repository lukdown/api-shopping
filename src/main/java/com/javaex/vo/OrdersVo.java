package com.javaex.vo;

public class OrdersVo {

	//필드
	private int o_no;
	private String o_name;
	private String o_address;
	private String o_hp;
	private String o_request;
	private int totalprice;
	private String o_date;
	private String o_status;
	private String o_payment;
	
	//생성자
	public OrdersVo() {
		super();
	}


	public OrdersVo(int o_no, String o_name, String o_address, String o_hp, String o_request, int totalprice,
			String o_date, String o_status, String o_payment) {
		super();
		this.o_no = o_no;
		this.o_name = o_name;
		this.o_address = o_address;
		this.o_hp = o_hp;
		this.o_request = o_request;
		this.totalprice = totalprice;
		this.o_date = o_date;
		this.o_status = o_status;
		this.o_payment = o_payment;
	}


	//메소드 -g/s
	public int getO_no() {
		return o_no;
	}


	public void setO_no(int o_no) {
		this.o_no = o_no;
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
		return "OrdersVo [o_no=" + o_no + ", o_name=" + o_name + ", o_address=" + o_address + ", o_hp=" + o_hp
				+ ", o_request=" + o_request + ", totalprice=" + totalprice + ", o_date=" + o_date + ", o_status="
				+ o_status + ", o_payment=" + o_payment + "]";
	}
	
	
	
	
}

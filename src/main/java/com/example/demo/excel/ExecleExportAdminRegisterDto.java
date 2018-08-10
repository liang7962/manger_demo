package com.example.demo.excel;


import com.example.demo.util.excel.ExcelVOAttribute;

public class ExecleExportAdminRegisterDto implements java.io.Serializable{


	@ExcelVOAttribute(name = "商户ID", column = "A")
	private String accId;

	/*支付状态*/
	@ExcelVOAttribute(name = "手机号", column = "B")
	private String mobileNo;

	/*配送状态*/
	@ExcelVOAttribute(name = "创建时间", column = "C")
	private String ctime;

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	/*
	*/
/*订单状态*//*

	@ExcelVOAttribute(name = "订单状态", column = "D")
	private String orderStatusEx;

	*/
/*订单编号*//*

	@ExcelVOAttribute(name = "订单编号", column = "E")
	private String sn;

	*/
/*订单时间*//*

	@ExcelVOAttribute(name = "订单时间", column = "F")
	private String orderTime;

	*/
/*优惠券折扣*//*

	@ExcelVOAttribute(name = "机器ID", column = "G")
	private Long vendingMachine;


    @ExcelVOAttribute(name = "代理商名称", column = "H")
    private String agentName;

    @ExcelVOAttribute(name = "订单金额(元)", column = "I")
    private Double amountPaid;
*/




}


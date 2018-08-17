package com.example.demo.excel;


import com.example.demo.util.excel.ExcelVOAttribute;

public class ExecleExportAdminRegisterDto implements java.io.Serializable{

	@ExcelVOAttribute(name = "请求方法", column = "A")
	private String payMethod;

	@ExcelVOAttribute(name = "商户号", column = "B")
	private String merchantNo;

	@ExcelVOAttribute(name = "终端号", column = "C")
	private String terminalNo;

	@ExcelVOAttribute(name = "金额", column = "D")
	private String amount;

	@ExcelVOAttribute(name = "异步通知url", column = "E")
	private String notifyUrl;

	@ExcelVOAttribute(name = "描述", column = "F")
	private String descript;

	@ExcelVOAttribute(name = "商户ID", column = "G")
	private String mid;

	@ExcelVOAttribute(name = "tm标记", column = "H")
	private String tmstamp;

	@ExcelVOAttribute(name = "rTm标记", column = "I")
	private String rTmstamp;

	@ExcelVOAttribute(name = "nTm标记", column = "J")
	private String nTmstamp;

	@ExcelVOAttribute(name = "机构号", column = "K")
	private String institute;

	@ExcelVOAttribute(name = "请求订单号", column = "L")
	private String pjnl;

	@ExcelVOAttribute(name = "流水号", column = "M")
	private String bjnl;

	@ExcelVOAttribute(name = "应答code", column = "N")
	private String replyCode;

	@ExcelVOAttribute(name = "应答信息", column = "O")
	private String replyMessage;

	@ExcelVOAttribute(name = "交易状态", column = "P")
	private String tradeStatus;

	@ExcelVOAttribute(name = "其他1", column = "Q")
	private String remain1;

	@ExcelVOAttribute(name = "其他2", column = "R")
	private String remain2;

	@ExcelVOAttribute(name = "其他3", column = "S")
	private String remain3;

	@ExcelVOAttribute(name = "请求日期", column = "T")
	private String requestDate;

	@ExcelVOAttribute(name = "请求时间", column = "U")
	private String requestTime;

	@ExcelVOAttribute(name = "响应日期", column = "V")
	private String responseDate;

	@ExcelVOAttribute(name = "响应时间", column = "W")
	private String responseTime;

	@ExcelVOAttribute(name = "标识", column = "X")
	private String flag;

	@ExcelVOAttribute(name = "渠道", column = "Y")
	private String channel;

	@ExcelVOAttribute(name = "第三方订单号", column = "Z")
	private String origPjnl;


	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getTerminalNo() {
		return terminalNo;
	}

	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getTmstamp() {
		return tmstamp;
	}

	public void setTmstamp(String tmstamp) {
		this.tmstamp = tmstamp;
	}

	public String getrTmstamp() {
		return rTmstamp;
	}

	public void setrTmstamp(String rTmstamp) {
		this.rTmstamp = rTmstamp;
	}

	public String getnTmstamp() {
		return nTmstamp;
	}

	public void setnTmstamp(String nTmstamp) {
		this.nTmstamp = nTmstamp;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getPjnl() {
		return pjnl;
	}

	public void setPjnl(String pjnl) {
		this.pjnl = pjnl;
	}

	public String getBjnl() {
		return bjnl;
	}

	public void setBjnl(String bjnl) {
		this.bjnl = bjnl;
	}

	public String getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(String replyCode) {
		this.replyCode = replyCode;
	}

	public String getReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getRemain1() {
		return remain1;
	}

	public void setRemain1(String remain1) {
		this.remain1 = remain1;
	}

	public String getRemain2() {
		return remain2;
	}

	public void setRemain2(String remain2) {
		this.remain2 = remain2;
	}

	public String getRemain3() {
		return remain3;
	}

	public void setRemain3(String remain3) {
		this.remain3 = remain3;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getOrigPjnl() {
		return origPjnl;
	}

	public void setOrigPjnl(String origPjnl) {
		this.origPjnl = origPjnl;
	}
}


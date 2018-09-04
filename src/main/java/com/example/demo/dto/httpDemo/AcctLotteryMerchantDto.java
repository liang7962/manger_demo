package com.example.demo.dto.httpDemo;

public class AcctLotteryMerchantDto implements java.io.Serializable{

	//columns START
	/*账号*/
	private String accId;
	/* 手机号码 */
	private String mobileNo;
	/* 登录密码 */
	private String password;
	/* 角色 */
	private String role;
	/* 微信OPENID */
	private String wechatOpenId;
	/* 微信UNIONID */
	private String wechatUnionId;
	/* 状态 */
	private String status;
	/* 是否初始状态 0-否 1-是 */
	private String init;
	/*店主姓名*/
	private String shopKeeper;
	/*店铺名称*/
	private String shopName;
	/*店铺地址*/
	private String address;
	/*所属代理商编号*/
	private String agentNo;
	/*店主身份证号*/
	private String ident;
	/*结算账号*/
	private String accountNo;
	/*开户行名称*/
	private String bankName;
	/*开户支行名称*/
	private String subBankName;
	/*联行号*/
	private String subBankNo;
	/*换彩限额*/
	private String lotAmount;
	/*是否开通换彩业务*/
	private String lotFlag;
	/*创建时间*/
	private String ctime;
	/*更新时间*/
	private String utime;
	/*物料码编号*/
	private String uuid;


	//columns END

	public AcctLotteryMerchantDto(){
	}

	public AcctLotteryMerchantDto(
		String accId
	){
		this.accId = accId;
	}

	public void setAccId(String value) {
		this.accId = value;
	}
	
	public String getAccId() {
		return this.accId;
	}
	public void setShopKeeper(String value) {
		this.shopKeeper = value;
	}
	
	public String getShopKeeper() {
		return this.shopKeeper;
	}
	public void setShopName(String value) {
		this.shopName = value;
	}
	
	public String getShopName() {
		return this.shopName;
	}
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setAgentNo(String value) {
		this.agentNo = value;
	}
	
	public String getAgentNo() {
		return this.agentNo;
	}
	public void setIdent(String value) {
		this.ident = value;
	}
	
	public String getIdent() {
		return this.ident;
	}
	public void setAccountNo(String value) {
		this.accountNo = value;
	}
	
	public String getAccountNo() {
		return this.accountNo;
	}
	public void setBankName(String value) {
		this.bankName = value;
	}
	
	public String getBankName() {
		return this.bankName;
	}
	public void setSubBankName(String value) {
		this.subBankName = value;
	}
	
	public String getSubBankName() {
		return this.subBankName;
	}
	public void setSubBankNo(String value) {
		this.subBankNo = value;
	}
	
	public String getSubBankNo() {
		return this.subBankNo;
	}
	public void setLotAmount(String value) {
		this.lotAmount = value;
	}
	
	public String getLotAmount() {
		return this.lotAmount;
	}
	public void setLotFlag(String value) {
		this.lotFlag = value;
	}
	
	public String getLotFlag() {
		return this.lotFlag;
	}
	public void setCtime(String value) {
		this.ctime = value;
	}
	
	public String getCtime() {
		return this.ctime;
	}
	public void setUtime(String value) {
		this.utime = value;
	}
	
	public String getUtime() {
		return this.utime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getWechatOpenId() {
		return wechatOpenId;
	}

	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}

	public String getWechatUnionId() {
		return wechatUnionId;
	}

	public void setWechatUnionId(String wechatUnionId) {
		this.wechatUnionId = wechatUnionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

}


package ywt.entity;

import java.io.Serializable;
import java.util.List;


public class QueryAccountList implements Serializable{
//	{
//		"version":"1.0",
//		"charset":"UTF-8",
//		"sign":"见签名处理章节",
//		"signType":"SHA-256",
//		"reqData":
//		{
//		"dateTime":"20160825113210",
//		"branchNo":"0755",
//		"merchantNo":"000054",
//		"date":"20160116",
//		"operatorNo":"9999",
//		"nextKeyValue":""
//		}
//		}
	
	private String version;
	private String charset;
	private String sign;
	private String signTye;
	
	private ReqData reqData;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSignTye() {
		return signTye;
	}

	public void setSignTye(String signTye) {
		this.signTye = signTye;
	}

	public ReqData getReqData() {
		return reqData;
	}

	public void setReqData(ReqData reqData) {
		this.reqData = reqData;
	}
	
	
	
	
	

}

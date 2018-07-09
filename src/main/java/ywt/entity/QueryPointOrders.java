package ywt.entity;

public class QueryPointOrders {
	private String version;
	private String charset;
	private String sign;
	private String signTye;
	
	private ReqData2 reqData2;

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

	public ReqData2 getReqData2() {
		return reqData2;
	}

	public void setReqData2(ReqData2 reqData2) {
		this.reqData2 = reqData2;
	}
	
}

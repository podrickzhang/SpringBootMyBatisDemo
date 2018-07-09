package ywt.util;

public class YwtUrl {
	
	
	public static final String HOST = "http://121.15.180.66:801/";

	// 支付+签约
	public static final String URL_PREPAYEUSERP_D = "http://121.15.180.66:801/NetPayment/BaseHttp.dll?MB_EUserPay";

	// 按商户日期查询订单
	public static final String URL_QUERYORDERBYMERCHANTDATE = HOST + "NetPayment_dl/BaseHttp.dll?QuerySettledOrderByMerchantDate";
	// 查询入账明细
	public static final String URL_QUERYACCOUNTEDORDER = HOST + "NetPayment_dl/BaseHttp.dll?QueryAccountList";
	// 查询单笔订单
	public static final String URL_QUERYSINGLEORDER = HOST + "NetPayment_dl/BaseHttp.dll?QuerySingleOrder";
	// 退款
	public static final String URL_DOREFUND = HOST + "NetPayment_dl/BaseHttp.dll?DoRefund";

}

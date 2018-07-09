package ywt.service;

import java.util.Map;

import org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration;
import org.springframework.stereotype.Service;

import ywt.util.ReadCharsetProperties;
import ywt.util.YwtUrl;
import ywt.util.YwtUtil;

@Service
public class QueryPointOrdersService {
	public String query(Map<String,String> reqData){
		// 组装所有参数jsonReqParams
		YwtUtil ywtUtil = new YwtUtil();
		String jsonParams = ywtUtil.buildParam(reqData);
		String result = ywtUtil.uploadParam(jsonParams,YwtUrl.URL_QUERYACCOUNTEDORDER, new ReadCharsetProperties().charset);
		System.out.println("result=" + result);
		return result;
	}
}

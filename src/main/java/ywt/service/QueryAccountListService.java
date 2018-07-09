package ywt.service;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ywt.dao.QueryAccountListDao;
import ywt.entity.ReqData;
import ywt.util.PostParams;
import ywt.util.PostParamsCallable;
import ywt.util.YwtUrl;
import ywt.util.YwtUtil;

@Service
public class QueryAccountListService {
	
	@Autowired
	private QueryAccountListDao queryAccountListDao ;
	
	
	
	public String query(Map<String,String> reqData) throws Exception{
		// 组装所有参数jsonReqParams
		YwtUtil ywtUtil = new YwtUtil();
		String jsonParams = ywtUtil.buildParam(reqData);
		//实际一网通请求的路由
	//	String result = ywtUtil.uploadParam(jsonParams,YwtUrl.URL_QUERYACCOUNTEDORDER, YwtCharset.CHARSET);
		
		//测试代码
		//PostParams params=new PostParams();
	
		
		//查询访问的url
		String platform="一网通";
	//	String remark="查询入账明细";
		String remark="本机localhost";
		String url=queryAccountListDao.findUrl(platform, remark);
		System.out.println("url="+url);
		
		//这里使用future接口，来接受异步返回的结果
		 ExecutorService exec = Executors.newCachedThreadPool();  
	        // Future是一个接口，该接口用来返回异步的结果。  
	     Future<String> st = exec.submit(new PostParamsCallable(jsonParams,url));  
		
		
		//--------------------------------------------------------------------
//		String result=params.postParams(jsonParams,url);
//		System.out.println("reString="+result);
	     
	     String result=st.get(1000000,TimeUnit.MILLISECONDS);
		System.out.println("异步返回的result="+result);
		return result;
	}
}

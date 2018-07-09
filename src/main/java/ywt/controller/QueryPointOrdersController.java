package ywt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ywt.entity.QueryAccountList;
import ywt.entity.QueryPointOrders;
import ywt.entity.ReqData;
import ywt.entity.ReqData2;
import ywt.service.QueryPointOrdersService;

@Controller
@RequestMapping("/QueryPointOrdersByBankDate")
public class QueryPointOrdersController {
	
	@Autowired
	private QueryPointOrdersService queryPointOrdersService;
	
	/**
	 * 按入账日期批量积分查询
	 * @param queryAccountList
	 */
	@RequestMapping("/query")
	public void queryPointOrdersByBankDate(@RequestBody QueryPointOrders queryPointOrders){
		ReqData2 reqData2=queryPointOrders.getReqData2();
		//组装reqdata
		Map<String,String> reqData=new HashMap<String,String>();
		reqData.put("dateTime", reqData2.getDateTime());
		reqData.put("branchNo", reqData2.getBranchNo());
		reqData.put("merchantNo",reqData2.getMerchantNo());
		reqData.put("date", reqData2.getBeginDate());
		reqData.put("operatorNo",reqData2.getEndDate());
		reqData.put("nextKeyValue", reqData2.getNextKeyValue());
		
		String result=queryPointOrdersService.query(reqData);
		System.out.println("result="+result);
	}
	
	
}

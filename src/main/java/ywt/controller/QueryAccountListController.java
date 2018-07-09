package ywt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ywt.entity.QueryAccountList;
import ywt.entity.ReqData;
import ywt.service.QueryAccountListService;

@Controller
@RequestMapping("/QueryAccountList")
public class QueryAccountListController {

	@Autowired
	private QueryAccountListService queryAccountListService;
	
	/**
	 * 查询入账明细
	 * @param queryAccountList
	 */
	@RequestMapping("/query")
	@ResponseBody
	public void queryAccountList(@RequestBody QueryAccountList queryAccountList) throws Exception{
		System.out.println("nihao");
		String version=queryAccountList.getVersion();
		System.out.println(version);
		ReqData reqData1=queryAccountList.getReqData();
		String date=reqData1.getDate();
		System.out.println(date);
		
		//组装reqdata
		Map<String,String> reqData=new HashMap<String,String>();
		reqData.put("dateTime", reqData1.getDateTime());
		reqData.put("branchNo", reqData1.getBranchNo());
		reqData.put("merchantNo",reqData1.getMerchantNo());
		reqData.put("date", reqData1.getDate());
		reqData.put("operatorNo",reqData1.getOperatorNo());
		reqData.put("nextKeyValue", reqData1.getNextKeyValue());
		
		String result=queryAccountListService.query(reqData);
		System.out.println("result="+result);
		

		
	}

}

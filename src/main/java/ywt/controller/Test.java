package ywt.controller;


import java.util.*;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ywt.entity.DataList9;
import ywt.entity.QueryAccountList;
import ywt.entity.ReqData;
import ywt.service.TestService;



@Controller
@RequestMapping("/ywt")
public class Test extends HttpServlet{
	
	@Autowired
	private TestService testService;
	
	
	
	@RequestMapping("/a")
	public void update(){
		System.out.println("aaaaa");
	}
	
	@RequestMapping("/test/{id}")
	public void find(@PathVariable int id){
		System.out.println("id="+id);
	}
	
	@RequestMapping("/b")
	@ResponseBody
	public void delete(@RequestBody QueryAccountList queryAccountList){
		System.out.println("nihao");
		String version=queryAccountList.getVersion();
		System.out.println(version);
		ReqData reqData=queryAccountList.getReqData();
		String date=reqData.getDate();
		System.out.println(date);
	}
	
	
	
	@RequestMapping("/c")
	public void findMap(){
		List<DataList9> map=testService.findData();
		System.out.println(map.get(0));
		System.out.println("map="+map);
	}
}

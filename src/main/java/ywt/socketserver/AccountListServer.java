package ywt.socketserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.JSONException;
import org.junit.experimental.theories.Theories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;
import ywt.dao.MapTestDao;
import ywt.dao.QueryAccountListDao;
import ywt.entity.DataList9;
import ywt.util.ReadCharsetProperties;
import ywt.util.SecretKey;
import ywt.util.Signature;


@Component
public class AccountListServer {

	@Autowired
	private QueryAccountListDao queryAccountListDao;
	
	@Autowired
	private MapTestDao mapTestDao;
	
	private static AccountListServer accountListServer;
	

	
	
	public void init() {
		System.out.println("实例化成功");
		accountListServer = this;
		accountListServer.mapTestDao = this.mapTestDao;

		List<DataList9> list1 = accountListServer.mapTestDao.findData();
		System.out.println("list(0)==" + list1.get(0));
	}
	

	 
	 
	public static void main(String[] args) {
	//	List<DataList9> list2=list;
	//	System.out.println(list2);//这里为null
	//	System.out.println("main list="+new AccountListServer().getList());
		try {
			  ServerSocket serverSocket = new ServerSocket(8885);
	          System.out.println("启动服务器....");
	          Socket socket = serverSocket.accept();


	            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            //读取客户端发送来的消息
	            String mess = br.readLine();
	            System.out.println("我收到了客户端的东西"+mess);
	            JSONObject object = JSONObject.fromObject(mess);
	            //已接收到客戶端发来的内容，下面进行处理
	            String dateTime1=(String)((JSONObject)object.get("reqData")).get("dateTime");	
	            System.out.println("dateTime="+dateTime1);
	            
	            //从数据库中读取一条记录
	            //从前面的init中已经读取到了ywtaccountlist表中的数据
	        	JSONObject jsonParam = new JSONObject();
	    		
	    		jsonParam.put("version", "1.0");
	    		jsonParam.put("charset", new ReadCharsetProperties().charset);// 支持GBK和UTF-8两种编码
	    		Signature signature=new Signature();
	    		jsonParam.put("signType", "SHA-256");
	    		jsonParam.put("reqData", jsonParam);
	    		//为什么这里会报空指针
	  //  		System.out.println("list(0)="+list.get(0));
	    //		jsonParam.put("reqData", list.get(0));
	    		
	    			
	            
	    	/*
	           String dateTime=new Date().toString();
	           String dataCount="2";
	           String jsonRsp="{\"version\":\"1.0\",\"charset\":\"UTF-8\",\"rspData\":{\"rspCode\":\"SUC0000\",\"rspMsg\":\"\",\"dataTime\":\""
	           +dateTime+"\"hashNext\":\"N\",\"nextKeyValue\":\"20160116411351816272000000008\",\""+dataCount+"\",\"dataList\":\"branchNo,`merchantNo,`date,`orderNo,`bankSerialNo,`currency,`transType,`orderAmount,`settleAmount,`discountAmount,`fee,`transDate,`transTime,`bankDate,`bankTime,`cardType,`merchantPara "
	           		+ " 0755,`000054,`20160721,`9999000125,`16272100600000000010,`10,`S,`21.00,`17.46,`3.54,`1.75,`20160721,`084259,`20160116,`084259,`02,` "
	           		+ "0755,`000054,`20160720,`9999000501,`16272085700000000010,`10,`S,`0.01,`0.01,`0.00,`0.00,`20160720,`173045,`20160116,`173045,`07,`para1\"}}";
	           
	        */    
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	            
	          //  bw.write(jsonRsp+"\n");
	            bw.write(jsonParam.toString()+"\n");
	            bw.flush();
	            
	            
			bw.close();
			br.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

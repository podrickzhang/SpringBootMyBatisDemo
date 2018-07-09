package ywt.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import net.sf.json.JSONObject;

public class PostParams {
	//使用socket来传输json
	public String postParams(String jsonParams,String url){
		
	        try {
	        	// Socket s = new Socket("127.0.0.1",8885);
	        	Socket s=new Socket(url,8885);

	             //构建IO
	             InputStream is = s.getInputStream();
	             OutputStream os = s.getOutputStream();

	             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
	      
	             //向服务器端发送一条消息
	             bw.write(jsonParams+"\n");
	             bw.flush();

	             //读取服务器返回的消息
	             BufferedReader br = new BufferedReader(new InputStreamReader(is));
	             String mess = br.readLine();
	             System.out.println("服务器发来的消息："+mess);
	             return mess;
	        } catch (Exception e) {
	        	return "error";
	        }
	    
	}
}

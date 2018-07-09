package ywt.socketserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import net.sf.json.JSONObject;



public class Server {
	
	public static void main(String[] args) {
	
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
	            String dateTime=(String)((JSONObject)object.get("reqData")).get("dateTime");	
	            System.out.println("dateTime="+dateTime);
	            
	            String jsonRsp="{\"version\":\"1.0\",\"charset\":\"UTF-8\",\"rspData\":{\"rspCode\":\"MSS3107\",\"rspMsg\":\"PAY3107,无效的键值\"}}";
	            
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

	            bw.write(jsonRsp+"\n");
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

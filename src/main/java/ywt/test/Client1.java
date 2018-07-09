package ywt.test;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.net.Socket;

import net.sf.json.JSONObject;
import ywt.entity.User;

public class Client1 {
	 public static void main(String[] args){
	        OutputStream osw;
	        BufferedWriter rw;

	        try{
	            Socket socket = new Socket("localhost", 4443);
	            osw = socket.getOutputStream();

	            User user = new User();

	            user.setName("张超帅");
	            user.setPassword("123456");

	            JSONObject jsonObject = JSONObject.fromObject(user);
	            osw.write(jsonObject.toString().getBytes());
	            System.out.println("客户端我发送完了");

//	            InputStream is = socket.getInputStream();
//	            byte[] buffer=new byte[1024];
//	            int len=-1;
//	            len=is.read(buffer);
//	            String getData=new String(buffer, 0, len);
//	            System.out.println("从服务端获取的数据:"+getData);
//	            is.close();


	           osw.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
}

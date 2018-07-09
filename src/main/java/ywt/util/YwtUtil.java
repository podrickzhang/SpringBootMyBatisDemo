package ywt.util;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;


public class YwtUtil {
	
	/**
	 * 发送POST请求
	 */
	public  String uploadParam(String jsonParam, String url, String charset) {
		System.out.println("URL:　" + url);
		System.out.println(jsonParam);
		OutputStreamWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try {
			URL httpUrl = new URL(url);
			HttpURLConnection urlCon = (HttpURLConnection) httpUrl.openConnection();
			urlCon.setRequestMethod("POST");
			urlCon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			urlCon.setDoOutput(true);
			urlCon.setDoInput(true);
			urlCon.setReadTimeout(5 * 1000);
			out = new OutputStreamWriter(urlCon.getOutputStream(), charset);// 指定编码格式
			out.write("jsonRequestData=" + jsonParam);
			out.flush();
			
			
			in = new BufferedReader(new InputStreamReader(urlCon.getInputStream(), charset));
			String str = null;
			while ((str = in.readLine()) != null) {
				result.append(str);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result.toString();
	}
	
	
	/**
	 * 返回json参数
	 */
	public  String buildParam(Map<String, String> reqDataMap) {
		JSONObject jsonParam = new JSONObject();
		try {
			jsonParam.put("version", "1.0");
			jsonParam.put("charset", new ReadCharsetProperties().charset);// 支持GBK和UTF-8两种编码
			Signature signature=new Signature();
			
			jsonParam.put("sign", signature.sign(reqDataMap, SecretKey.SECRET_KEY));
			jsonParam.put("signType", "SHA-256");
			jsonParam.put("reqData", reqDataMap);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonParam.toString();
	}

	
}

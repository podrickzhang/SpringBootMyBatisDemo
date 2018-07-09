package ywt.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Signature {

	public  String sign(String reqDataJSON, String secretKey, String charset) {
		StringBuffer buffer = new StringBuffer();

		try {
			JSONObject json = new JSONObject(reqDataJSON);
			SortParams sort=new SortParams();
			List<String> keyList = sort.sortParams(json);
			for (String key : keyList) {
				buffer.append(key).append("=").append(json.get(key)).append("&");
			}
			buffer.append(secretKey);// 商户密钥
			System.out.println(buffer.toString());
			// 创建加密对象
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			// 传入要加密的字符串,按指定的字符集将字符串转换为字节流
			messageDigest.update(buffer.toString().getBytes(charset));
			byte byteBuffer[] = messageDigest.digest();

			// 將 byte转换为16进制string
			StringBuffer strHexString = new StringBuffer();
			for (int i = 0; i < byteBuffer.length; i++) {
				String hex = Integer.toHexString(0xff & byteBuffer[i]);
				if (hex.length() == 1) {
					strHexString.append('0');
				}
				strHexString.append(hex);
			}
			return strHexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 对参数签名：
	 * 对reqData所有请求参数按从a到z的字典顺序排列，如果首字母相同，按第二个字母排列，以此类推。排序完成后按将所有键值对以“&”符号拼接。
	 * 拼接完成后再加上商户密钥。示例：param1=value1&param2=value2&...&paramN=valueN&secretKey
	 * 
	 * @param reqDataMap
	 *            请求参数
	 * @param secretKey
	 *            商户密钥
	 */
	public  String sign(Map<String, String> reqDataMap, String secretKey) {
		StringBuffer buffer = new StringBuffer();
		
		SortParams sort=new SortParams();
		List<String> keyList = sort.sortParams(reqDataMap);
		for (String key : keyList) {
			buffer.append(key).append("=").append(reqDataMap.get(key)).append("&");
		}
		buffer.append(secretKey);// 商户密钥
		System.out.println(buffer.toString());

		try {
			// 创建加密对象
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			// 传入要加密的字符串,按指定的字符集将字符串转换为字节流
			messageDigest.update(buffer.toString().getBytes(new ReadCharsetProperties().charset));
			byte byteBuffer[] = messageDigest.digest();

			// 將 byte转换为16进制string
			StringBuffer strHexString = new StringBuffer();
			for (int i = 0; i < byteBuffer.length; i++) {
				String hex = Integer.toHexString(0xff & byteBuffer[i]);
				if (hex.length() == 1) {
					strHexString.append('0');
				}
				strHexString.append(hex);
			}
			return strHexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}

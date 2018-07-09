package ywt.test;

import ywt.util.ReadCharsetProperties;

public class PropertiesTest {

	public static void main(String[] args) {
		ReadCharsetProperties charsetProperties=new ReadCharsetProperties();
		String charset=charsetProperties.charset;
		System.out.print("charset="+charset);
	}

}

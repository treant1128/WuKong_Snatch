package com.wukong.snatch.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.faces.application.Application;

public class Utils {
	
	public static String[] loadLocalOPML() {
		final String FLAG="!!!!!!!!!!";
		StringBuffer sb=null;
		try {
			String rootPath=getRootPath();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File(rootPath))));
			String line="";
			sb=new StringBuffer();
			while((line=br.readLine())!=null){
				sb.append(line+FLAG);	
			}
			
			line=sb.substring(0, sb.length()-FLAG.length()).toString();  
			if(line.contains(FLAG)){
				return line.split(FLAG);  
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * OPML文件路径放在项目根目录下,不同的路径以字符串"#$%^"相隔
	 * @return
	 */
	public static String getRootPath() {
		// 因为类名为"Application"，因此" Application.class"一定能找到
		String result = Application.class.getResource("Application.class")
				.toString();
		int index = result.indexOf("WEB-INF");
		if (index == -1) {
			index = result.indexOf("bin");
		}
		result = result.substring(0, index);
		if (result.startsWith("jar")) {
			// 当class文件在jar文件中时，返回"jar:file:/F:/ ..."样的路径
			result = result.substring(10);
		} else if (result.startsWith("file")) {
			// 当class文件在class文件中时，返回"file:/F:/ ..."样的路径
			result = result.substring(6);
		}
		if (result.endsWith("/"))
			result = result.substring(0, result.length() - 1);// 不包含最后的"/"
		return result+File.separator+"opml_urls.txt";
	}
}

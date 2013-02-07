package com.wukong.snatch.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;

import com.sun.syndication.feed.opml.Opml;
import com.sun.syndication.feed.opml.Outline;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.WireFeedInput;

public class OPMLParser {

	@SuppressWarnings("unchecked")
	public static List<com.wukong.snatch.pojo.Opml> getOPMLList(String urlPath){
		List<com.wukong.snatch.pojo.Opml> list=null;
		URL url=null;
		try {
			url=new URL(urlPath);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URLConnection conn=null;
		try {
			conn=url.openConnection();
			conn.setRequestProperty(
                    "User-Agent",
            "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.3) Gecko/20100401 Firefox/3.6.3");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WireFeedInput input =new WireFeedInput();
		Opml feed=null;
		try {
			feed=(Opml) input.build(new InputSource(conn.getInputStream()));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Outline> outlines=((Outline)feed.getOutlines().get(0)).getChildren();
		com.wukong.snatch.pojo.Opml opml=null;
		list=new ArrayList<com.wukong.snatch.pojo.Opml>();
		for(Outline o:outlines){
			opml=new com.wukong.snatch.pojo.Opml();
			opml.setOpmlHeadTitle(o.getText());
			opml.setOpmlOutlineTitle(o.getTitle());
			opml.setOpmlOutlineXmlUrl(o.getXmlUrl());
			opml.setOpmlOutlineHtmlUrl(o.getHtmlUrl());
			list.add(opml);
		}
		return list;
	}
}

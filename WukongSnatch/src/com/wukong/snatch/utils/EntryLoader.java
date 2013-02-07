package com.wukong.snatch.utils;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.wukong.snatch.pojo.Entry;


public class EntryLoader {

	public static List<Entry> getEntryList(String urlPath){
		List<Entry> list=new ArrayList<Entry>();
		try{
		URL url = new URL(urlPath);
		HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
		// Reading the feed
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		List<SyndEntry> entries = feed.getEntries();
		Iterator<SyndEntry> itEntries = entries.iterator();
		SyndEntry entry=null;
		while (itEntries.hasNext()) {
			entry = itEntries.next();
//			System.out.println("Title: " + entry.getTitle());
//			System.out.println("Link: " + entry.getLink());
//			System.out.println("Author: " + entry.getAuthor());
//			System.out.println("Publish Date: " + entry.getPublishedDate());
//			System.out.println("Description: " + entry.getDescription().getValue());
//			System.out.println();
			Entry e=new Entry();
		
			e.setEntryTitle(entry.getTitle());
			e.setEntryLink(entry.getLink()); 
			e.setEntryAuthor(entry.getAuthor());
//			e.setEntryCategory(entry.getCategories().get(0).toString());
			e.setEntryPubDate(new Timestamp(entry.getPublishedDate().getTime()));
			e.setEntryDescription(entry.getDescription().getValue());
			list.add(e);
		}
		
	}catch(Exception e){}
		return list;
	}
}

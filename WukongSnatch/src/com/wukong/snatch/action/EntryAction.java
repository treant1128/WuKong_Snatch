package com.wukong.snatch.action;

import java.util.List;

import javax.faces.application.Application;

import com.opensymphony.xwork2.ActionSupport;
import com.wukong.snatch.dao.EntryDAO;
import com.wukong.snatch.dao.OpmlDAO;
import com.wukong.snatch.pojo.Entry;
import com.wukong.snatch.pojo.Opml;
import com.wukong.snatch.utils.EntryLoader;
import com.wukong.snatch.utils.Utils;

public class EntryAction extends ActionSupport {
	
	private Entry entry;

	public Entry getEntry() {
		return this.entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public String toSnatch(){
		EntryDAO dao=new EntryDAO();
		List allXmlUrl=new OpmlDAO().findAll();
		
	//	System.out.println("RootPath=="+Utils.getRootPath());
		for(com.wukong.snatch.pojo.Opml o:(List<Opml>)allXmlUrl){
			List<Entry> list=EntryLoader.getEntryList(o.getOpmlOutlineXmlUrl());
//			System.out.println("@@@@@@@@@@@@@@@@@@=="+o.getOpmlOutlineXmlUrl());
			for(Entry entry:list){
				dao.save(entry);
			}
		}
		return SUCCESS;
	}
}

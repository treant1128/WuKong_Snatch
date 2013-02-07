package com.wukong.snatch.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wukong.snatch.dao.OpmlDAO;
import com.wukong.snatch.utils.OPMLParser;
import com.wukong.snatch.utils.Utils;

public class OPMLAction extends ActionSupport {

	public String toSnatch() {
		String[] opml_urls = Utils.loadLocalOPML();
		for (int i = 0; i < opml_urls.length; i++) {
			List<com.wukong.snatch.pojo.Opml> list = OPMLParser
					.getOPMLList(opml_urls[i]);
			OpmlDAO dao = new OpmlDAO();
			for (com.wukong.snatch.pojo.Opml o : list) {
				dao.save(o);
			}
		}
		return SUCCESS;
	}
}

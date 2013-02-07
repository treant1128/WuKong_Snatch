package com.wukong.snatch.pojo;

import java.util.Set;

import com.wukong.snatch.abstractbean.AbstractOpml;

/**
 * Opml entity. @author MyEclipse Persistence Tools
 */
public class Opml extends AbstractOpml implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Opml() {
	}

	/** minimal constructor */
	public Opml(String opmlHeadTitle, String opmlOutlineTitle,
			String opmlOutlineXmlUrl) {
		super(opmlHeadTitle, opmlOutlineTitle, opmlOutlineXmlUrl);
	}

	/** full constructor */
	public Opml(Channel channel, String opmlHeadTitle, String opmlBodyTitle,
			String opmlBodyText, String opmlOutlineText,
			String opmlOutlineTitle, String opmlOutlineType,
			String opmlOutlineXmlUrl, String opmlOutlineHtmlUrl, Set entries) {
		super(channel, opmlHeadTitle, opmlBodyTitle, opmlBodyText,
				opmlOutlineText, opmlOutlineTitle, opmlOutlineType,
				opmlOutlineXmlUrl, opmlOutlineHtmlUrl, entries);
	}

}

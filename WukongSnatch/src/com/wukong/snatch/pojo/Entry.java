package com.wukong.snatch.pojo;

import java.sql.Timestamp;

import com.wukong.snatch.abstractbean.AbstractEntry;

/**
 * Entry entity. @author MyEclipse Persistence Tools
 */
public class Entry extends AbstractEntry implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Entry() {
	}

	/** minimal constructor */
	public Entry(String entryTitle, String entryLink, Timestamp entryPubDate) {
		super(entryTitle, entryLink, entryPubDate);
	}

	/** full constructor */
	public Entry(Opml opml, String entryTitle, String entryLink,
			String entrySource, String entryAuthor, String entryGuid,
			String entryCategory, Timestamp entryPubDate, String entryComments,
			String entryDescription) {
		super(opml, entryTitle, entryLink, entrySource, entryAuthor, entryGuid,
				entryCategory, entryPubDate, entryComments, entryDescription);
	}

}

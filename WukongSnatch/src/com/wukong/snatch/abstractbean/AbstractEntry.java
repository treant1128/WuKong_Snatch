package com.wukong.snatch.abstractbean;

import java.sql.Timestamp;

import com.wukong.snatch.pojo.Opml;

/**
 * AbstractEntry entity provides the base persistence definition of the Entry
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractEntry implements java.io.Serializable {

	// Fields

	private Integer entryId;
	private Opml opml;
	private String entryTitle;
	private String entryLink;
	private String entrySource;
	private String entryAuthor;
	private String entryGuid;
	private String entryCategory;
	private Timestamp entryPubDate;
	private String entryComments;
	private String entryDescription;

	// Constructors

	/** default constructor */
	public AbstractEntry() {
	}

	/** minimal constructor */
	public AbstractEntry(String entryTitle, String entryLink,
			Timestamp entryPubDate) {
		this.entryTitle = entryTitle;
		this.entryLink = entryLink;
		this.entryPubDate = entryPubDate;
	}

	/** full constructor */
	public AbstractEntry(Opml opml, String entryTitle, String entryLink,
			String entrySource, String entryAuthor, String entryGuid,
			String entryCategory, Timestamp entryPubDate, String entryComments,
			String entryDescription) {
		this.opml = opml;
		this.entryTitle = entryTitle;
		this.entryLink = entryLink;
		this.entrySource = entrySource;
		this.entryAuthor = entryAuthor;
		this.entryGuid = entryGuid;
		this.entryCategory = entryCategory;
		this.entryPubDate = entryPubDate;
		this.entryComments = entryComments;
		this.entryDescription = entryDescription;
	}

	// Property accessors

	public Integer getEntryId() {
		return this.entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public Opml getOpml() {
		return this.opml;
	}

	public void setOpml(Opml opml) {
		this.opml = opml;
	}

	public String getEntryTitle() {
		return this.entryTitle;
	}

	public void setEntryTitle(String entryTitle) {
		this.entryTitle = entryTitle;
	}

	public String getEntryLink() {
		return this.entryLink;
	}

	public void setEntryLink(String entryLink) {
		this.entryLink = entryLink;
	}

	public String getEntrySource() {
		return this.entrySource;
	}

	public void setEntrySource(String entrySource) {
		this.entrySource = entrySource;
	}

	public String getEntryAuthor() {
		return this.entryAuthor;
	}

	public void setEntryAuthor(String entryAuthor) {
		this.entryAuthor = entryAuthor;
	}

	public String getEntryGuid() {
		return this.entryGuid;
	}

	public void setEntryGuid(String entryGuid) {
		this.entryGuid = entryGuid;
	}

	public String getEntryCategory() {
		return this.entryCategory;
	}

	public void setEntryCategory(String entryCategory) {
		this.entryCategory = entryCategory;
	}

	public Timestamp getEntryPubDate() {
		return this.entryPubDate;
	}

	public void setEntryPubDate(Timestamp entryPubDate) {
		this.entryPubDate = entryPubDate;
	}

	public String getEntryComments() {
		return this.entryComments;
	}

	public void setEntryComments(String entryComments) {
		this.entryComments = entryComments;
	}

	public String getEntryDescription() {
		return this.entryDescription;
	}

	public void setEntryDescription(String entryDescription) {
		this.entryDescription = entryDescription;
	}

}
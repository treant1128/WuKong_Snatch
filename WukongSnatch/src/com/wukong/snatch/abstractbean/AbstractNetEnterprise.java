package com.wukong.snatch.abstractbean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractNetEnterprise entity provides the base persistence definition of the
 * NetEnterprise entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNetEnterprise implements java.io.Serializable {

	// Fields

	private Integer netEpId;
	private String netEpName;
	private String netEpUrl;
	private Set channels = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractNetEnterprise() {
	}

	/** minimal constructor */
	public AbstractNetEnterprise(String netEpName, String netEpUrl) {
		this.netEpName = netEpName;
		this.netEpUrl = netEpUrl;
	}

	/** full constructor */
	public AbstractNetEnterprise(String netEpName, String netEpUrl, Set channels) {
		this.netEpName = netEpName;
		this.netEpUrl = netEpUrl;
		this.channels = channels;
	}

	// Property accessors

	public Integer getNetEpId() {
		return this.netEpId;
	}

	public void setNetEpId(Integer netEpId) {
		this.netEpId = netEpId;
	}

	public String getNetEpName() {
		return this.netEpName;
	}

	public void setNetEpName(String netEpName) {
		this.netEpName = netEpName;
	}

	public String getNetEpUrl() {
		return this.netEpUrl;
	}

	public void setNetEpUrl(String netEpUrl) {
		this.netEpUrl = netEpUrl;
	}

	public Set getChannels() {
		return this.channels;
	}

	public void setChannels(Set channels) {
		this.channels = channels;
	}

}
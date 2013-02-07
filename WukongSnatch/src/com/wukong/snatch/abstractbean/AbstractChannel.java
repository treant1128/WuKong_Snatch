package com.wukong.snatch.abstractbean;

import java.util.HashSet;
import java.util.Set;

import com.wukong.snatch.pojo.NetEnterprise;

/**
 * AbstractChannel entity provides the base persistence definition of the
 * Channel entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractChannel implements java.io.Serializable {

	// Fields

	private Integer channelId;
	private NetEnterprise netEnterprise;
	private String channelName;
	private String channelUrl;
	private Set opmls = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractChannel() {
	}

	/** minimal constructor */
	public AbstractChannel(String channelName, String channelUrl) {
		this.channelName = channelName;
		this.channelUrl = channelUrl;
	}

	/** full constructor */
	public AbstractChannel(NetEnterprise netEnterprise, String channelName,
			String channelUrl, Set opmls) {
		this.netEnterprise = netEnterprise;
		this.channelName = channelName;
		this.channelUrl = channelUrl;
		this.opmls = opmls;
	}

	// Property accessors

	public Integer getChannelId() {
		return this.channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public NetEnterprise getNetEnterprise() {
		return this.netEnterprise;
	}

	public void setNetEnterprise(NetEnterprise netEnterprise) {
		this.netEnterprise = netEnterprise;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelUrl() {
		return this.channelUrl;
	}

	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
	}

	public Set getOpmls() {
		return this.opmls;
	}

	public void setOpmls(Set opmls) {
		this.opmls = opmls;
	}

}
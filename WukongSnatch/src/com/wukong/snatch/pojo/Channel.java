package com.wukong.snatch.pojo;

import java.util.Set;

import com.wukong.snatch.abstractbean.AbstractChannel;

/**
 * Channel entity. @author MyEclipse Persistence Tools
 */
public class Channel extends AbstractChannel implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Channel() {
	}

	/** minimal constructor */
	public Channel(String channelName, String channelUrl) {
		super(channelName, channelUrl);
	}

	/** full constructor */
	public Channel(NetEnterprise netEnterprise, String channelName,
			String channelUrl, Set opmls) {
		super(netEnterprise, channelName, channelUrl, opmls);
	}

}

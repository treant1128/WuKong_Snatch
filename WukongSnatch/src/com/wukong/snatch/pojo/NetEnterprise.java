package com.wukong.snatch.pojo;

import java.util.Set;

import com.wukong.snatch.abstractbean.AbstractNetEnterprise;

/**
 * NetEnterprise entity. @author MyEclipse Persistence Tools
 */
public class NetEnterprise extends AbstractNetEnterprise implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public NetEnterprise() {
	}

	/** minimal constructor */
	public NetEnterprise(String netEpName, String netEpUrl) {
		super(netEpName, netEpUrl);
	}

	/** full constructor */
	public NetEnterprise(String netEpName, String netEpUrl, Set channels) {
		super(netEpName, netEpUrl, channels);
	}

}

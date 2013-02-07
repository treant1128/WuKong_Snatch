package com.wukong.snatch.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wukong.snatch.pojo.NetEnterprise;

/**
 * A data access object (DAO) providing persistence and search support for
 * NetEnterprise entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wukong.snatch.pojo.NetEnterprise
 * @author MyEclipse Persistence Tools
 */

public class NetEnterpriseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(NetEnterpriseDAO.class);
	// property constants
	public static final String NET_EP_NAME = "netEpName";
	public static final String NET_EP_URL = "netEpUrl";

	public void save(NetEnterprise transientInstance) {
		log.debug("saving NetEnterprise instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NetEnterprise persistentInstance) {
		log.debug("deleting NetEnterprise instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NetEnterprise findById(java.lang.Integer id) {
		log.debug("getting NetEnterprise instance with id: " + id);
		try {
			NetEnterprise instance = (NetEnterprise) getSession().get(
					"com.wukong.snatch.pojo.NetEnterprise", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NetEnterprise instance) {
		log.debug("finding NetEnterprise instance by example");
		try {
			List results = getSession().createCriteria(
					"com.wukong.snatch.pojo.NetEnterprise").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding NetEnterprise instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from NetEnterprise as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNetEpName(Object netEpName) {
		return findByProperty(NET_EP_NAME, netEpName);
	}

	public List findByNetEpUrl(Object netEpUrl) {
		return findByProperty(NET_EP_URL, netEpUrl);
	}

	public List findAll() {
		log.debug("finding all NetEnterprise instances");
		try {
			String queryString = "from NetEnterprise";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NetEnterprise merge(NetEnterprise detachedInstance) {
		log.debug("merging NetEnterprise instance");
		try {
			NetEnterprise result = (NetEnterprise) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NetEnterprise instance) {
		log.debug("attaching dirty NetEnterprise instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NetEnterprise instance) {
		log.debug("attaching clean NetEnterprise instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
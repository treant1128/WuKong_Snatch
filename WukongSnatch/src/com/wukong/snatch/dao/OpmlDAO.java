package com.wukong.snatch.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wukong.snatch.pojo.Opml;

/**
 * A data access object (DAO) providing persistence and search support for Opml
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wukong.snatch.pojo.Opml
 * @author MyEclipse Persistence Tools
 */

public class OpmlDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OpmlDAO.class);
	// property constants
	public static final String OPML_HEAD_TITLE = "opmlHeadTitle";
	public static final String OPML_BODY_TITLE = "opmlBodyTitle";
	public static final String OPML_BODY_TEXT = "opmlBodyText";
	public static final String OPML_OUTLINE_TEXT = "opmlOutlineText";
	public static final String OPML_OUTLINE_TITLE = "opmlOutlineTitle";
	public static final String OPML_OUTLINE_TYPE = "opmlOutlineType";
	public static final String OPML_OUTLINE_XML_URL = "opmlOutlineXmlUrl";
	public static final String OPML_OUTLINE_HTML_URL = "opmlOutlineHtmlUrl";

//	public void save(Opml transientInstance) {
//		log.debug("saving Opml instance");
//		try {
//			getSession().save(transientInstance);
//			log.debug("save successful");
//		} catch (RuntimeException re) {
//			log.error("save failed", re);
//			throw re;
//		}
//	}

	public void save(Opml transientInstance){
		Session session=getSession();
		Transaction tran=null;
		try{
			tran=session.beginTransaction();
			session.save(transientInstance);
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public List findAllXmlUrl(){
		String hql="select "+OPML_OUTLINE_XML_URL+" from opml";
		Session session=getSession();
		Query query=session.createQuery(hql);
		return query.list();
	}
	public void delete(Opml persistentInstance) {
		log.debug("deleting Opml instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Opml findById(java.lang.Integer id) {
		log.debug("getting Opml instance with id: " + id);
		try {
			Opml instance = (Opml) getSession().get(
					"com.wukong.snatch.pojo.Opml", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Opml instance) {
		log.debug("finding Opml instance by example");
		try {
			List results = getSession().createCriteria(
					"com.wukong.snatch.pojo.Opml")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Opml instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Opml as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOpmlHeadTitle(Object opmlHeadTitle) {
		return findByProperty(OPML_HEAD_TITLE, opmlHeadTitle);
	}

	public List findByOpmlBodyTitle(Object opmlBodyTitle) {
		return findByProperty(OPML_BODY_TITLE, opmlBodyTitle);
	}

	public List findByOpmlBodyText(Object opmlBodyText) {
		return findByProperty(OPML_BODY_TEXT, opmlBodyText);
	}

	public List findByOpmlOutlineText(Object opmlOutlineText) {
		return findByProperty(OPML_OUTLINE_TEXT, opmlOutlineText);
	}

	public List findByOpmlOutlineTitle(Object opmlOutlineTitle) {
		return findByProperty(OPML_OUTLINE_TITLE, opmlOutlineTitle);
	}

	public List findByOpmlOutlineType(Object opmlOutlineType) {
		return findByProperty(OPML_OUTLINE_TYPE, opmlOutlineType);
	}

	public List findByOpmlOutlineXmlUrl(Object opmlOutlineXmlUrl) {
		return findByProperty(OPML_OUTLINE_XML_URL, opmlOutlineXmlUrl);
	}

	public List findByOpmlOutlineHtmlUrl(Object opmlOutlineHtmlUrl) {
		return findByProperty(OPML_OUTLINE_HTML_URL, opmlOutlineHtmlUrl);
	}

	public List findAll() {
		log.debug("finding all Opml instances");
		try {
			String queryString = "from Opml";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Opml merge(Opml detachedInstance) {
		log.debug("merging Opml instance");
		try {
			Opml result = (Opml) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Opml instance) {
		log.debug("attaching dirty Opml instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Opml instance) {
		log.debug("attaching clean Opml instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
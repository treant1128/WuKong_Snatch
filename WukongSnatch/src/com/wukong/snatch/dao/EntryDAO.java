package com.wukong.snatch.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wukong.snatch.pojo.Entry;

/**
 * A data access object (DAO) providing persistence and search support for Entry
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wukong.snatch.pojo.Entry
 * @author MyEclipse Persistence Tools
 */

public class EntryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(EntryDAO.class);
	// property constants
	public static final String ENTRY_TITLE = "entryTitle";
	public static final String ENTRY_LINK = "entryLink";
	public static final String ENTRY_SOURCE = "entrySource";
	public static final String ENTRY_AUTHOR = "entryAuthor";
	public static final String ENTRY_GUID = "entryGuid";
	public static final String ENTRY_CATEGORY = "entryCategory";
	public static final String ENTRY_COMMENTS = "entryComments";
	public static final String ENTRY_DESCRIPTION = "entryDescription";

//	public void save(Entry transientInstance) {
//		log.debug("saving Entry instance");
//		try {
//			getSession().save(transientInstance);
//			log.debug("save successful");                          System.out.println("success");
//		} catch (RuntimeException re) {
//			log.error("save failed", re);                           System.out.println("failed");
//			throw re;
//		}
//	}
	///////////////////////////////////////////
	/**
	 * 需要通过Spring管理Transaction
	 */
	public void save(Entry transientInstance){
		Transaction tran = null;
		Session session=getSession();
		try {
			
			tran = getSession().beginTransaction();
			session.save(transientInstance);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			session.close();
		}
	}
	public void delete(Entry persistentInstance) {
		log.debug("deleting Entry instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Entry findById(java.lang.Integer id) {
		log.debug("getting Entry instance with id: " + id);
		try {
			Entry instance = (Entry) getSession().get(
					"com.wukong.snatch.pojo.Entry", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Entry instance) {
		log.debug("finding Entry instance by example");
		try {
			List results = getSession().createCriteria(
					"com.wukong.snatch.pojo.Entry").add(
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
		log.debug("finding Entry instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Entry as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEntryTitle(Object entryTitle) {
		return findByProperty(ENTRY_TITLE, entryTitle);
	}

	public List findByEntryLink(Object entryLink) {
		return findByProperty(ENTRY_LINK, entryLink);
	}

	public List findByEntrySource(Object entrySource) {
		return findByProperty(ENTRY_SOURCE, entrySource);
	}

	public List findByEntryAuthor(Object entryAuthor) {
		return findByProperty(ENTRY_AUTHOR, entryAuthor);
	}

	public List findByEntryGuid(Object entryGuid) {
		return findByProperty(ENTRY_GUID, entryGuid);
	}

	public List findByEntryCategory(Object entryCategory) {
		return findByProperty(ENTRY_CATEGORY, entryCategory);
	}

	public List findByEntryComments(Object entryComments) {
		return findByProperty(ENTRY_COMMENTS, entryComments);
	}

	public List findByEntryDescription(Object entryDescription) {
		return findByProperty(ENTRY_DESCRIPTION, entryDescription);
	}

	public List findAll() {
		log.debug("finding all Entry instances");
		try {
			String queryString = "from Entry";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Entry merge(Entry detachedInstance) {
		log.debug("merging Entry instance");
		try {
			Entry result = (Entry) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Entry instance) {
		log.debug("attaching dirty Entry instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Entry instance) {
		log.debug("attaching clean Entry instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
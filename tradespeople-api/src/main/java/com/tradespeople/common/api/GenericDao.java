package com.tradespeople.common.api;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tradespeople.common.exception.TradesPeopleDaoException;


public class GenericDao<T,PK extends Serializable> extends HibernateDaoSupport
{

	@Autowired
	public  void sessionFactorySet(SessionFactory sessionFactory) throws TradesPeopleDaoException
	{
		this.setSessionFactory(sessionFactory);
	}
	
	public GenericDao(Class<T> persistentClass) throws TradesPeopleDaoException
	{
		setPersistentClass(persistentClass);	
	}
	
	private Class<T> persistentClass;
	
	
	public Class<T> getPersistentClass()  {
		return persistentClass;
	}

	protected void setPersistentClass(Class<T> persistentClass) throws TradesPeopleDaoException {
		this.persistentClass = persistentClass;
	}

	
	public Serializable create(T newInstance) throws TradesPeopleDaoException {
		return getHibernateTemplate().save(newInstance);
		
	}

	
	public T read(Serializable id) throws TradesPeopleDaoException {
		return (T) getHibernateTemplate().get(persistentClass,id);
	}

	
	public void update(T transientObject) throws TradesPeopleDaoException {
		getHibernateTemplate().update(transientObject);
		
	}

	
	public void delete(T persistentObject) throws TradesPeopleDaoException {
		getHibernateTemplate().delete(persistentObject);
	}

	
	public Collection<T> loadAll() throws TradesPeopleDaoException {
      return getHibernateTemplate().loadAll(persistentClass);

	}
	
	
	@SuppressWarnings("unchecked")
	public T loadByField(String fieldName, Object fieldValue)  throws TradesPeopleDaoException{
		return (T) getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(persistentClass).
				add(Restrictions.eq(fieldName, fieldValue)).uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
    public Collection<T> loadAllByField(String fieldName, Object fieldValue) throws TradesPeopleDaoException {
    	return getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(persistentClass).
    			add(Restrictions.eq(fieldName, fieldValue)).list();
    }
	
}
	



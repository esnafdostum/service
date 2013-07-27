package com.tradespeople.common.api;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class GenericDao<T,PK extends Serializable> 
extends HibernateDaoSupport
implements GenericDaoInterface<T, Serializable>
{

	@Autowired
	public void sessionFactorySet(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}
	
	public GenericDao(Class<T> persistentClass)
	{
		setPersistentClass(persistentClass);	
	}
	
	private Class<T> persistentClass;
	
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	protected void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	
	public Serializable create(T newInstance) {
		return getHibernateTemplate().save(newInstance);
		
	}

	
	public T read(Serializable id) {
		return (T) getHibernateTemplate().get(persistentClass,id);
	}

	
	public void update(T transientObject) {
		getHibernateTemplate().update(transientObject);
		
	}

	
	public void delete(T persistentObject) {
		getHibernateTemplate().delete(persistentObject);
	}

	
	public Collection<T> loadAll() {
      return getHibernateTemplate().loadAll(persistentClass);

	}
	
	
	@SuppressWarnings("unchecked")
	public T loadByField(String fieldName, Object fieldValue) {
		return (T) getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(persistentClass).
				add(Restrictions.eq(fieldName, fieldValue)).uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
    public Collection<T> loadAllByField(String fieldName, Object fieldValue) {
    	return getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(persistentClass).
    			add(Restrictions.eq(fieldName, fieldValue)).list();
    }
	
}
	



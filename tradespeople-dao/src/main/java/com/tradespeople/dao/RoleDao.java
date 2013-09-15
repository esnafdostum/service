package com.tradespeople.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Role;
import com.tradespeople.model.User;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class RoleDao extends BaseHibernateDaoSupport implements IRoleHibernateDao {

	@Override
	public void save(Role role) throws TradesPeopleDaoException {
		try {
			getSession().save(role);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public void update(Role role) throws TradesPeopleDaoException {
		try {
			getSession().update(role);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public void delete(Role role) throws TradesPeopleDaoException {
		try {
			getSession().delete(role);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listRoles(PaginationSearchCriteria searchCriteria)throws TradesPeopleDaoException {
		try {
			Criteria criteria=createPaginationCriteria(Role.class,searchCriteria);
			return criteria.list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles() throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Role.class).list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRolesByStatus(Byte status)throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Role.class).add(Restrictions.eq("status", status)).list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public Integer findCountUsersOfRole(Role role)throws TradesPeopleDaoException {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.createAlias("userroles", "userroles");
		criteria.createAlias("userroles.role", "role");
		criteria.add(Restrictions.eq("role.id", role.getId()));
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}
}

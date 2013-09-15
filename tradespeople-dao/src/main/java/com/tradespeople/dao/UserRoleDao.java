package com.tradespeople.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Role;
import com.tradespeople.model.User;
import com.tradespeople.model.Userrole;

@Repository
public class UserRoleDao extends BaseHibernateDaoSupport implements IUserRoleHibernateDao {

	@Override
	public void create(Userrole userrole) throws TradesPeopleDaoException {
		try {
			getSession().save(userrole);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public void update(Userrole userrole) throws TradesPeopleDaoException {
		try {
			getSession().update(userrole);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}
	
	@Override
	public void update(Long roleid, Long userid, Byte status)
			throws TradesPeopleDaoException {
		getSession().createSQLQuery("update userrole set status=:Status where userid=:Userid and roleid=:Roleid")
		.setByte("Status",status)
		.setLong("Userid", userid)
		.setLong("Roleid", roleid)
		.executeUpdate();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Userrole> getUserRole(User user) throws TradesPeopleDaoException 
	{
		try {
		return  getSession().createCriteria(Userrole.class)
				.add(Restrictions.eq("user",user))
				.list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Userrole> getUserRole(Role role)
			throws TradesPeopleDaoException {
		try {
			return  getSession().createCriteria(Userrole.class)
					.add(Restrictions.eq("role",role))
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}
	

}

package com.tradespeople.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shoptag;
import com.tradespeople.model.Tag;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
@Transactional
public class ShopTagDao extends BaseHibernateDaoSupport implements IShopTagHibernateDao {

	private final static String SHOPTAG_TABLE_NAME="shoptag";
	@Override
	public void create(Shoptag shopTag) throws TradesPeopleDaoException {
		try {
			getHibernateTemplate().save(shopTag);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@Override
	public void removeTagsFromShop(Shop shop, List<Tag> removedTags) throws TradesPeopleDaoException {
		try {
			getSession().createSQLQuery("delete from "+SHOPTAG_TABLE_NAME+" where SHOPID=:shopId ad TAGID in (:listTagId)").
			setLong("shopId", shop.getId()).
			setParameterList("listTagId", removedTags)
			.executeUpdate();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> listShopTags(PaginationSearchCriteria searchCriteria,Long shopId) throws TradesPeopleDaoException {
		try {
			Criteria criteria=createPaginationCriteria(Tag.class, searchCriteria);
			criteria.createAlias("shoptags", "shoptags");
			criteria.createAlias("shoptags.shop","shop");
			criteria.add(Restrictions.eq("shop.id",shopId));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			return criteria.list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@Override
	public Shoptag findShopTagBy(Long shopId, Long tagId)throws TradesPeopleDaoException {
		Criteria criteria=getSession().createCriteria(Shoptag.class);
		criteria.createAlias("shop", "shop");
		criteria.createAlias("tag", "tag");
		criteria.add(Restrictions.eq("shop.id",shopId));
		criteria.add(Restrictions.eq("tag.id",tagId));
		return (Shoptag)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> listShopsByTag(PaginationSearchCriteria searchCriteria,Long tagid) throws TradesPeopleDaoException {
		Criteria criteria=createPaginationCriteria(Shop.class, searchCriteria);
		criteria.createAlias("shoptags", "shoptags");
		criteria.createAlias("shoptags.tag","tag");
		criteria.add(Restrictions.eq("tag.id", tagid));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shoptag> getShopsTagsByStatus(Shop shop, Byte status)throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Shoptag.class)
					.add(Restrictions.eq("shop", shop))
					.add(Restrictions.eq("status", status))
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Shoptag> getShopsTagsByStatus(Tag tag, Byte status)throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Shoptag.class)
					.add(Restrictions.eq("tag", tag))
					.add(Restrictions.eq("status", status))
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@Override
	public Shoptag getShopTagById(Long id) throws TradesPeopleDaoException {
		try {
			return (Shoptag) getSession().createCriteria(Shoptag.class)
					.add(Restrictions.eq("id", id))
					.uniqueResult();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@Override
	public void update(Shoptag shoptag) throws TradesPeopleDaoException {
		try {
			getHibernateTemplate().update(shoptag);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shoptag> getShopTags(Tag tag) throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Shoptag.class)
					.add(Restrictions.eq("tag", tag))
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

}

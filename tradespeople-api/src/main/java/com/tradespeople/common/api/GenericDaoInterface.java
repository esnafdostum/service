package com.tradespeople.common.api;

import java.io.Serializable;
import java.util.Collection;

import com.tradespeople.common.exception.TradesPeopleDaoException;

public interface GenericDaoInterface<T,PK extends Serializable> {
	/** Persist the newInstance object into database */
    PK create(T newInstance) throws TradesPeopleDaoException;

    /** Retrieve an object that was previously persisted to the database using
     *   the indicated id as primary key
     */
    T read(PK id)  throws TradesPeopleDaoException;

    /** Save changes made to a persistent object.  */
    void update(T transientObject)  throws TradesPeopleDaoException;

    /** Remove an object from persistent storage in the database */
    void delete(T persistentObject)  throws TradesPeopleDaoException;
    
    /*Get all Data giving specific**/
    Collection<T> loadAll()  throws TradesPeopleDaoException;

}

package com.tradespeople.utils;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Role;

public class ApiUtils {
	
	private static String PERSISTED_ERROR_TEXT="Persisted Object Is Obligation";
	private static String USERHAVEROLE_ERROR_TEXT="Some Users have this Role : ";
	
	public static void throwPersistedException() throws TradesPeopleServiceException{
		 throw new TradesPeopleServiceException(PERSISTED_ERROR_TEXT);
	}

	public static void throwUsersHaveRoleException(Role role) throws TradesPeopleServiceException{
		 throw new TradesPeopleServiceException(USERHAVEROLE_ERROR_TEXT+role.getName());
	}

}

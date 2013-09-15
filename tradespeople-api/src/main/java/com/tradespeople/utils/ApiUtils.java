package com.tradespeople.utils;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Role;

public class ApiUtils {
	
	private static final String  USER_TOKEN_CANT_CHANGE_ERROR_TEXT = "Users token can't change After created.";
	private static final String PERSISTED_ERROR_TEXT="Persisted Object Is Obligation.";
	private static final String USERHAVEROLE_ERROR_TEXT="Some Users have this Role : ";
	private static final String NOT_PERSISTED_ERROR_TEXT="Persisted Object can't create .";
	private static final String USER_HASTO_HAVEANY_ROLE_ERROR_TEXT="Users have to have any roles.";
	private static final String SAME_USER_NAME_ERROR_TEXT = "User Name exists in the system";
	private static final String WRONG_USERNAME_ERROR_TEXT = "User Name is wrong";
	private static final String WRONG_PASSWORD_ERROR_TEXT = "User Password is wrong";
	private static final String PASSWORD_LENGTH_ERROR_TEXT = "Password lenght must be 8";
	private static final String REQUIRED_FIELD_ERROR_TEXT = "Required field must be fill";
	
	public static void throwPersistedException() throws TradesPeopleServiceException{
		 throw new TradesPeopleServiceException(PERSISTED_ERROR_TEXT);
	}
	
	public static void throwNotPersistedException() throws TradesPeopleServiceException{
		 throw new TradesPeopleServiceException(NOT_PERSISTED_ERROR_TEXT);
	}

	public static void throwUsersHaveRoleException(Role role) throws TradesPeopleServiceException{
		 throw new TradesPeopleServiceException(USERHAVEROLE_ERROR_TEXT+role.getName());
	}

	public static void throwUserRolesObligationException() throws TradesPeopleServiceException {
		throw new TradesPeopleServiceException(USER_HASTO_HAVEANY_ROLE_ERROR_TEXT);
	}

	public static void throwUserTokenNotChangedObligationException() throws TradesPeopleServiceException{
		throw new TradesPeopleServiceException(USER_TOKEN_CANT_CHANGE_ERROR_TEXT);		
	}

	public static void throwSameUserNameObligationException()  throws TradesPeopleServiceException{
		throw new TradesPeopleServiceException(SAME_USER_NAME_ERROR_TEXT);
		
	}

	public static void throwWrongUserNameException() throws TradesPeopleServiceException{
		throw new TradesPeopleServiceException(WRONG_USERNAME_ERROR_TEXT);		
	}

	public static void throwWrongPasswordException() throws TradesPeopleServiceException {
		throw new TradesPeopleServiceException(WRONG_PASSWORD_ERROR_TEXT);			
	}

	public static void throwPasswordLengthRestrictionException() throws TradesPeopleServiceException {
		throw new TradesPeopleServiceException(PASSWORD_LENGTH_ERROR_TEXT);			
	}

	public static void throwRequiredFieldException() throws TradesPeopleServiceException{
		throw new TradesPeopleServiceException(REQUIRED_FIELD_ERROR_TEXT);			
	}

}

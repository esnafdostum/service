package com.tradespeople.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import org.springframework.stereotype.Service;

import com.tradespeople.utils.ApiConstants.Enums.LogOperation;
import com.tradespeople.utils.ApiConstants.Enums.LogSeverity;
import com.tradespeople.utils.ApiConstants.Enums.UserType;

@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface TradesPeopleLogger {
	
	String Description();
	LogSeverity LogSeverity() default LogSeverity.DEBUG;
	LogOperation LogOperation();
	UserType UserType() default UserType.ADMIN;
	
}

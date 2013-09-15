package com.tradespeople.common.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TradesPeopleLoggerAspect{
	private static final Logger LOG = LoggerFactory.getLogger(TradesPeopleLoggerAspect.class);
    
	@Around("@annotation(com.tradespeople.common.annotation.TradesPeopleLoggerAspect )")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        LOG.debug("{} method has been intercepted", joinPoint.getClass() + " " + methodName);
        return joinPoint.proceed(joinPoint.getArgs());
    }
	
}
package com.kodilla.patterns2.dao.calculator;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))" +
            "&& args(theNumber) && target(object)")
    public void logEvent(BigDecimal theNumber, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + theNumber);
    }

    @Around("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw  throwable;
        }
        return result;
    }

    /*
    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object logExecutionOfProcessOrder(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Class: " + result.getClass().getName() + " has been executed within "
                    + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
    */

    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)")
    public void logExecutionOfProcessOrder(JoinPoint joinPoint, OrderDto order, Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Method: "  + joinPoint.getSignature().getName() + ", Args: "
                + order.getItems() +
                " and " + userId);
    }
}

package com.emreturgutce.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(
            value = "execution(* com.emreturgutce.springaop.business.*.*(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(
            value = "execution(* com.emreturgutce.springaop.business.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("{} thrown exception {}", joinPoint, exception);
    }

    @After(
            value = "execution(* com.emreturgutce.springaop.business.*.*(..))"
    )
    public void after(JoinPoint joinPoint) {
        logger.info("after execution of {}", joinPoint);
    }
}
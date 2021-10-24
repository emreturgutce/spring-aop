package com.emreturgutce.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ExecutionCalculationAopAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(
            value = "execution(* com.emreturgutce.springaop.business.*.*(..))"
    )
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;

        logger.info("Time taken by {} is {}", joinPoint, timeTaken);
    }
}

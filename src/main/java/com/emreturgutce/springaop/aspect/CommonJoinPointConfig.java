package com.emreturgutce.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* com.emreturgutce.springaop.data.*.*(..))")
    public void dataLayerExecution() {}

    @Pointcut("execution(* com.emreturgutce.springaop.business.*.*(..))")
    public void businessLayerExecution() {}

    @Pointcut("com.emreturgutce.springaop.aspect.CommonJoinPointConfig.businessLayerExecution() && com.emreturgutce.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void allLayersExecution() {}

    @Pointcut("bean(*dao*)")
    public void beanContainingDao() {}

    @Pointcut("within(com.emreturgutce.springaop.data..*)")
    public void dataLayerExecutionWithWithin() {}
}

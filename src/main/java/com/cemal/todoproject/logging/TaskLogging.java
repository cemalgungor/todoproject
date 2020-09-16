package com.cemal.todoproject.logging;


import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;


@Aspect
@Component
public class TaskLogging  {
    Logger  log = LoggerFactory.getLogger(TaskLogging.class);
    @Pointcut("within(com.cemal.todoproject.service..*)")
    public void taskLogging() {



    }

    @Around("taskLogging()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
                + mapper.writeValueAsString(array));
        Object object = pjp.proceed();
        log.info(className + " : " + methodName + "()" + "Response : "
                + mapper.writeValueAsString(object));
        return object;
    }
}

package com.example.hellospringboot;

import com.example.hellospringboot.HelloSpringbootApplication;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //Es una anotacion
@Component //se tiene que introdcir como un componente
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(HelloSpringbootApplication.class);

    //cuales seran las marcsa de corte
    @Pointcut("within(com.example.hellospringboot..*)")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void logMethod(JoinPoint joinPoint){
        log.info("invocando desde el aspecto" + joinPoint.getSignature().getName());
    }
}

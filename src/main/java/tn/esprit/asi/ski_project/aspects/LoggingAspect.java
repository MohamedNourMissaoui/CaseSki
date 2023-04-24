package tn.esprit.asi.ski_project.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component // instanciation de classe
@Slf4j
public class LoggingAspect {
    @Before("execution(public void tn.esprit.asi.ski_project.services.*.*(..))")
    public void InMethod(JoinPoint joinPoint){
        log.info("in method " + joinPoint.getSignature().getName());

    }
    @After("execution(public void tn.esprit.asi.ski_project.services.*.*(..))")
    public void OutMethod(JoinPoint joinPoint){
        log.info("out method " + joinPoint.getSignature().getName());

    }

}


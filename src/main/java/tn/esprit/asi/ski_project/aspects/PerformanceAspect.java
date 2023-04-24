package tn.esprit.asi.ski_project.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {
    @Around("execution( * tn.esprit.asi.ski_project.services.*.add*(..))")
    public Object ExecutionTime(ProceedingJoinPoint pjp) throws Throwable{
        Object o = pjp.proceed();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        log.info("execution time is " + o + stopWatch.getTotalTimeMillis());
        return o;
    }

    @Around("execution( * tn.esprit.asi.ski_project.services.*.add*(..))")
    public List<Object> ExecutionTime2(ProceedingJoinPoint pjp) throws Throwable{
        List<Object> o2 = (List<Object>)pjp.proceed() ;
        return o2 ;
    }

}

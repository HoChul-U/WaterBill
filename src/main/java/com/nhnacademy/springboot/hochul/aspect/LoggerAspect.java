package com.nhnacademy.springboot.hochul.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {
    private static final Log log = LogFactory.getLog(LoggerAspect.class);

    @Around("execution(* com.nhnacademy.springboot.hochul..*(..))")
    public Object timeStamp(ProceedingJoinPoint pjp) throws Throwable {
        var stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            log.info((pjp.getSignature().getName() + stopWatch.prettyPrint()));
        }
    }
    @AfterThrowing(value = "execution(* com.nhnacademy.springboot.hochul..*(..))", throwing = "e")
    public void exception(JoinPoint jp, Throwable e) {
        var stopWatch = new StopWatch();
        try {
            stopWatch.start();
        } finally {
            stopWatch.stop();
            log.error("LoggerAspect", e);
        }
    }
}

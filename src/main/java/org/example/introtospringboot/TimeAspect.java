package org.example.introtospringboot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    @Around("@annotation(Timer)")
    public void logTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Went wrong during execution");

        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) + "ms..");

        }

    }
}

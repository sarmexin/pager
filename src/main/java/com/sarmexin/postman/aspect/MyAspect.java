package com.sarmexin.postman.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspect {

    // Before - выполнить набор инструкций до того, как метод отработает
    // After - выполнить набор инструкций после того, как метод отработает
    // Around - выполнить набор инструкций решает программист

    @Around("Pointcuts.allReadMethods()")
    public Object runAround(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Long id = 0L;
        if (methodSignature.getName().equals("readMessage")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof Long) {
                    id = (Long) arg;
                    log.info("Попытка прочитать сообщение с id={}", id);
                }
            }
        }

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }

        log.info("Сообщение с id={} прочитано", id);

        return result;
    }

}

package com.sarmexin.postman.aspect.logger;

import com.sarmexin.postman.annotation.WithLogging;
import com.sarmexin.postman.aspect.BaseAspect;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Sergey Gavrilov
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect extends BaseAspect {

    /**
     * Pointcut
     * @param annotation нотация
     */
    @Pointcut(value = "@annotation(annotation)")
    public void callLoggingAnnotation(WithLogging annotation) {
        // Pointcut methods should have empty body
    }

    @SneakyThrows
    @Around(value = "callLoggingAnnotation(notation) && publicMethod()", argNames = "joinPoint, notation")
    public Object aroundWithLogging(ProceedingJoinPoint joinPoint, WithLogging notation) {
        Object result;
        Exception exception = null;
        String request = null;
        String response = null;
        String uuid = null;
        long start = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            aroundCatchMethod(
                    notation,
                    System.currentTimeMillis() - start,
                    exception
            );
        }
    }

    private void aroundCatchMethod(WithLogging notation, long duration, Exception e) {
        log.debug(
                notation.service(),
                duration,
                e
        );
    }
}

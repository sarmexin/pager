package com.sarmexin.postman.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sergey Gavrilov
 *
 * Базовый аспект
 */
public abstract class BaseAspect {

    /**
     * Pointcut на публичные методы
     */
    @Pointcut("execution(public * *(..))")
    public void publicMethod() {/*NOP*/}

    /**
     * Получить мапу с параметрами исходного метода
     *
     * @param joinPoint исходный метод
     * @return мапа с параметрами
     */
    protected Map<String, Object> getOriginalsMethodParams(ProceedingJoinPoint joinPoint) {
        Map<String, Object> params = new HashMap<>();
        if ((joinPoint != null) && (joinPoint.getSignature() instanceof MethodSignature)) {
            var methodSignature = (MethodSignature) joinPoint.getSignature();
            String[] parameterNames = methodSignature.getParameterNames();
            Object[] parameterValues = joinPoint.getArgs();
            for (var i = 0; i < parameterNames.length; i++) {
                if (Objects.nonNull(parameterNames[i]))
                    params.put(parameterNames[i], parameterValues[i]);
            }
        }
        return params;
    }
}

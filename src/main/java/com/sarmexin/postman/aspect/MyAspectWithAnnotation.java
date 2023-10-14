//package com.sarmexin.postman.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Aspect
//@Component
//public class MyAspectWithAnnotation {
//
//    @Around("@annotation(WithLogging)")
//    public Object withLogging(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("lllllla");
//        return joinPoint.proceed();
//    }
//
//}

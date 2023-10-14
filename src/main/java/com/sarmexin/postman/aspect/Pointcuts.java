package com.sarmexin.postman.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.sarmexin.postman.services.impl.MessageServiceImpl.save*(..))")
    public void allSaveMethods() {}

    @Pointcut("execution(* com.sarmexin.postman.services.impl.MessageServiceImpl.readMessage*(..))")
    public void allReadMethods() {}

}

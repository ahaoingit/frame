package com.brianyi.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author ahao 2020-11-12
 */
@Component
@Aspect
public class LogUtil {
    /**
     * 切入点表达式
     */
    @Pointcut("execution(* *(..))")
    public void getPointCut(){}

    /**
     * 前置通知
     */
    @Before("getPointCut()")
    public void begin(JoinPoint joinpoint) {
        System.out.println("function name:"+joinpoint.getSignature().toString());
        System.out.println("开始时间"+System.currentTimeMillis());
    }

    /**
     * 后置返回通知
     * 当方法没有抛出任何异常并正常返回时。
     */
    @AfterReturning("getPointCut()")
    public void afterReturn() {
        System.out.println("afterReturn");
    }

    /**
     * 后置异常通知
     * 在方法抛出异常退出时执行的通知
     */
    @AfterThrowing("getPointCut()")
    public void afterThrows() {
        System.out.println("afterthrows");
    }
    /**
     * 当连接点退出的时候执行的通知
     * 后置通知
     */
    @After("getPointCut()")
    public void after() {
        System.out.println("after"+System.currentTimeMillis());
    }

    /**
     * 环绕通知
     *
     */
//    @Around("getPointCut()")
//    public void aroud() {
//        System.out.println("aroud");
//    }


}

package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Profile("four")
public class FourAdviceAspect {
    @Pointcut("execution(* org.example.InventoryService.*(..))")
public void inventoryMethod(){
    }
    @Before("inventoryMethod()")
    public void before(JoinPoint jp){
        System.out.println("Before invoke " + jp.getSignature().getName() + "args=" + Arrays.toString(jp.getArgs()));
    }
    @AfterReturning(
            pointcut = "inventoryMethod()",
            returning = "result"
    )
    public void afterReturning(JoinPoint jp, Object result) {

        System.out.println(
                "SUCCESS: " + jp.getSignature().getName()
                        + " result=" + result
        );
    }
    @AfterThrowing(
            pointcut = "inventoryMethod()",
            throwing = "ex"
    )
    public void afterThrowing(JoinPoint jp, Throwable ex) {

        System.out.println(
                "ERROR: " + jp.getSignature().getName()
                        + " message=" + ex.getMessage()
        );
    }
    @After("inventoryMethod()")
    public void after(JoinPoint jp) {

        System.out.println(
                "FINALLY: " + jp.getSignature().getName()
        );
    }
}

package org.example;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile("around")
public class AroundOnlyAspect {

    @Around(
            "execution(* org.example.InventoryService.*(..))"
    )
    public Object observe(ProceedingJoinPoint pjp)
            throws Throwable {

        String method = pjp.getSignature().getName();
        long start = System.nanoTime();

        // Replaces @Before
        System.out.println(
                "BEFORE: " + method
                        + " args=" + Arrays.toString(pjp.getArgs())
        );

        try {
            Object result = pjp.proceed();

            // Replaces @AfterReturning
            System.out.println(
                    "SUCCESS: " + method + " result=" + result
            );

            return result;

        } catch (Throwable ex) {

            // Replaces @AfterThrowing
            System.out.println(
                    "ERROR: " + method
                            + " message=" + ex.getMessage()
            );

            throw ex;

        } finally {

            // Replaces @After
            System.out.println("FINALLY: " + method);

            long elapsed = System.nanoTime() - start;
            System.out.println("TIME: " + elapsed / 1_000_000 + "ms");
        }
    }
}
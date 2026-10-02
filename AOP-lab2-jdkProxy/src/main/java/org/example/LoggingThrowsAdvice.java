package org.example;

import org.springframework.aop.ThrowsAdvice;
import java.lang.reflect.Method;

public class LoggingThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(
            Method method,
            Object[] args,
            Object target,
            Exception ex) {

        if (method.getName().equals("reserveStock")) {
            System.out.println(
                    "ERROR: " + method.getName()
                            + " | " + ex.getMessage()
            );
        }
    }
}
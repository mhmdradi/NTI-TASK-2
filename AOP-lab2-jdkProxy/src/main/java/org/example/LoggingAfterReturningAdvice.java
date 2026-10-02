package org.example;

import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;

public class LoggingAfterReturningAdvice
        implements AfterReturningAdvice {

    @Override
    public void afterReturning(
            Object returnValue,
            Method method,
            Object[] args,
            Object target) {

        if (method.getName().equals("checkStock")) {
            System.out.println(
                    "AFTER SUCCESS: " + method.getName()
                            + " returned " + returnValue
            );
        }
    }
}
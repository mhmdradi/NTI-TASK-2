package org.example;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation)
            throws Throwable {

        long start = System.nanoTime();

        System.out.println(
                "START: " + invocation.getMethod().getName()
        );

        try {
            return invocation.proceed();

        } finally {
            double durationMs =
                    (System.nanoTime() - start) / 1_000_000.0;

            System.out.println(
                    "FINALLY: " + invocation.getMethod().getName()
                            + " took " + durationMs + " ms"
            );
        }
    }
}
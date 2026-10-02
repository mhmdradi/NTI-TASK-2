package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LogProxy implements InvocationHandler {
    private final Object target;

    public LogProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        System.out.println("Before invoking " + method.getName() + " with args " + Arrays.toString(args));
        try {
            Object result = method.invoke(target, args);
            System.out.println("Success: " + result);
            return result;
        } catch (InvocationTargetException e) {
            System.out.println("Failed: " + e.getCause());
            throw e.getCause();
        } finally {
            long millis = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Time taken: " + millis + " ms");
        }
    }
}
package org.example;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class CachingAspect {

    private final Map<String, Object> cache =
            new ConcurrentHashMap<>();

    @Around("@annotation(org.example.Cacheable)")
    public Object cacheResult(ProceedingJoinPoint pjp)
            throws Throwable {

        String key =
                pjp.getSignature().toLongString()
                        + Arrays.deepToString(pjp.getArgs());

        Object cachedResult = cache.get(key);

        if (cachedResult != null) {
            System.out.println("CACHE HIT");

            return cachedResult;
        }

        System.out.println("CACHE MISS");

        Object result = pjp.proceed();

        if (result != null) {
            cache.put(key, result);
        }

        return result;
    }
}
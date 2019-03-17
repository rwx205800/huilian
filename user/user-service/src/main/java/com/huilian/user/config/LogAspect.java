package com.huilian.user.config;

import com.huilian.user.exception.CustomException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author renfei
 * @date 2018/11/24 16:01
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(* com.huilian.user.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuilder sb = new StringBuilder();
        sb.append("请求url:").append(request.getRequestURL()).append("]");
        logger.info(sb.toString());

        Object result = null;
        String methodName = null;

        Object[] args = joinPoint.getArgs();
        Class<?> targetClass = joinPoint.getTarget().getClass();

        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            methodName = targetClass.getMethod(methodSignature.getName(), methodSignature.getParameterTypes()).getName();
        }

        long start = System.currentTimeMillis();
        logger.info("执行{}-{} 开始，参数：{}", targetClass.getName(), methodName, args == null ? "" : Arrays.asList(args));
        try {
            result = joinPoint.proceed();
        } catch (CustomException e) {
            result = e.getMessage();
            throw e;
        } catch (Throwable e) {
            result = e;
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            logger.info("执行{}-{} 结束，耗时：{}ms，结果：{}", targetClass.getName(), methodName, end - start, result);
        }

        return result;
    }
}

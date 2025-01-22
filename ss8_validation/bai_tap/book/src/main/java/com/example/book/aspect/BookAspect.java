package com.example.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    @AfterReturning(pointcut = "execution(* com.example.book.controller.BookController.*(..))")
    public void log(JoinPoint joinPoint){
        String name =joinPoint.getSignature().getName();
        System.out.println("is in the position of  "+name);
    }
    @AfterReturning(pointcut = "execution(* com.example.book.controller.BookController.rent(String))")
    public void status(JoinPoint joinPoint){
        System.out.println("rented a book");
    }
}

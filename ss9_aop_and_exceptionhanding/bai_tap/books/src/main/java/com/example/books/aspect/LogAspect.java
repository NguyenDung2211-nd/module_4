package com.example.books.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Before("execution(* com.example.books.service.impl.BookService.borrowBook(..))")
    public void logBeforeBorrow() {
        System.out.println("Log: Người dùng đang cố gắng mượn sách.");
    }

    @AfterReturning("execution(* com.example.books.service.impl.BookService.borrowBook(..))")
    public void logAfterBorrow() {
        System.out.println("Log: Mượn sách thành công và đã cập nhật số lượng.");
    }

    @AfterThrowing(value = "execution(* com.example.books.service.impl.BookService.borrowBook(..))", throwing = "exception")
    public void logErrorDuringBorrow(Exception exception) {
        System.out.println("Log: Lỗi khi mượn sách: " + exception.getMessage());
    }

    @Before("execution(* com.example.books.service.impl.BookService.returnBook(..))")
    public void logBeforeReturn() {
        System.out.println("Log: Người dùng đang cố gắng trả sách.");
    }

    @AfterReturning("execution(* com.example.books.service.impl.BookService.returnBook(..))")
    public void logAfterReturn() {
        System.out.println("Log: Trả sách thành công và đã cập nhật số lượng.");
    }

    @AfterThrowing(value = "execution(* com.example.books.service.impl.BookService.returnBook(..))", throwing = "exception")
    public void logErrorDuringReturn(Exception exception) {
        System.out.println("Log: Lỗi khi trả sách: " + exception.getMessage());
    }
}

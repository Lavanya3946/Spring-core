package com.xworkz.bookapp;

import com.xworkz.bookapp.config.SpringBookConfig;
import com.xworkz.bookapp.dto.BookDto;
import com.xworkz.bookapp.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBookConfig.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        BookDto bookDto = new BookDto();
        bookDto.setName("c");
        bookDto.setCost(500);
        bookService.validateAndSave(bookDto);

        bookService.getById(1);
        System.out.println(bookService);

        bookService.getByName("c");
        System.out.println(bookService);

        bookService.updateCostByName(850, "c");
        System.out.println(bookService);

        bookService.removeById(2);
        System.out.println(bookService);
    }
}

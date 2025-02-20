package com.xworkz.bookapp.service;

import com.xworkz.bookapp.dto.BookDto;
import com.xworkz.bookapp.entity.BookEntity;
import com.xworkz.bookapp.repo.BookRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public boolean validateAndSave(BookDto bookDto) {
        boolean saveBook = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<BookDto>> violations = validator.validate(bookDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookDto, bookEntity);
        saveBook = bookRepo.save(bookEntity);
        return saveBook;
    }

    @Override
    public boolean getById(Integer id) {
        BookEntity bookEntity = bookRepo.getById(id);
        System.out.println(bookEntity);
        return false;
    }

    @Override
    public BookEntity getByName(String book_name) {
        bookRepo.getByName(book_name);
        return null;
    }

    @Override
    public void updateCostByName(Integer cost, String book_name) {
        bookRepo.updateCostByName(cost, book_name);
    }

    @Override
    public void removeById(Integer id) {
        bookRepo.removeById(id);
    }
}

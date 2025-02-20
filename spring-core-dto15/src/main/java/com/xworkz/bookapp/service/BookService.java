package com.xworkz.bookapp.service;

import com.xworkz.bookapp.dto.BookDto;
import com.xworkz.bookapp.entity.BookEntity;

public interface BookService {
    boolean validateAndSave(BookDto bookDto);

    boolean getById(Integer id);

    BookEntity getByName(String book_name);

    void updateCostByName(Integer cost, String book_name);

    void removeById(Integer id);
}

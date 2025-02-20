package com.xworkz.bookapp.repo;

import com.xworkz.bookapp.entity.BookEntity;

public interface BookRepo {
    boolean save(BookEntity bookEntity);

    BookEntity getById(Integer id);

    void getByName(String book_name);

    void updateCostByName(Integer cost, String book_name);

    void removeById(Integer id);

}

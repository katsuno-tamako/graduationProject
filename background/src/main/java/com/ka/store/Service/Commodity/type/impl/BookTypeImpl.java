package com.ka.store.Service.Commodity.type.impl;

import com.ka.store.Service.Commodity.type.BookTypeService;
import com.ka.store.dao.BookTypeDao;
import com.ka.store.pojo.type.BookType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookTypeImpl implements BookTypeService {

    @Resource
    BookTypeDao bookTypeDao;

    @Override
    public List<BookType> selectAllBookType() {
        return bookTypeDao.selectAllBookType();
    }

    @Override
    public void insertBookType(BookType bookType) {
        bookTypeDao.insertBookType(bookType);
    }

    @Override
    public void deleteBookType(String book_type) {
        bookTypeDao.deleteBookType(book_type);
    }
}

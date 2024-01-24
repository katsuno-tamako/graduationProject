package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.type.BookType;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTypeDao {

    public List<BookType> selectAllBookType();

    public void insertBookType(BookType bookType);

    public void deleteBookType(String book_type);

}

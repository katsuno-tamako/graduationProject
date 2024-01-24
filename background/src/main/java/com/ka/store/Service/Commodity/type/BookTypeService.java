package com.ka.store.Service.Commodity.type;
import java.util.List;
import com.ka.store.pojo.type.BookType;
import org.springframework.stereotype.Service;


@Service
public interface BookTypeService {


    public List<BookType> selectAllBookType();

    public void insertBookType(BookType bookType);

    public void deleteBookType(String book_type);

}

package com.ka.store.Controller.Commodity;

import com.ka.store.Service.Commodity.type.BookTypeService;
import com.ka.store.pojo.type.BookType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/type")
public class typeController {

    @Resource
    BookTypeService bookTypeService;

    @Resource
    BookType bookType;

    @RequestMapping("/selectAllBookType")
    public List<BookType> selectAllBookType(){
        return bookTypeService.selectAllBookType();
    }

    @RequestMapping("/insertBookType")
    public void insertBookType(@RequestParam String ins_type){
        bookType.setBook_type(ins_type);
        bookTypeService.insertBookType(bookType);
    }

    @RequestMapping("/deleteBookType")
    public void deleteBookType(@RequestParam String book_type){
        bookTypeService.deleteBookType(book_type);
    }

}

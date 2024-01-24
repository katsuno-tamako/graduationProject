package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_books;
import org.springframework.stereotype.Repository;

@Repository
public interface Commodity_categories_booksDao {

    public Commodity_categories_books selectCommodityBooksById(String commodity_id);

    public void insertBook(Commodity_categories_books books);

    public void updateBookCommodity(Commodity_categories_books books);

    public void deleteBookCommodity(String commodity_id);

    public List<Commodity_categories_books> selectBookByCategory(String book_type);

    public List<Commodity_categories_books> selectAllBook();

    public List<String> selectBookGroupAuthor();

    public List<String> selectBookGroupPublish();

    public List<Commodity_categories_books> selectBookLike(String key);

//   --

    public List<Commodity_categories_books> selectByBookType(String keyword);

    public List<Commodity_categories_books> selectByBookTypeUp(String keyword);

    public List<Commodity_categories_books> selectByBookTypeDown(String keyword);

//    --

    public List<Commodity_categories_books> selectByBookOrderPrice();
    public List<Commodity_categories_books> selectByBookOrderPriceUp();
    //

    public List<Commodity_categories_books> selectBookOrderBySaleNumUp();
    public List<Commodity_categories_books> selectBookOrderBySaleNumDown();

    public List<Commodity_categories_books> selectBookOrderBySaleNumDownAndKeyword(String keyword);
    public List<Commodity_categories_books> selectBookOrderBySaleNumUpAndKeyword(String keyword);

    public List<Commodity_categories_books> selectBookOrderByScoreDown();
    public List<Commodity_categories_books> selectBookOrderByScoreUp();
    public List<Commodity_categories_books> selectBookOrderByScoreDownByKeyword(String keyword);
    public List<Commodity_categories_books> selectBookOrderByScoreUpByKeyword(String keyword);




}

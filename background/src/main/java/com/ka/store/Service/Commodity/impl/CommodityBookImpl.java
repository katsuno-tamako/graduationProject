package com.ka.store.Service.Commodity.impl;

import com.ka.store.Service.Commodity.CommodityBookService;
import com.ka.store.dao.CommodityDao;
import com.ka.store.dao.Commodity_categories_booksDao;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_books;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CommodityBookImpl implements CommodityBookService {

    @Resource
    Commodity_categories_books commodity_categories_books;

    @Resource
    Commodity_categories_booksDao commodity_categories_booksDao;

    @Resource
    CommodityDao commodityDao;

    @Resource
    Commodity commodity;

    @Override
    public void insertBook(Commodity_categories_books book) {
        commodity_categories_booksDao.insertBook(book);
        commodity = book.getCommodity();
        commodityDao.insertCommodity(commodity);
    }

    @Override
    public Commodity_categories_books selectCommodityBooksById(String commodity_id) {
        return commodity_categories_booksDao.selectCommodityBooksById(commodity_id);
    }

    @Override
    public void updateBookCommodity(Commodity_categories_books commodity_categories_books) {
        System.out.println("Service:"+commodity_categories_books);
        commodityDao.updateCommodity(commodity_categories_books.getCommodity());
        commodity_categories_booksDao.updateBookCommodity(commodity_categories_books);
    }

    @Override
    public void deleteBookCommodity(String commodity_id) {
        commodityDao.deleteCommodity(commodity_id);
        commodity_categories_booksDao.deleteBookCommodity(commodity_id);
    }

    @Override
    public List<Commodity_categories_books> selectBookByCategory(String book_type) {
        return commodity_categories_booksDao.selectBookByCategory(book_type);
    }

    @Override
    public List<Commodity_categories_books> selectAllBook() {
        return commodity_categories_booksDao.selectAllBook();
    }

    @Override
    public List<String> selectBookGroupAuthor() {
        return commodity_categories_booksDao.selectBookGroupAuthor();
    }

    @Override
    public List<String> selectBookGroupPublish() {
        return commodity_categories_booksDao.selectBookGroupPublish();
    }

    @Override
    public List<Commodity_categories_books> selectBookLike(String key) {
        return commodity_categories_booksDao.selectBookLike(key);
    }

    @Override
    public List<Commodity_categories_books> selectByBookType(String commodity_type) {
        return commodity_categories_booksDao.selectByBookType(commodity_type);
    }

    @Override
    public List<Commodity_categories_books> selectByBookTypeUp(String commodity_type) {
        return commodity_categories_booksDao.selectByBookTypeUp(commodity_type);
    }

    @Override
    public List<Commodity_categories_books> selectByBookTypeDown(String commodity_type) {
        return commodity_categories_booksDao.selectByBookTypeDown(commodity_type);
    }

    @Override
    public List<Commodity_categories_books> selectByBookOrderPrice() {
        return commodity_categories_booksDao.selectByBookOrderPrice();
    }

    @Override
    public List<Commodity_categories_books> selectByBookOrderPriceUp() {
        return commodity_categories_booksDao.selectByBookOrderPriceUp();
    }

    @Override
    public List<Commodity_categories_books> selectBookOrderBySaleNumUp() {
        return commodity_categories_booksDao.selectBookOrderBySaleNumUp();
    }

    @Override
    public List<Commodity_categories_books> selectBookOrderBySaleNumDown() {
        return commodity_categories_booksDao.selectBookOrderBySaleNumDown();
    }

    @Override
    public List<Commodity_categories_books> selectBookOrderBySaleNumDownAndKeyword(String keyword) {
        return commodity_categories_booksDao.selectBookOrderBySaleNumDownAndKeyword(keyword);
    }

    @Override
    public List<Commodity_categories_books> selectBookOrderBySaleNumUpAndKeyword(String keyword) {
        return commodity_categories_booksDao.selectBookOrderBySaleNumUpAndKeyword(keyword);
    }

    @Override
    public List<Commodity_categories_books> selectBookOrderByScoreDown() {
        return commodity_categories_booksDao.selectBookOrderByScoreDown();
    }

    @Override
    public List<Commodity_categories_books> selectBookOrderByScoreUp() {
        return commodity_categories_booksDao.selectBookOrderByScoreUp();
    }

    @Override
    public List<Commodity_categories_books> selectBookOrderByScoreDownByKeyword(String keyword) {
        return commodity_categories_booksDao.selectBookOrderByScoreDownByKeyword(keyword);
    }

    @Override
    public List<Commodity_categories_books> selectBookOrderByScoreUpByKeyword(String keyword) {
        return commodity_categories_booksDao.selectBookOrderByScoreUpByKeyword(keyword);
    }
}

package com.ka.store.Service.Commodity.impl;

import com.ka.store.Service.Commodity.CommodityComputerService;
import com.ka.store.dao.CommodityDao;
import com.ka.store.dao.Commodity_categories_computerDao;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_computer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommodityComputerImp implements CommodityComputerService {

    @Resource
    Commodity commodity;

    @Resource
    Commodity_categories_computerDao commodity_categories_computerDao;

    @Resource
    CommodityDao commodityDao;

    @Override
    public List<Commodity_categories_computer> selectAllComputer() {
        return commodity_categories_computerDao.selectAllComputer();
    }

    @Override
    public void insert(Commodity_categories_computer computer) {
        commodity_categories_computerDao.insertComputer(computer);
        commodityDao.insertCommodity(computer.getCommodity());

    }

    @Override
    public Commodity_categories_computer selectComputerById(String commodity_Id) {
        return commodity_categories_computerDao.selectComputerById(commodity_Id);
    }

    @Override
    public void updateComputerById(Commodity_categories_computer commodity_categories_computer) {
        commodityDao.updateCommodity(commodity_categories_computer.getCommodity());
        commodity_categories_computerDao.updateComputerById(commodity_categories_computer);
    }

    @Override
    public void deleteComputerById(String commodity_id) {
        commodityDao.deleteCommodity(commodity_id);
        commodity_categories_computerDao.deleteComputerById(commodity_id);
    }

    @Override
    public List<String> selectComputerDisByType() {
        return commodity_categories_computerDao.selectComputerDisByType();
    }

    @Override
    public List<String> selectComputerDisByCPU() {
        return commodity_categories_computerDao.selectComputerDisByCPU();
    }

    @Override
    public List<String> selectComputerDisByBrand() {
        return commodity_categories_computerDao.selectComputerDisByBrand();
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderPrice() {
        return commodity_categories_computerDao.selectByComputerOrderPrice();
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderPriceUp() {
        return commodity_categories_computerDao.selectByComputerOrderPriceUp();
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderBySaleNumUp() {
        return commodity_categories_computerDao.selectByComputerOrderBySaleNumUp();
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderBySaleNumDown() {
        return commodity_categories_computerDao.selectByComputerOrderBySaleNumDown();
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderByScoreDown() {
        return commodity_categories_computerDao.selectByComputerOrderByScoreDown();
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderByScoreUp() {
        return commodity_categories_computerDao.selectByComputerOrderByScoreUp();
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerKeyword(String keyword) {
        return commodity_categories_computerDao.selectByComputerKeyword(keyword);
    }

    @Override
    public List<Commodity_categories_computer> selectComputerOrderBySaleNumDownAndKeyword(String keyword) {
        return commodity_categories_computerDao.selectComputerOrderBySaleNumDownAndKeyword(keyword);
    }

    @Override
    public List<Commodity_categories_computer> selectComputerOrderBySaleNumUpAndKeyword(String keyword) {
        return commodity_categories_computerDao.selectComputerOrderBySaleNumUpAndKeyword(keyword);
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderByScoreDownByKeyword(String keyword) {
        return commodity_categories_computerDao.selectByComputerOrderByScoreDownByKeyword(keyword);
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderByScoreUpByKeyword(String keyword) {
        return commodity_categories_computerDao.selectByComputerOrderByScoreUpByKeyword(keyword);
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderByPriceDownByKeyword(String keyword) {
        return commodity_categories_computerDao.selectByComputerOrderByPriceDownByKeyword(keyword);
    }

    @Override
    public List<Commodity_categories_computer> selectByComputerOrderByPriceUpByKeyword(String keyword) {
        return commodity_categories_computerDao.selectByComputerOrderByPriceUpByKeyword(keyword);
    }

}

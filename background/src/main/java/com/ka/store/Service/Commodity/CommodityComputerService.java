package com.ka.store.Service.Commodity;
import java.util.List;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_computer;
import org.springframework.stereotype.Service;

@Service
public interface CommodityComputerService {

    public List<Commodity_categories_computer> selectAllComputer();

    public void insert(Commodity_categories_computer commodity_categories_computer);

    public Commodity_categories_computer selectComputerById(String commodity_Id);

    public void updateComputerById(Commodity_categories_computer commodity_categories_computer);

    public void deleteComputerById(String commodity_id);

    public List<String> selectComputerDisByType();

    public List<String> selectComputerDisByCPU();

    public List<String> selectComputerDisByBrand();


    public List<Commodity_categories_computer> selectByComputerOrderPrice();
    public List<Commodity_categories_computer> selectByComputerOrderPriceUp();

    public List<Commodity_categories_computer> selectByComputerOrderBySaleNumUp();
    public List<Commodity_categories_computer> selectByComputerOrderBySaleNumDown();

    public List<Commodity_categories_computer> selectByComputerOrderByScoreDown();
    public List<Commodity_categories_computer> selectByComputerOrderByScoreUp();

    public List<Commodity_categories_computer> selectByComputerKeyword(String keyword);


    public List<Commodity_categories_computer> selectComputerOrderBySaleNumDownAndKeyword(String keyword);
    public List<Commodity_categories_computer> selectComputerOrderBySaleNumUpAndKeyword(String keyword);

    public List<Commodity_categories_computer> selectByComputerOrderByScoreDownByKeyword(String keyword);
    public List<Commodity_categories_computer> selectByComputerOrderByScoreUpByKeyword(String keyword);

    public List<Commodity_categories_computer> selectByComputerOrderByPriceDownByKeyword(String keyword);
    public List<Commodity_categories_computer> selectByComputerOrderByPriceUpByKeyword(String keyword);


}

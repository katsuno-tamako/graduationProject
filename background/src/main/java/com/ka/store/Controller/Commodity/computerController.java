package com.ka.store.Controller.Commodity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ka.store.Service.Commodity.CommodityComputerService;
import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Commodity.computer.Computer_typeService;
import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.config.ImgCon;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_computer;
import com.ka.store.pojo.commodity.computer.Computer_category;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/computer")
public class computerController {


    @Resource
    ImgCon imgCon;

    @Resource
    usFunc func;

    @Resource
    CommodityComputerService commodityComputerService;

    @Resource
    Commodity commodity;

    @Resource
    CommodityService commodityService;

    @Resource
    Sales_commodity sales_commodity;
    @Resource
    Sales_commodityService sales_commodityService;

    @RequestMapping("/selectComputer")
    public List<Commodity_categories_computer> selectAllComputer(){
        return commodityComputerService.selectAllComputer();
    }

    @RequestMapping("/insertComputer")
    public synchronized String insertComputer(@RequestBody Commodity_categories_computer computer, HttpSession session){

        String commodity_id = func.getFN("computer");

        computer.setCommodity_id(commodity_id);
        computer.getCommodity().setCommodity_id(computer.getCommodity_id());
        computer.getCommodity().setMerchant_id(session.getAttribute("merchantId").toString());
        computer.getCommodity().setName(computer.getComputer_name());
        computer.getCommodity().setPrice(computer.getPrice());
        computer.getCommodity().setCategory("电脑");
        System.out.println(computer);

        sales_commodity.setAve_grade("no");
        sales_commodity.setCommodity_id(computer.getCommodity_id());
        sales_commodity.setSales_num(0);
        System.out.println(sales_commodity);
        sales_commodityService.insertCommoditySalesInfo(sales_commodity);

        commodityComputerService.insert(computer);
        return commodity_id;
    }

    @RequestMapping("/receiveComputerImg")
    @CrossOrigin
    public synchronized void receiveComputerImg(@RequestParam("file")MultipartFile file,@RequestParam(value="commodity_id") String commodity_id){
        imgCon.insertImg(file,commodity_id);
    }


    @RequestMapping("/selectComputerById")
    public Commodity_categories_computer selectComputerById(@RequestParam(value="commodity_id") String commodity_id){
        return commodityComputerService.selectComputerById(commodity_id);
    }

    @RequestMapping("/updateComputerById")
    public void updateComputerById(@RequestBody Commodity_categories_computer computer){
        computer.getCommodity().setName(computer.getComputer_name());
        computer.getCommodity().setPrice(computer.getPrice());
        computer.getCommodity().setCommodity_id(computer.getCommodity_id());
        commodityComputerService.updateComputerById(computer);
    }

    @RequestMapping("/deleteComputerById")
    public void deleteComputerById(@RequestParam String commodity_id){
        commodityService.deleteCommodity(commodity_id);
        commodityComputerService.deleteComputerById(commodity_id);
    }

    @Resource
    Computer_typeService computer_typeService;

    //该方法添加电脑种类{操作系统，电脑类型，品牌}
    @RequestMapping("/addComputerType")
    public void addComputerType(@RequestBody Computer_category computer_category){
        computer_typeService.insertComputerType(computer_category);
    }

    //该方法用于显示所有电脑种类
    @RequestMapping("/selectAllComputerType")
    public List<Computer_category> selectAllComputerType(){
        return computer_typeService.selectAllComputerCategory();
    }

    //删除指定电脑种类
    @RequestMapping("/deleteComputerCategory")
    public void deleteComputerCategory(@RequestBody  Computer_category computer_category){
        computer_typeService.deleteComputerCategory(computer_category);
    }

    @RequestMapping("/selectTypeByFirstType")
    public List<Computer_category> selectTypeByFirstType(Computer_category computer_category){
        return computer_typeService.selectTypeByFirstType(computer_category);
    }

    @RequestMapping("/selectComputerDisByType")
    public List<String> selectComputerDisByType(){
        return commodityComputerService.selectComputerDisByType();
    }

    @RequestMapping("/selectComputerDisByCPU")
    public List<String> selectComputerDisByCPU(){
        return commodityComputerService.selectComputerDisByCPU();
    }

    @RequestMapping("/selectComputerDisByBrand")
    public List<String> selectComputerDisByBrand(){
        return commodityComputerService.selectComputerDisByBrand();
    }

    @RequestMapping("/selComputer")
    public List<Commodity_categories_computer> selComputer(@RequestParam String keyword,@RequestParam String sort){
        System.out.println("电脑排序--关键字："+keyword+"；排序方式："+sort);
        if(keyword.equals("no key")){
            if (sort.equals("no")){
                return commodityComputerService.selectAllComputer();
            }else{
                if(sort.equals("up")){
                    return  commodityComputerService.selectByComputerOrderPriceUp();
                }else if(sort.equals("down")){
                    return commodityComputerService.selectByComputerOrderPrice();
                }else if(sort.equals("nUp")){
                    return commodityComputerService.selectByComputerOrderBySaleNumUp();
                }else if(sort.equals("nDown")){
                    return commodityComputerService.selectByComputerOrderBySaleNumDown();
                }else if (sort.equals("sDown")){
                    return commodityComputerService.selectByComputerOrderByScoreDown();
                }else if(sort.equals("sUp")){
                    return commodityComputerService.selectByComputerOrderByScoreUp();
                }
            }
            }else{
                if(sort.equals("no")){
                    return commodityComputerService.selectByComputerKeyword(keyword);
                }else{
                    if(sort.equals("up")){
                        return  commodityComputerService.selectByComputerOrderByPriceUpByKeyword(keyword);
                    }else if(sort.equals("down")){
                        return commodityComputerService.selectByComputerOrderByPriceDownByKeyword(keyword);
                    }else if(sort.equals("nUp")){
                        return commodityComputerService.selectComputerOrderBySaleNumDownAndKeyword(keyword);
                    }else if(sort.equals("nDown")){
                        return commodityComputerService.selectComputerOrderBySaleNumUpAndKeyword(keyword);
                    }else if(sort.equals("sDown")){
                        return commodityComputerService.selectByComputerOrderByScoreDownByKeyword(keyword);
                    }else if(sort.equals("sUp")){
                        return commodityComputerService.selectByComputerOrderByScoreUpByKeyword(keyword);
                    }
                }
        }
     return null;
    }

}

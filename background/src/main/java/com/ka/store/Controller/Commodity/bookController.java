package com.ka.store.Controller.Commodity;
import java.io.File;
import java.util.List;

import com.ka.store.Service.Category.CommodityTypeService;
import com.ka.store.Service.Commodity.CommodityBookService;
import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Commodity.ImgService;
import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.VO.CommodityVO.addVO.AddBookVO;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.commodity.Category.CategoryType;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.CommodityImg;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_books;
import com.ka.store.pojo.commodity.type.CommodityType.Commodity_type;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/book")
public class bookController {

    @Resource
    CommodityBookService commodityBookService;

    @Resource
    Commodity_categories_books book;

    @Resource
    Commodity commodity;

    @Resource
    CommodityService commodityService;

    @Resource
    ImgService imgService;

    @Resource
    CommodityImg commodityImg;

    @Resource
    usFunc func;

    @Resource
    CommodityTypeService commodityTypeService;

    @Resource
    Commodity_type commodity_type;

    @Resource
    Sales_commodity sales_commodity;

    @Resource
    Sales_commodityService sales_commodityService;

    @RequestMapping("/insertBook")
    public synchronized String insertBook(@RequestBody AddBookVO addBookVO, HttpSession session){
        System.out.println(addBookVO);

        book.setCommodityID(func.getFN("book"));
        book.setBook_name(addBookVO.getCommodity_categories_books().getBook_name());
        book.setNumber_of_pages(addBookVO.getCommodity_categories_books().getNumber_of_pages());
        book.setBook_isbn(addBookVO.getCommodity_categories_books().getBook_isbn());
        book.setPublishing(addBookVO.getCommodity_categories_books().getPublishing());
        book.setBook_brand(addBookVO.getCommodity_categories_books().getBook_brand());
        book.setAuthor(addBookVO.getCommodity_categories_books().getAuthor());
        book.setBook_price(addBookVO.getCommodity_categories_books().getBook_price());
        book.setBook_type(addBookVO.getCommodity_categories_books().getBook_type());
        book.setPublishing_date(addBookVO.getCommodity_categories_books().getPublishing_date());
        System.out.println("----------");
        System.out.println(session.getAttribute("merchantId").toString());
        String merchant_id = session.getAttribute("merchantId").toString();

        commodity.setMerchant_id(session.getAttribute("merchantId").toString());
//        book.getCommodity().setMerchant_id(session.getAttribute("merchantId").toString());
        System.out.println(commodity);
        book.setCommodity(commodity);
//        book.getCommodity().setMerchant_id(merchant_id);
        book.getCommodity().setCategory("图书");
        book.getCommodity().setCommodity_id(book.getCommodityID());
        book.getCommodity().setPrice(book.getBook_price());
        book.getCommodity().setName(book.getBook_name());
        book.getCommodity().setIntroduce(addBookVO.getCommodity_categories_books().getCommodity().getIntroduce());
        System.out.println(book);
        commodityBookService.insertBook(book);
        System.out.println("insert");
        commodity_type.setCommodity_id(book.getCommodityID());

        sales_commodity.setAve_grade("no");
        sales_commodity.setCommodity_id(book.getCommodityID());
        sales_commodity.setSales_num(0);
        System.out.println(sales_commodity);
        sales_commodityService.insertCommoditySalesInfo(sales_commodity);

        for(String type :  addBookVO.getCategoryTypes()){
            commodity_type.setCommodity_type(type);
            commodityTypeService.insertCommodityType(commodity_type);
            System.out.println(type);
        }
        System.out.println(book.getCommodity().getCommodity_id());
        return book.getCommodity().getCommodity_id();
    }

    @RequestMapping("/selectBookCommodityByMerchant")
    public Commodity_categories_books selectBookCommodityByMerchant(@RequestParam String commodity_id){
        return commodityBookService.selectCommodityBooksById(commodity_id);
    }


    @RequestMapping("/selectTest")
    public Commodity_categories_books selectTest(){
        return commodityBookService.selectCommodityBooksById("book-202101191428a");
    }

    @RequestMapping("/selectBookById")
    public Commodity_categories_books selectBookById(@RequestParam String commodity_id){
        return commodityBookService.selectCommodityBooksById(commodity_id);
    }


    @RequestMapping("/updateBookCommodity")
    public void updateBookCommodity(@RequestBody Commodity_categories_books book){
        book.getCommodity().setName(book.getBook_name());
        book.getCommodity().setPrice(book.getBook_price());
        book.getCommodity().setCommodity_id(book.getCommodityID());
        System.out.println("Controller"+book);
        commodityBookService.updateBookCommodity(book);
    }

    @RequestMapping("/deleteBookCommodity")
    public void deleteBookCommodity(@RequestParam(value = "commodity_id", required = false) String commodity_id){
        commodityService.deleteCommodity(commodity_id);
        commodityBookService.deleteBookCommodity(commodity_id);
        imgService.deleteAllCommodityImg(commodity_id);
    }


    @RequestMapping("/selectBookByCategory")
    public List<Commodity_categories_books> selectBookByCategory(@RequestParam String book_type){
        return commodityBookService.selectBookByCategory(book_type);
    }

    @RequestMapping("/selectAllBook")
    public List<Commodity_categories_books> selectAllBook(){
        return commodityBookService.selectAllBook();
    }

    @RequestMapping("/receiveBook_Info")
    @CrossOrigin
    public void receivePhoneInfo(@RequestParam(name="file") MultipartFile file){

        System.out.println(file);
    }

    @RequestMapping("/receiveBookImg")
    @CrossOrigin
    public void receiveBookImg(@RequestParam("file") MultipartFile file ,@RequestParam(value="commodity_id") String commodity_id){
        System.out.println("receiveBookImg");
        String fileName = file.getOriginalFilename();
        String fileType=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String imgPath;
        String fileN = func.getFN("img");
        fileName = fileN+fileType;
        System.out.println(fileName);
        File dest = new File(new File("src\\main\\resources\\static\\images\\commodity").getAbsolutePath()+ "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try{
            imgPath = "images//commodity//"+fileName;
            commodity.setCommodity_id(commodity_id);
            commodity.setMain_img(imgPath);
            file.transferTo(dest);
            System.out.println("commodity_id:"+commodity_id);
            System.out.println("---");
            System.out.println("path:"+imgPath);
            System.out.println("---");
            commodityService.updateMainImg(commodity_id,imgPath);
            commodityImg.setPath(imgPath);
            commodityImg.setCommodity_id(commodity_id);
            System.out.println(commodityImg);
            imgService.insertCommodityImg(commodityImg);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping("/authorOrderBy")
    public List<String> authorOrderBy(){
        System.out.println("authorOrderBy");
        return commodityBookService.selectBookGroupAuthor();
    }

    @RequestMapping("/selectBookGroupByPublishing")
    public List<String> selectBookGroupByPublishing(){
        return commodityBookService.selectBookGroupPublish();
    }

    @RequestMapping("/selectBookLike")
    public List<Commodity_categories_books> selectBookLike(@RequestParam String keyword){
        System.out.println("--");
        return commodityBookService.selectBookLike(keyword);
    }


    @RequestMapping("/selectByBookType")
    public List<Commodity_categories_books> selectByBookType(@RequestParam String commodity_type){
        return commodityBookService.selectByBookType(commodity_type);
    }


    @RequestMapping("/selectByBookOrderPrice")
    public List<Commodity_categories_books> selectByBookOrderPrice(){
        return commodityBookService.selectByBookOrderPrice();
    }

    @RequestMapping("/selectByBookOrderPriceUp")
    public List<Commodity_categories_books> selectByBookOrderPriceUp() {
        return  commodityBookService.selectByBookOrderPriceUp();
    }


    @RequestMapping("/receiveBookInfo")
    public List<Commodity_categories_books> receiveBookInfo(@RequestParam String keyword,@RequestParam String sort){
        System.out.println("图书排序--关键字："+keyword+";排序方式："+sort);
        if(keyword.equals("no key")){
            if(sort.equals("no")){
                return commodityBookService.selectAllBook();
            }else{
                if(sort.equals("up")){
                    return  commodityBookService.selectByBookOrderPriceUp();
                }else if(sort.equals("down")){
                    return commodityBookService.selectByBookOrderPrice();
                }else if(sort.equals("nUp")){
                    return commodityBookService.selectBookOrderBySaleNumUp();
                }else if(sort.equals("nDown")){
                    return commodityBookService.selectBookOrderBySaleNumDown();
                }else if (sort.equals("sDown")){
                    return commodityBookService.selectBookOrderByScoreDown();
                }else if(sort.equals("sUp")){
                    return commodityBookService.selectBookOrderByScoreUp();
                }
            }
        }else{
            if(sort.equals("no")){
                return commodityBookService.selectByBookType(keyword);
            }else{
                if(sort.equals("up")){
                    return  commodityBookService.selectByBookTypeUp(keyword);
                }else if(sort.equals("down")){
                    return commodityBookService.selectByBookTypeDown(keyword);
                }else if(sort.equals("nUp")){
                    return commodityBookService.selectBookOrderBySaleNumUpAndKeyword(keyword);
                }else if(sort.equals("nDown")){
                    return commodityBookService.selectBookOrderBySaleNumDownAndKeyword(keyword);
                }else if(sort.equals("sDown")){
                    return commodityBookService.selectBookOrderByScoreDownByKeyword(keyword);
                }else if(sort.equals("sUp")){
                    return commodityBookService.selectBookOrderByScoreUpByKeyword(keyword);
                }
            }
        }
        return null;
    }

}

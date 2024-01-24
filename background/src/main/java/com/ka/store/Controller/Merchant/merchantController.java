package com.ka.store.Controller.Merchant;

import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Merchant.Apply_merchantService;
import com.ka.store.Service.Merchant.Merchant_InfoService;
import com.ka.store.Service.Merchant.Merchant_loService;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_books;
import com.ka.store.pojo.merchant.Apply_merchant;
import com.ka.store.pojo.merchant.Merchant_Info;
import com.ka.store.pojo.merchant.Merchant_lo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/merchant")
public class merchantController {

    @Resource
    usFunc func;

    @Resource
    Merchant_loService merchant_loService;

    @Resource
    Merchant_Info merchant_info;

    @Resource
    Merchant_InfoService merchant_infoService;

    @Resource
    Merchant_lo merchant;

    @RequestMapping("/merchantLogin")
    public String merchantLogin(@RequestBody Merchant_lo merchant_lo, HttpSession session){
        merchant = merchant_loService.MerchantLogin(merchant_lo);
        if(merchant != null){
            System.out.println(merchant.getMerchantID());
            session.setAttribute("merchantId",merchant.getMerchantID());
            return "success";
        }

        return "error";
    }

    @RequestMapping("/getMerchantId")
    public String getMerchantId(HttpSession session){
        String merchantId = "null";
        try{
            merchantId = session.getAttribute("merchantId").toString();
            return merchantId;
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(merchantId);
        return merchantId;
    }


    @RequestMapping("/merchantLogout")
    public void merchantLogout(HttpSession session){
        session.removeAttribute("merchantId");
    }

    @RequestMapping("/selectMerchantByMerchantID")
    public Merchant_Info selectMerchantByMerchantID(@RequestParam String merchant_id){
        return merchant_infoService.selectMerchantByMerchantID(merchant_id);
    }

    @RequestMapping("/getMerchantInfo")
    public Merchant_Info getMerchantInfo(HttpSession session){
        return merchant_infoService.selectMerchantByMerchantID(session.getAttribute("merchantId").toString());
    }

    @RequestMapping("/selectAllMerchant")
    public List<Merchant_Info> selectAllMerchant(){
        return merchant_infoService.selectAllMerchant();
    }


    @Resource
    Apply_merchantService apply_merchantService;

    @RequestMapping("/registerMerchant")
    public void registerMerchant(@RequestBody Apply_merchant apply_merchant){
        System.out.println("提交申请："+apply_merchant);
        apply_merchant.setStatus("no");
        apply_merchant.setMerchant_id(func.getFN("mer"));
        apply_merchant.setApply_date(func.getDate());
        apply_merchant.setApply_id(func.getFN("apply"));
        apply_merchantService.insertApplyMerchant(apply_merchant);
    }


    @Resource
    CommodityService commodityService;

    @RequestMapping("/merchantHaveCategory")
    public List<String> merchantHaveCategory(HttpSession session){
        List<String> categories =  commodityService.merchantHaveCategory(session.getAttribute("merchantId").toString());
        System.out.println(categories);
        return categories;
    }

    @RequestMapping("/updateMerchantInfo")
    public void updateMerchantInfo(@RequestBody Merchant_Info editMerchant,HttpSession session){
        editMerchant.setMerchant_id(session.getAttribute("merchantId").toString());
        merchant_infoService.updateMerInfo(editMerchant);
    }

    @RequestMapping("/upHeadImg")
    @CrossOrigin
    public void upHeadImg(@RequestParam("file") MultipartFile file,HttpSession session,@RequestParam String merchant_id){
        String fileName = file.getOriginalFilename();
        String fileType=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String img_n = func.getFN("MI");
        String imgPath;
        fileName = img_n+fileType;
        System.out.println(fileName);
        File dest = new File(new File("src\\main\\resources\\static\\images\\merchant").getAbsolutePath()+ "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try{
            imgPath = "images//merchant//"+fileName;
           merchant_info.setMerchant_id(merchant_id);
           merchant_info.setImg(imgPath);
            file.transferTo(dest);
            merchant_infoService.upHeadImg(merchant_info);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

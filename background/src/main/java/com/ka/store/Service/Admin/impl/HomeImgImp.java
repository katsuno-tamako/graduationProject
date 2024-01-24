package com.ka.store.Service.Admin.impl;

import com.ka.store.Service.Admin.HomeImgService;
import com.ka.store.dao.HomeImgDao;
import com.ka.store.pojo.admin.HomeImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class HomeImgImp implements HomeImgService {

    @Resource
    HomeImgDao homeImgDao;

    @Override
    public void insertHomeImg(HomeImg homeImg) {
        homeImgDao.insertHomeImg(homeImg);
    }

    @Override
    public List<HomeImg> selectAllImg() {
        return homeImgDao.selectAllImg();
    }

    @Override
    public void deleteHomeImg(String img) {
        homeImgDao.deleteHomeImg(img);
    }
}

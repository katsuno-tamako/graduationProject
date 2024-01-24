package com.ka.store.Service.Commodity.computer.impl;

import com.ka.store.Service.Commodity.computer.Computer_typeService;
import com.ka.store.dao.Computer_categoryDao;
import com.ka.store.pojo.commodity.computer.Computer_category;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Computer_typeImpl implements Computer_typeService {

    @Resource
    Computer_categoryDao computer_categoryDao;


    @Override
    public void insertComputerType(Computer_category computer_category) {
        computer_categoryDao.insertComputerType(computer_category);
    }

    @Override
    public List<Computer_category> selectAllComputerCategory() {
        return computer_categoryDao.selectAllComputerCategory();
    }

    @Override
    public void deleteComputerCategory(Computer_category computer_category) {
        computer_categoryDao.deleteComputerCategory(computer_category);
    }

    @Override
    public List<Computer_category> selectTypeByFirstType(Computer_category computer_category) {
        return computer_categoryDao.selectTypeByFirstType(computer_category);
    }
}

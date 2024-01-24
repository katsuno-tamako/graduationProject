package com.ka.store.Service.Commodity.computer;

import com.ka.store.pojo.commodity.computer.Computer_category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Computer_typeService {

    public void insertComputerType(Computer_category computer_category);

    public List<Computer_category> selectAllComputerCategory();

    public void deleteComputerCategory(Computer_category computer_category);

    public List<Computer_category> selectTypeByFirstType(Computer_category computer_category);



}

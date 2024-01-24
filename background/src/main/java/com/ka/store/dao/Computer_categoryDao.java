package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.commodity.computer.Computer_category;
import org.springframework.stereotype.Repository;

@Repository
public interface Computer_categoryDao {

    public void insertComputerType(Computer_category computer_category);

    public List<Computer_category> selectAllComputerCategory();

    public void deleteComputerCategory(Computer_category computer_category);

    public List<Computer_category> selectTypeByFirstType(Computer_category computer_category);

}

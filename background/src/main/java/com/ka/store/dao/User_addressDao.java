package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.user.User_address;
import org.springframework.stereotype.Repository;

@Repository
public interface User_addressDao {

    public void insertAddress(User_address user_address);

    public List<User_address> selectAddressByUser(String user_id);

    public void updateAddress(User_address user_address);

    public void deleteAddress(int id);

}

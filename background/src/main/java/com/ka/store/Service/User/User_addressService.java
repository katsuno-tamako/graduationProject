package com.ka.store.Service.User;
import java.util.List;
import com.ka.store.pojo.user.User_address;
import org.springframework.stereotype.Service;

@Service
public interface User_addressService {

    public void insertAddress(User_address user_address);

    public List<User_address> selectUserAddress(String user_id);

    public void deleteAddress(int id);

    public void updateAddress(User_address user_address);



}

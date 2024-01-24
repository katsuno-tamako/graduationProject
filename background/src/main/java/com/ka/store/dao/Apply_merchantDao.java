package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.merchant.Apply_merchant;
import org.springframework.stereotype.Repository;

@Repository
public interface Apply_merchantDao {

    public void insertApplyMerchant(Apply_merchant apply_merchant);

    public List<Apply_merchant> selectAllApplyMerchant();

    public void updateApplyStatus(Apply_merchant apply_merchant);



}

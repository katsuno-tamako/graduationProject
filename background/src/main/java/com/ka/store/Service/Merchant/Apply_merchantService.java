package com.ka.store.Service.Merchant;
import java.util.List;
import com.ka.store.pojo.merchant.Apply_merchant;
import org.springframework.stereotype.Service;

@Service
public interface Apply_merchantService {

    public void insertApplyMerchant(Apply_merchant apply_merchant);

    public List<Apply_merchant> selectAllApplyMerchant();

    public void updateApplyStatus(Apply_merchant apply_merchant);

}

package com.ka.store.Service.Admin;
import java.util.List;
import com.ka.store.pojo.admin.HomeImg;
import org.springframework.stereotype.Service;

@Service
public interface HomeImgService {

    public void insertHomeImg(HomeImg homeImg);

    public List<HomeImg> selectAllImg();

    public void deleteHomeImg(String img);

}

package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.admin.HomeImg;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeImgDao {

    public void insertHomeImg(HomeImg homeImg);

    public List<HomeImg> selectAllImg();

    public void deleteHomeImg(String img);

}

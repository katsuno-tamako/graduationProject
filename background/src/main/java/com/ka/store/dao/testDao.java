package com.ka.store.dao;
import java.util.List;
import org.junit.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface testDao {

    public List<Test> selectTest();

}

package com.ka.store.dao;
import java.util.List;

import com.ka.store.pojo.user.Security_question;
import org.springframework.stereotype.Repository;

@Repository
public interface Security_questionDao {

        public List<Security_question> selectAllQuestion();

        public void insertQuestion(Security_question question);

        public void deleteQuestion(String que_id);

        public void updateQuestion(Security_question question);


}

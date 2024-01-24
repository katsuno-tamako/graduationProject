package com.ka.store.Service.User;

import com.ka.store.pojo.user.Security_question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Security_questionService {

    public List<Security_question> selectAllQuestion();

    public void insertQuestion(Security_question question);

    public void deleteQuestion(String que_id);

    public void updateQuestion(Security_question question);

}

package com.ka.store.Service.User;

import com.ka.store.pojo.user.User_security_question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface User_security_questionService {

    public void insertQuesByUser(User_security_question user_security_question);

    public List<User_security_question> selectQuestionByUser(User_security_question user_security_question);

    public void updateQuestion(User_security_question user_security_question);

    public List<User_security_question> selectQuestionByAccount(String user_id);

    public User_security_question equSucQue(User_security_question question);

    public List<User_security_question> haveAccountSelectQ(String account);

}

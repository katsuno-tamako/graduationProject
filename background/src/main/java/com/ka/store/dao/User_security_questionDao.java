package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.user.User_security_question;
import org.springframework.stereotype.Repository;

@Repository
public interface User_security_questionDao {

    public void insertQuesByUser(User_security_question user_security_question);

    public List<User_security_question> selectQuestionByUser(User_security_question user_security_question);

    public void updateQuestion(User_security_question user_security_question);

    public List<User_security_question> selectQuestionByAccount(String user_id);

    public User_security_question equSucQue(User_security_question question);

    public List<User_security_question> haveAccountSelectQ(String account);


}

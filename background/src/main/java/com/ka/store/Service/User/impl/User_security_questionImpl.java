package com.ka.store.Service.User.impl;

import com.ka.store.Service.User.User_security_questionService;
import com.ka.store.dao.User_security_questionDao;
import com.ka.store.pojo.user.User_security_question;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class User_security_questionImpl implements User_security_questionService {

    @Resource
    User_security_questionDao user_security_questionDao;

    @Override
    public void insertQuesByUser(User_security_question user_security_question) {
        user_security_questionDao.insertQuesByUser(user_security_question);
    }

    @Override
    public List<User_security_question> selectQuestionByUser(User_security_question user_security_question) {
        return user_security_questionDao.selectQuestionByUser(user_security_question);
    }

    @Override
    public void updateQuestion(User_security_question user_security_question) {
        System.out.println(user_security_question);
        user_security_questionDao.updateQuestion(user_security_question);
    }

    @Override
    public List<User_security_question> selectQuestionByAccount(String user_id) {
        return user_security_questionDao.selectQuestionByAccount(user_id);
    }

    @Override
    public User_security_question equSucQue(User_security_question question) {
        return user_security_questionDao.equSucQue(question);
    }

    @Override
    public List<User_security_question> haveAccountSelectQ(String account) {
        return user_security_questionDao.haveAccountSelectQ(account);
    }
}

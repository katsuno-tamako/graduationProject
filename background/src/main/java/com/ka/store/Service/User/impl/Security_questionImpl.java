package com.ka.store.Service.User.impl;

import com.ka.store.Service.User.Security_questionService;
import com.ka.store.dao.Security_questionDao;
import com.ka.store.pojo.user.Security_question;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Security_questionImpl implements Security_questionService {

    @Resource
    Security_questionDao security_questionDao;

    @Override
    public List<Security_question> selectAllQuestion() {
        return security_questionDao.selectAllQuestion();
    }

    @Override
    public void insertQuestion(Security_question question) {
        security_questionDao.insertQuestion(question);
    }

    @Override
    public void deleteQuestion(String que_id) {
        security_questionDao.deleteQuestion(que_id);
    }

    @Override
    public void updateQuestion(Security_question question) {
        security_questionDao.updateQuestion(question);
    }
}

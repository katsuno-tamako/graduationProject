package com.ka.store.Service.Order.impl;

import com.ka.store.Service.Order.CommentService;
import com.ka.store.dao.CommentDao;
import com.ka.store.pojo.comment.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CommentImpl implements CommentService {

    @Resource
    CommentDao commentDao;

    @Override
    public void insertComment(Comment comment) {
        commentDao.insertComment(comment);
    }

    @Override
    public List<Comment> selectCommentByCommodityId(String comment) {
        return commentDao.selectCommentByCommodityId(comment);
    }

    @Override
    public String eqCom(String commodity_id, String user_id) {
        System.out.println("id:");
        System.out.println(commodity_id);
        System.out.println(user_id);

        System.out.println("---"+commentDao.eqCom(commodity_id,user_id));

        List<Comment> comments = commentDao.eqCom(commodity_id,user_id);
        System.out.println(comments);

        if(comments.size()==0){
            return "No";
        }else{
            return "Yes";
        }
    }
}

package com.ka.store.dao;

import com.ka.store.pojo.comment.Comment;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CommentDao {

    public void insertComment(Comment comment);

    public List<Comment> selectCommentByCommodityId(String commodity_id);

    public List<Comment> eqCom(String commodity_id,String user_id);

}

package com.ka.store.Service.Order;

import com.ka.store.pojo.comment.Comment;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface CommentService {

    public void insertComment(Comment comment);

    public List<Comment> selectCommentByCommodityId(String comment);

    public String eqCom(String commodity_id,String user_id);

}

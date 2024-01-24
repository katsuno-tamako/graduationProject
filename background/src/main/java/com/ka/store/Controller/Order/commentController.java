package com.ka.store.Controller.Order;

import com.ka.store.Service.Order.CommentService;
import com.ka.store.Service.Order.Order_infoService;
import com.ka.store.Service.User.UserInfoService;
import com.ka.store.pojo.comment.Comment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/comment")
public class commentController {

    @Resource
    CommentService commentService;

    @Resource
    UserInfoService userInfoService;

    @RequestMapping("/insertComment")
    public void insertComment(@RequestBody Comment comment){

        System.out.println(comment);

        Date date = new Date();
        String sDate = String.format("%tF",date);

        String userName = userInfoService.selectUserInfo(comment.getUser_id()).getUser_name();
        comment.setUser_name(userName);
        comment.setComment_date(sDate);
        comment.setComment_id(sDate);
        comment.setLikeNum(0);
        System.out.println(comment);

        commentService.insertComment(comment);
    }

    @RequestMapping("/selectCommentByCommodityId")
    public List<Comment> selectCommentByCommodityId(@RequestParam String commodity_id){
        return commentService.selectCommentByCommodityId(commodity_id);
    }


    @RequestMapping("/giveLike")
    public void giveLike(){

    }

    @Resource
    Order_infoService order_infoService;

    @RequestMapping("/eqCom")
    public String eqCom(@RequestParam String commodity_id,@RequestParam String user_id){
        return order_infoService.equOrder(commodity_id,user_id);
    }

}

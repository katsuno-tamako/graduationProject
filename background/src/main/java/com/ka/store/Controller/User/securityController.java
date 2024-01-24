package com.ka.store.Controller.User;
import java.util.List;
import com.ka.store.Service.User.Security_questionService;
import com.ka.store.Service.User.User_security_questionService;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.user.Security_question;
import com.ka.store.pojo.user.User_security_question;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/security_q")
public class securityController {

    @Resource
    usFunc func;

    @Resource
    Security_question security_question;

    @Resource
    User_security_question user_security_question;

    @Resource
    User_security_questionService user_security_questionService;

    @Resource
    Security_questionService security_questionService;

    @RequestMapping("/selectAllQuestion")
    public List<Security_question> selectAllQuestion(){
        return security_questionService.selectAllQuestion();
    }

    @RequestMapping("/insertQuestion")
    public void insertQuestion(@RequestParam String qu){
        security_question.setQuestion(qu);
        security_question.setQue_id(func.getFN("qu"));
        security_questionService.insertQuestion(security_question);
    }



    @RequestMapping("/updateQuestion")
    public void updateQuestion(@RequestBody Security_question ed){
        security_questionService.updateQuestion(ed);
        //代码段
    }


    @RequestMapping("/insertSecQueByUser")
    public synchronized void insertSecQueByUser(@RequestParam String que_id, @RequestParam String ans,HttpSession session){
        user_security_question.setUser_id(session.getAttribute("user").toString());
        user_security_question.setQue_id(que_id);
        user_security_question.setAns(ans);
        System.out.println("insertSecQueByUser:");
        System.out.println(user_security_question);

        user_security_questionService.insertQuesByUser(user_security_question);
    }


    @RequestMapping("/selectQuestionByUserId")
    public List<User_security_question> selectQuestionByUserId(HttpSession session){
        user_security_question.setUser_id(session.getAttribute("user").toString());
        List<User_security_question> s = user_security_questionService.selectQuestionByUser(user_security_question);
        System.out.println(s);
        System.out.println(s.size());
        if(s.size()==0){
            return null;
        }else{
            return s;
        }
    }

    @RequestMapping("/updateQuestionByUser")
    public synchronized void updateQuestionByUser(@RequestBody User_security_question[] updateQuestion,HttpSession session){
        for(User_security_question question : updateQuestion){
            System.out.println(question);
            System.out.println("Question id"+question.getQue_id());
            question.setUser_id(session.getAttribute("user").toString());
            user_security_questionService.updateQuestion(question);
        }
    }

    @RequestMapping("/selectQuestionByAccount")
    public List<User_security_question> selectQuestionByAccount(@RequestParam String account){
        return user_security_questionService.selectQuestionByAccount(account);
    }

    @RequestMapping("/equSucQue")
    public String equSucQue(@RequestBody User_security_question question){

        if(user_security_questionService.equSucQue(question)!=null){
            return "SUCCESS";
        }else{
            return "ERROR";
        }
    }

    @RequestMapping("/haveAccountSelectQ")
    public String haveAccountSelectQ(@RequestParam String account){
        System.out.println(user_security_questionService.haveAccountSelectQ(account));
        if(user_security_questionService.haveAccountSelectQ(account).size()!=0){
            return "SUCCESS";
        }else{
            return "ERROR";
        }
    }

    @RequestMapping("/deleteQuestion")
    public void deleteQuestion(@RequestParam String que_id){
        security_questionService.deleteQuestion(que_id);
    }

}

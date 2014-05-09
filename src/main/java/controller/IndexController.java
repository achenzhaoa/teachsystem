package controller;

import mongo.CRUD;
import mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dell on 2014/5/6.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private CRUD mongoDb;

    @RequestMapping(value = "index.vpage")
    String goToIndex(Model model){
        return "index";
    }

    @RequestMapping(value = "login.vpage", method = RequestMethod.POST)
    String login(@RequestParam("name") String name,
                 @RequestParam("pwd") String pwd,Model model){
        User currentUser = mongoDb.login(name,pwd);
        if(currentUser!=null){
            return "studentMainPage";
        }else{
            model.addAttribute("err","用户名或密码错误，请重新输入");
            return "forward:/index.vpage";
        }

    }


}

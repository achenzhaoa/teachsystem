package controller;

import mongo.CRUD;
import mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dell on 2014/5/6.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private CRUD crud;

    @RequestMapping(value = "index.vpage", method = RequestMethod.GET)
    String goToIndex(Model model){
        model.addAttribute("index","hello world");
        User user = new User("chenzhao",26);
        crud.saveObject(user);
        model.addAttribute("user",crud.getAllObjects());
        return "index";
    }


}

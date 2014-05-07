package controller;
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
    @RequestMapping(value = "index.vpage", method = RequestMethod.GET)
    String goToIndex(Model model){
        model.addAttribute("index","hello world");
        return "index";
    }
}

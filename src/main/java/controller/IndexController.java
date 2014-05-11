package controller;

import com.mongodb.gridfs.GridFSDBFile;
import mongo.CRUD;
import mongo.ReadFile;
import mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dell on 2014/5/6.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private CRUD mongoDb;
    @Autowired
    private ReadFile readFile;

    @RequestMapping(value = "index.vpage")
    String goToIndex(Model model) {
        return "index";
    }

    @RequestMapping(value = "login.vpage", method = RequestMethod.POST)
    String login(@RequestParam("name") String name,
                 @RequestParam("pwd") String pwd, Model model) {
        User currentUser = mongoDb.login(name, pwd);
        if (currentUser != null) {
            return "studentMainPage";
        } else {
            model.addAttribute("err", "用户名或密码错误，请重新输入");
            return "forward:/index.vpage";
        }

    }

    @RequestMapping(value = "/uploadFile.vpage", method=RequestMethod.POST)
    String uploadFile(@RequestParam("filedata") MultipartFile file,Model model){
        String originalFileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        try {
            InputStream stream = file.getInputStream();
            mongoDb.uploadFile(originalFileName,contentType,stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "true";
    }

    @RequestMapping(value = "/files/{filename}.{filetype}",method = RequestMethod.GET)
    void readFile(@PathVariable String filename,
                  @PathVariable String filetype,
                  HttpServletResponse response){
        String fllFileName = filename+"."+filetype;
        GridFSDBFile file = readFile.getFile(fllFileName);
        String contentType = file.getContentType();
        response.setContentType(contentType);
        response.setCharacterEncoding("utf8");
        try {
            file.writeTo(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
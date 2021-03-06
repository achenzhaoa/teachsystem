package controller;

import com.mongodb.gridfs.GridFSDBFile;
import mongo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by dell on 2014/5/6.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService mongoDb;
    @Autowired
    private ReadFile readFile;
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "portal.vpage")
    String goToPortal(){
        return "portal";
    }
    @RequestMapping(value = "index.vpage")
    String goToIndex(Model model) {
        return "index";
    }

    @RequestMapping(value = "login.vpage", method = RequestMethod.POST)
    String login(@RequestParam("name") String name,
                 @RequestParam("pwd") String pwd, Model model) {
        User currentUser = mongoDb.login(name, pwd);
        if (currentUser != null) {
            if(currentUser.isActive()){
                String userName = currentUser.getName();
                if(userName.equals("admin")){
                    return "redirect:admin/index.vpage";
                }else if(userName.equals("student")){
                    return "redirect:/studentMainPage.vpage";
                }else{
                    return "redirect:/teacherMainPage.vpage";
                }
            }else{
                model.addAttribute("err", "该用户没有被激活，请联系管理员");
                return "forward:/index.vpage";
            }
        } else {
            model.addAttribute("err", "用户名或密码错误，请重新输入");
            return "forward:/index.vpage";
        }
    }

    @RequestMapping(value = "changepwdIndex.vpage",method = RequestMethod.GET)
    String changePwdIndex(){
        return "changepwd";
    }
    @RequestMapping(value = "changepwd.vpage",method = RequestMethod.POST)
    String changePwd(@RequestParam("name")String name,
                     @RequestParam("pwd")String pwd,
                     @RequestParam("newpwd")String newPwd,
                     Model model){
        User currentUser = mongoDb.login(name,pwd);
        if(currentUser == null){
            model.addAttribute("err","您的用户名或原始密码错误");
            return "changepwd";
        }else{
            mongoDb.changePwd(name, pwd, newPwd);
        }
        model.addAttribute("info","修改密码成功");
        return "success";
    }

    @RequestMapping(value = "findPwdIndex.vpage",method = RequestMethod.GET)
    String findPwdIndex(){
        return "findPwd";
    }

    @RequestMapping(value = "findPwd.vpage",method = RequestMethod.POST)
    String findPwd(@RequestParam("name")String name,
                   Model model){
            User user = mongoDb.findPwd(name);
        if(user==null){
            model.addAttribute("err","该用户不存在");
        }else {
            model.addAttribute("pwd",user.getPwd());
        }
        return "findPwd";
    }

    @RequestMapping(value = "register.vpage",method = RequestMethod.GET)
    String registerIndex(Model model){
        model.addAttribute("actionUrl","/register.vpage");
        model.addAttribute("roles",roleService.listRole().toArray());
        return "register";
    }

    @RequestMapping(value = "register.vpage",method = RequestMethod.POST)
    String register(@RequestParam("name")String name,
                    @RequestParam("pwd")String pwd,
                    @RequestParam("role")String role,
                    @RequestParam("message")String desc,
                    Model model){
        User user = new User(name,pwd,false);
        user.setDesc(desc);
        user.setRole(role);
        this.mongoDb.insertUser(user);
        model.addAttribute("info","您注册成功了，等管理员激活您的帐号之后就可以使用了");
        return "success";
    }

    @RequestMapping(value = "/uploadFile.vpage", method=RequestMethod.POST)
    String uploadFile(@RequestParam("filedata") MultipartFile file,Model model,
                      HttpServletResponse response) throws IOException {
        String originalFileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        int pointIndex = originalFileName.lastIndexOf(".");
        String filename = originalFileName.substring(0,pointIndex);
        System.out.println(filename);
        String filetype = originalFileName.substring(pointIndex + 1);
        System.out.println(filetype);
        Resource resource = new ClassPathResource("swfconfig.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        String baseSwfDir = props.getProperty("swfCacheDir");
        try {
            InputStream stream = file.getInputStream();
            mongoDb.uploadFile(originalFileName,contentType,stream);
            File fs = new File(baseSwfDir+originalFileName);
            file.transferTo(fs);
            //转换为swf格式文件
            if(filetype.equals("doc")
                    ||filetype.equals("docx")
                    ||filetype.equals("ppt")
                    ||filetype.equals("pptx")
                    ||filetype.equals("xls")
                    ||filetype.equals("xlsx")){
                //当为这几种格式时，转为swf格式存储起来
                readFile.convertSwf(fs,filename,filetype,baseSwfDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/studentMainPage.vpage";
    }

    @RequestMapping(value = "/files/{filename}.{filetype}",method = RequestMethod.GET)
    void readFile(@PathVariable String filename,
                  @PathVariable String filetype,
                  HttpServletResponse response) throws IOException {
        if(isSwf(filetype)){
            filetype = "swf";
            //response.sendRedirect("/swf/"+filename+".swf");
        }
        String fullFileName = filename+"."+filetype;
        GridFSDBFile file = readFile.getFile(fullFileName);
        String contentType = file.getContentType();
        response.setContentType(contentType);
        response.setCharacterEncoding("utf8");
        try {
            file.writeTo(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "studentMainPage.vpage",method = RequestMethod.GET)
    String toStudentIndex(Model model){
        model.addAttribute("files",this.getFileList());
        return "studentMainPage";
    }

    @RequestMapping(value = "teacherMainPage.vpage",method = RequestMethod.GET)
    String toTeacherIndex(Model model){
        model.addAttribute("files",this.getFileList());
        return "teacherMainPage";
    }

    @RequestMapping(value = "removefile.vpage",method = RequestMethod.GET)
    String removeFile(@RequestParam("id")String id){
        readFile.removeFile(id);
        return "redirect:/teacherMainPage.vpage";
    }

    private boolean isSwf(String filetype){
        if(filetype.equals("doc")
                ||filetype.equals("docx")
                ||filetype.equals("ppt")
                ||filetype.equals("pptx")
                ||filetype.equals("xls")
                ||filetype.equals("xlsx")) {
            return true;
        }else{
            return false;
        }
    }

    private List<GFSfile> getFileList(){
        List<GFSfile> lists = new ArrayList<GFSfile>();
        List<GridFSDBFile> list = readFile.listFiles();
        for(GridFSDBFile file : list){
            GFSfile item = new GFSfile();
            String fileName = file.getFilename();
            item.setFileName(file.getFilename());
            item.setDate(file.getUploadDate().toLocaleString());
            item.setId(file.getId().toString());
            item.setDescription("测试文件");
            String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
            item.setType(fileType);
            if(isSwf(fileType)){
                item.setUrl("/swf/"+fileName.substring(0,fileName.lastIndexOf("."))+".swf");
            }else{
                item.setUrl("files/"+fileName);
            }
            lists.add(item);
        }
        return lists;
    }
}
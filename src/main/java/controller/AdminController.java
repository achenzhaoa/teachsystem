package controller;

import mongo.Role;
import mongo.RoleService;
import mongo.User;
import mongo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by chenzhao on 14-5-14.
 */
@Controller
public class AdminController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @RequestMapping(value="admin/index.vpage",method = RequestMethod.GET)
    public String index(){
        return "admin/index";
    }
    @RequestMapping(value = "rolelist.vpage", method= RequestMethod.GET)
    public String roleList(Model model){
        List<Role> roles = roleService.listRole();
        model.addAttribute("roles",roles.toArray());
        return "admin/rolelist";
    }

    @RequestMapping(value = "addrole.vpage", method = RequestMethod.GET)
    public String addRoleIndex(){
        return "admin/addrole";
    }

    @RequestMapping(value = "addrole.vpage", method = RequestMethod.POST)
    public String addRole(
            @RequestParam("name")String name,
            @RequestParam("desc")String desc,
            Model model){
        Role role = new Role(name,desc);
        this.roleService.insertRole(role);
        return "redirect:/rolelist.vpage";
    }

    @RequestMapping(value = "deleteRole.vpage", method = RequestMethod.GET)
    public String deleteRole(@RequestParam("id")String id){
        this.roleService.deleteRoleById(id);
        return "redirect:/rolelist.vpage";
    }

    @RequestMapping(value = "userlist.vpage",method=RequestMethod.GET)
    public String userList(Model model){
        List<User> users = userService.getAllObjects();
        model.addAttribute("users",users.toArray());
        return "admin/userlist";
    }

    @RequestMapping(value = "adduser.vpage",method = RequestMethod.GET)
    public String addUserRegister(Model model){
        model.addAttribute("actionUrl","/adduser.vpage");
        model.addAttribute("roles",roleService.listRole().toArray());
        return "register";
    }

    @RequestMapping(value = "adduser.vpage",method = RequestMethod.POST)
    public String addUser(@RequestParam("name")String name,
                          @RequestParam("pwd")String pwd,
                          @RequestParam("role")String role,
                          @RequestParam("message")String desc,
                          Model model){
        User user = new User(name,pwd,true);
        user.setDesc(desc);
        user.setRole(role);
        this.userService.insertUser(user);
        return "redirect:/userlist.vpage";
    }

    @RequestMapping(value = "deleteUser.vpage",method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id")String id){
        this.userService.deleteUser(id);
        return "redirect:/userlist.vpage";
    }

    @RequestMapping(value = "activeUser.vpage",method = RequestMethod.GET)
    public String activeUser(@RequestParam("id")String id){
        this.userService.setActiveUser(id,true);
        return "redirect:/userlist.vpage";
    }
}

package controller;

import mongo.Role;
import mongo.RoleService;
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
        return "admin/rolelist";
    }

    @RequestMapping(value = "deleteRole.vpage", method = RequestMethod.GET)
    public String deleteRole(@RequestParam("id")String id){
        this.roleService.deleteRoleById(id);
        return "redirect:/rolelist.vpage";
    }
}

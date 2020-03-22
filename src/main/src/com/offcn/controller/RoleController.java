package com.offcn.controller;

import com.offcn.pojo.Role;
import com.offcn.service.RoleService;
import com.offcn.service.RoleSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-29 14:44
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleSourcesService roleSourcesService;

    @RequestMapping("/addRole")
    public String addRole(Role role,String sourcesid){
        int roleid = roleService.insertRoleFRid(role);
        /*System.out.println("roleid:::"+role.getRoleid());
        System.out.println("sourcesid:::"+sourcesid);*/
        roleSourcesService.insertByRidSid(role.getRoleid(),sourcesid);
        return "role";
    }

    @RequestMapping("/getRoleList")
    @ResponseBody
    public List<Role> getRoleList(){
        return roleService.selectRolePro();
    }
}

package com.tr.login.shiro.service.impl;

import com.tr.login.shiro.entity.Permission;
import com.tr.login.shiro.entity.Role;
import com.tr.login.shiro.entity.User;
import com.tr.login.shiro.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rtao
 * @date 2022/1/13 17:16
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public User getUserByName(String userName) {
        return getMapByName(userName);
    }

    /**
     * 模拟数据库查询
     *
     * @param userName 用户名
     * @return User
     */
    private User getMapByName(String userName) {
        Permission permissionIndex = new Permission(1, "index");
        Permission permissionAdd = new Permission(2, "add");

        Set<Permission> permissionSetAdmin = new HashSet<>();
        permissionSetAdmin.add(permissionIndex);
        permissionSetAdmin.add(permissionAdd);
        Role roleAdmin = new Role(1, "admin", permissionSetAdmin);
        Set<Role> roleSetAdmin = new HashSet<>();
        roleSetAdmin.add(roleAdmin);
        User admin = new User(1, "admin", "123456", null, roleSetAdmin);

        Set<Permission> permissionSetUser = new HashSet<>();
        permissionSetUser.add(permissionIndex);
        Role roleUser = new Role(2, "user", permissionSetUser);
        Set<Role> roleSetUser = new HashSet<>();
        roleSetUser.add(roleUser);
        User user = new User(2, "user", "123456", null, roleSetUser);

        Map<String, User> map = new HashMap<>();
        map.put(admin.getUsername(), admin);
        map.put(user.getUsername(), user);
        return map.get(userName);
    }

}

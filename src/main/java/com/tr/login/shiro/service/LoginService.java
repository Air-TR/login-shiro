package com.tr.login.shiro.service;

import com.tr.login.shiro.entity.User;

/**
 * @author rtao
 * @date 2022/1/13 17:16
 */
public interface LoginService {

    User getUserByName(String userName);

}

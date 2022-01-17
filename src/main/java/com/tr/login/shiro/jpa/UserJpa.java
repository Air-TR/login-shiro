package com.tr.login.shiro.jpa;

import com.tr.login.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rtao
 * @date 2022/1/5 11:08
 */
public interface UserJpa extends JpaRepository<User, Integer> {
}

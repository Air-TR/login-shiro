package com.tr.login.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Set;

/**
 * 用户
 *
 * @author rtao
 * @date 2022/1/5 11:01
 */
@Data
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private String phone;

    /** 用户对应的角色集合 */
    @Transient
    private Set<Role> roles;

}

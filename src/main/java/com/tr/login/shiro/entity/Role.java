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
 * 角色
 *
 * @author rtao
 * @date 2022/1/11 16:55
 */
@Data
@AllArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;

    /** 角色对应权限集合 */
    @Transient
    private Set<Permission> permission;

}

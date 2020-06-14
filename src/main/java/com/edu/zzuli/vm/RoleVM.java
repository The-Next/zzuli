package com.edu.zzuli.vm;

import com.edu.zzuli.entity.Privilege;
import com.edu.zzuli.entity.Role;

import java.util.List;

/**
 * @Classname RoleVM
 * @Description TODO
 * @Date 2020/6/14 15:16
 * @Created by cccp
 */
public class RoleVM {
    private Role role;
    private List<Privilege> privileges;

    public RoleVM() {
    }

    public RoleVM(Role role, List<Privilege> privileges) {
        this.role = role;
        this.privileges = privileges;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

}

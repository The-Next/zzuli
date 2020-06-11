package com.edu.zzuli.entity.extend;

import com.edu.zzuli.entity.Role;
import com.edu.zzuli.entity.User;

/**
 * @Classname UserExtend
 * @Description TODO
 * @Date 2020/6/11 20:52
 * @Created by cccp
 */
public class UserExtend extends User {
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

package com.edu.zzuli.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private Long id;

    private String name;

    private Integer nu;

    private Long parentId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNu() {
        return nu;
    }

    public void setNu(Integer nu) {
        this.nu = nu;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
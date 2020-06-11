package com.edu.zzuli.entity.extend;

import com.edu.zzuli.entity.Category;

import java.util.List;

public class CategoryExtend extends Category {
    private List<Category> children;

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
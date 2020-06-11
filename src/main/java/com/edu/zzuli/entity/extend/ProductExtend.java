package com.edu.zzuli.entity.extend;

import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.Product;

public class ProductExtend extends Product {
    private Category category;
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}

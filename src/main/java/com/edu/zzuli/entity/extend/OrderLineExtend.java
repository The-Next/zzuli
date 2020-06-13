package com.edu.zzuli.entity.extend;

import com.edu.zzuli.entity.OrderLine;
import com.edu.zzuli.entity.Product;

/**
 * @ClassName OrderLineExtend
 * @Description todo
 * @Author CY
 * @Date 2020/06/13 10:29
 */
public class OrderLineExtend extends OrderLine {
    private Product product;
    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

package com.demo.router.service;

import com.demo.router.base.enums.ProductType;

/**
 * @author bowen.yan
 * @since 2021-02-28
 */
public abstract class AbstractProductService {
    public void print(ProductType productType) {
        System.out.println(getProductServicePrefix() + " - " + productType);
    }

    protected abstract String getProductServicePrefix();
}

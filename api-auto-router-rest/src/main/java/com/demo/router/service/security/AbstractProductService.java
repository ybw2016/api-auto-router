package com.demo.router.service.security;

import com.demo.router.base.enums.ProductType;

/**
 * @author bowen.yan
 * @since 2021-02-28
 */
public abstract class AbstractProductService {
    public void print(ProductType productType) {
        System.out.println("Security **************** " + getProductServicePrefix() + " - " + productType);
    }

    protected abstract String getProductServicePrefix();
}

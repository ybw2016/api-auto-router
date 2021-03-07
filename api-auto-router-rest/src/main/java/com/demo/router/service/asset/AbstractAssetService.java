package com.demo.router.service.asset;

import com.demo.router.base.enums.ProductType;

/**
 * @author bowen.yan
 * @date 2021-03-07
 */
public abstract class AbstractAssetService {
    public void print(ProductType productType) {
        System.out.println("Asset --------> " + getProductServicePrefix() + " - " + productType);
    }

    protected abstract String getProductServicePrefix();
}

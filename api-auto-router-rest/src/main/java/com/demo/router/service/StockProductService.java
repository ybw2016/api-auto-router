package com.demo.router.service;

import com.demo.router.base.annotation.RouterNew;
import com.demo.router.base.enums.ProductType;
import org.springframework.stereotype.Service;

/**
 * @author bowen.yan
 * @since 2021-02-28
 */
@RouterNew(bizEnum = ProductType.class, bizEnumName = "STOCK")
@Service
public class StockProductService extends AbstractProductService {
    @Override
    protected String getProductServicePrefix() {
        return "STOCK";
    }
}

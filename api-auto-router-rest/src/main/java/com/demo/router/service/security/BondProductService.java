package com.demo.router.service.security;

import com.demo.router.base.annotation.RouterNew;
import com.demo.router.base.enums.ProductType;
import org.springframework.stereotype.Service;

/**
 * @author bowen.yan
 * @since 2021-02-28
 */
@RouterNew(bizEnum = ProductType.class, bizEnumName = "BOND")
@Service
public class BondProductService extends AbstractProductService {
    @Override
    protected String getProductServicePrefix() {
        return "bond2021";
    }
}

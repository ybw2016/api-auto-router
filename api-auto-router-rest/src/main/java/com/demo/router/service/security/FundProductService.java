package com.demo.router.service.security;

import com.demo.router.base.annotation.RouterNew;
import com.demo.router.base.enums.ProductType;
import org.springframework.stereotype.Service;

/**
 * @author bowen.yan
 * @since 2021-02-28
 */
@RouterNew(bizEnum = ProductType.class, bizEnumName = "FUND")
@Service
public class FundProductService extends AbstractProductService {
    @Override
    protected String getProductServicePrefix() {
        return "fund2021";
    }
}

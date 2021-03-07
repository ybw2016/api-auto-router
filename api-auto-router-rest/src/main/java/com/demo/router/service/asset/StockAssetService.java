package com.demo.router.service.asset;

import com.demo.router.base.annotation.RouterNew;
import com.demo.router.base.constant.ServiceGroupConstant;
import com.demo.router.base.enums.ProductType;
import org.springframework.stereotype.Service;

/**
 * @author bowen.yan
 * @date 2021-03-07
 */
@RouterNew(bizGroup = ServiceGroupConstant.ASSET_ROUTER, bizEnum = ProductType.class, bizEnumName = "STOCK")
@Service
public class StockAssetService extends AbstractAssetService {
    @Override
    protected String getProductServicePrefix() {
        return "stock_asset";
    }
}

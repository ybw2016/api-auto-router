package com.demo.router.sh.factory;

import com.demo.router.base.annotation.Router;
import com.demo.router.base.annotation.RouterNew;
import com.demo.router.base.enums.RouterType;
import com.demo.router.base.facade.AssetService;
import com.demo.router.base.facade.ProductService;
import com.demo.router.base.facade.TradeService;
import com.demo.router.base.factory.AbstractRouterFactory;
import com.demo.router.sh.facade.ShAssetServiceImpl;
import com.demo.router.sh.facade.ShProductServiceImpl;
import com.demo.router.sh.facade.ShTradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RouterNew(bizEnum = RouterType.class, bizEnumName = "SH")
@Router(RouterType.SH)
@Service
public class ShRouterFactory implements AbstractRouterFactory {
    @Autowired
    private ShAssetServiceImpl assetService;
    @Autowired
    private ShProductServiceImpl productService;
    @Autowired
    private ShTradeServiceImpl tradeService;

    @Override
    public AssetService getAssetService() {
        return assetService;
    }

    @Override
    public ProductService getProductService() {
        return productService;
    }

    @Override
    public TradeService getTradeService() {
        return tradeService;
    }
}

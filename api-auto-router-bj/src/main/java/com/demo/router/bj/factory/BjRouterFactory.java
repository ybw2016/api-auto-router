package com.demo.router.bj.factory;

import com.demo.router.base.annotation.Router;
import com.demo.router.base.annotation.RouterNew;
import com.demo.router.base.enums.RouterType;
import com.demo.router.base.facade.AssetService;
import com.demo.router.base.facade.ProductService;
import com.demo.router.base.facade.TradeService;
import com.demo.router.base.factory.AbstractRouterFactory;
import com.demo.router.bj.facade.BjAssetServiceImpl;
import com.demo.router.bj.facade.BjProductServiceImpl;
import com.demo.router.bj.facade.BjTradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RouterNew(bizEnum = RouterType.class, bizEnumName = "BJ")
@Router(RouterType.BJ)
@Service
public class BjRouterFactory implements AbstractRouterFactory {
    @Autowired
    private BjAssetServiceImpl assetService;
    @Autowired
    private BjTradeServiceImpl tradeService;
    @Autowired
    private BjProductServiceImpl productService;

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

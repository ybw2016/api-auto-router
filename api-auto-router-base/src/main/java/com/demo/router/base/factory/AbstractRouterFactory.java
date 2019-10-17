package com.demo.router.base.factory;

import com.demo.router.base.facade.AssetService;
import com.demo.router.base.facade.ProductService;
import com.demo.router.base.facade.TradeService;

public interface AbstractRouterFactory {
    AssetService getAssetService();

    ProductService getProductService();

    TradeService getTradeService();
}
package com.demo.router.sh.factory;

import com.demo.router.base.annotation.Router;
import com.demo.router.base.enums.RouterType;
import com.demo.router.base.facade.AssetService;
import com.demo.router.base.facade.TradeService;
import com.demo.router.base.factory.AbstractRouterFactory;
import com.demo.router.sh.facade.AssetServiceImpl;
import com.demo.router.sh.facade.TradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Router(RouterType.SH)
@Service
public class ShRouterFactory implements AbstractRouterFactory {
    @Autowired
    private AssetServiceImpl assetService;
    @Autowired
    private TradeServiceImpl tradeService;

    @Override
    public AssetService getAssetService() {
        return assetService;
    }

    @Override
    public TradeService getTradeService() {
        return tradeService;
    }
}

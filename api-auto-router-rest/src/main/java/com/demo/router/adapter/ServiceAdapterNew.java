package com.demo.router.adapter;

import com.demo.router.base.constant.ServiceGroupConstant;
import com.demo.router.base.enums.ProductType;
import com.demo.router.base.enums.RouterType;
import com.demo.router.base.factory.AbstractRouterFactory;
import com.demo.router.service.asset.AbstractAssetService;
import com.demo.router.service.security.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取策略子类
 *
 * @author bowen.yan
 * @date 2018-03-20
 */
@Component
public class ServiceAdapterNew {
    @Autowired
    private ServiceFactory serviceFactory;

    // 获取证券资产计算服务
    public AbstractAssetService getAbstractAssetService(ProductType productType) {
        return (AbstractAssetService) serviceFactory.getService(ServiceGroupConstant.ASSET_ROUTER, productType.getClass(), productType.name());
    }

    // 获取证券产品服务
    public AbstractProductService getProductService(ProductType productType) {
        return (AbstractProductService) serviceFactory.getService(productType.getClass(), productType.name());
    }

    // 获取产品工厂服务
    public AbstractRouterFactory getRouterFactory(RouterType routerType) {
        return (AbstractRouterFactory) serviceFactory.getService(RouterType.class, routerType.name());
    }
}

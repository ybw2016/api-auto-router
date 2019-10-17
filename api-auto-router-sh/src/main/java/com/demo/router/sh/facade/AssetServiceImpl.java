package com.demo.router.sh.facade;

import com.demo.router.base.facade.AssetService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("shAssetServiceImpl")
public class AssetServiceImpl implements AssetService {
    @Override
    public BigDecimal queryAsset() {
        return new BigDecimal("999");
    }
}

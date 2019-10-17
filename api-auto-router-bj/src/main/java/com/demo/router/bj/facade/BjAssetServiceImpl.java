package com.demo.router.bj.facade;

import com.demo.router.base.facade.AssetService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BjAssetServiceImpl implements AssetService {
    @Override
    public BigDecimal queryAsset() {
        return new BigDecimal("111");
    }
}

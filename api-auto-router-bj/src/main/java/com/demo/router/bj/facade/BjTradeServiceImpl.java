package com.demo.router.bj.facade;

import com.demo.router.base.facade.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BjTradeServiceImpl implements TradeService {
    private final BjAssetServiceImpl assetService;

    @Override
    public void executeTrade() {
        System.out.println("executeTrade from BJ -> totalAmount: " + assetService.queryAsset());
    }
}
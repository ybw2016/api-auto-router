package com.demo.router.sh.facade;

import com.demo.router.base.facade.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShTradeServiceImpl implements TradeService {
    private final ShAssetServiceImpl assetService;

    @Override
    public void executeTrade() {
        System.out.println("executeTrade from SH -> totalAmount: " + assetService.queryAsset());
    }
}

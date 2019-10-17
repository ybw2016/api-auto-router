package com.demo.router.bj.facade;

import com.demo.router.base.facade.TradeService;
import org.springframework.stereotype.Service;

@Service("bjTradeServiceImpl")
public class TradeServiceImpl implements TradeService {
    @Override
    public void executeTrade() {
        System.out.println("executeTrade from bj");
    }
}

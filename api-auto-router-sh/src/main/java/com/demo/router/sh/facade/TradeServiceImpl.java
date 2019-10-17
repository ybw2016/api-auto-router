package com.demo.router.sh.facade;

import com.demo.router.base.facade.TradeService;
import org.springframework.stereotype.Service;

@Service("shTradeServiceImpl")
public class TradeServiceImpl implements TradeService {
    @Override
    public void executeTrade() {
        System.out.println("executeTrade from sh");
    }
}

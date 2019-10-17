package com.demo.router.task;

import com.demo.router.adapter.ServiceAdapter;
import com.demo.router.base.enums.RouterType;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class BizTask {
    private final ServiceAdapter serviceAdapter;

    @Scheduled(cron = "0/2 * * * * ?")
    public void purchase() {
        serviceAdapter.getRouter(getRouterType()).getTradeService().executeTrade();
    }

    private RouterType getRouterType() {
        return (new Random().nextInt(1000) % 2 == 1) ? RouterType.BJ : RouterType.SH;
    }
}

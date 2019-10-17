package com.demo.router.task;

import com.demo.router.adapter.ServiceAdapter;
import com.demo.router.base.enums.RouterType;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TradeTask {
    private final ServiceAdapter serviceAdapter;

    @Scheduled(cron = "0/2 * * * * ?")
    public void purchase() {
        System.out.println("products from all over the world:");
        serviceAdapter.getAllRouters().stream()
            .map(abstractRouterFactory -> abstractRouterFactory.getProductService().getProducts())
            .flatMap(Collection::stream)
            .collect(Collectors.toList())
            .forEach(System.out::println);

        RouterType routerType = getRouterType();
        System.out.println("trade place: " + routerType);
        serviceAdapter.getRouter(routerType).getTradeService().executeTrade();

        System.out.println();
    }

    private RouterType getRouterType() {
        return (new Random().nextInt(1000) % 2 == 1) ? RouterType.BJ : RouterType.SH;
    }
}

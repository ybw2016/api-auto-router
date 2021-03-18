package com.demo.router.task;

import com.demo.router.adapter.ServiceAdapterNew;
import com.demo.router.base.enums.ProductType;
import com.demo.router.base.enums.RouterType;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class TradeTask {

    //@Scheduled(cron = "0/2 * * * * ?")
    public void testService() {
        System.out.println("service heartbeat...");
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void assetCalculate() {
        System.out.println("asset calculate type from all exchange:");
        ProductType productType = getProductType();
        System.out.println("asset calculate type productType: " + productType);
        ServiceAdapterNew.getAbstractAssetService(productType).print(productType);

        System.out.println();
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void securityProducts() {
        System.out.println("finance type from all exchange:");
        ProductType productType = getProductType();
        System.out.println("productType: " + productType);
        ServiceAdapterNew.getProductService(productType).print(productType);

        System.out.println();
    }

    @Scheduled(cron = "0/4 * * * * ?")
    public void purchase() {
        System.out.println("products from all over the world:");
        //serviceAdapter.getAllRouters().stream()
        //    .map(abstractRouterFactory -> abstractRouterFactory.getProductService().getProducts())
        //    .flatMap(Collection::stream)
        //    .forEach(System.out::println);

        RouterType routerType = getRouterType();
        System.out.println("trade place: " + routerType);
        ServiceAdapterNew.getRouterFactory(routerType).getTradeService().executeTrade();

        System.out.println();
    }


    private ProductType getProductType() {
        int number = new Random().nextInt(1000) % 3;
        if (number == 1) {
            return ProductType.STOCK;
        }
        if (number == 2) {
            return ProductType.BOND;
        }
        return ProductType.FUND;
    }

    private RouterType getRouterType() {
        return (new Random().nextInt(1000) % 2 == 1) ? RouterType.BJ : RouterType.SH;
    }
}

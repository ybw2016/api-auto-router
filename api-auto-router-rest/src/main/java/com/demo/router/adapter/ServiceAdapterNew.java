package com.demo.router.adapter;

import com.demo.router.base.annotation.RouterNew;
import com.demo.router.base.enums.ProductType;
import com.demo.router.base.enums.RouterType;
import com.demo.router.base.factory.AbstractRouterFactory;
import com.demo.router.service.AbstractProductService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 存管异步通知后回调处理类
 *
 * @author bowen.yan
 * @date 2018-03-20
 */
@Component
public class ServiceAdapterNew implements ApplicationContextAware {
    private static Map<String, Map<String, Object>> HANDLER_MAP = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        Map<String, Object> beanMap = ac.getBeansWithAnnotation(RouterNew.class);
        for (String key : beanMap.keySet()) {
            Object bean = beanMap.get(key);

            System.out.println(String.format("ServiceAdapterNew bean -> beanName:%s, bean:%s", key, bean));

            RouterNew routerNew = bean.getClass().getAnnotation(RouterNew.class);
            String groupKey = routerNew.bizEnum().getName();
            String serviceKey = routerNew.bizEnumName();
            HANDLER_MAP.computeIfAbsent(groupKey, rootKeyItem -> new HashMap<>());
            Map<String, Object> serviceMap = HANDLER_MAP.get(groupKey);
            serviceMap.put(serviceKey, bean);
        }

        for (Map.Entry<String, Map<String, Object>> groupEntry : HANDLER_MAP.entrySet()) {
            for (Map.Entry<String, Object> serviceEntry : groupEntry.getValue().entrySet()) {
                System.out.println(String.format("service group -> %s,  serviceKey:%s, bean -> %s",
                    groupEntry.getKey(), serviceEntry.getKey(), serviceEntry.getValue()));
            }
        }
    }

    // 推荐写法
    public AbstractProductService getProductService(ProductType productType) {
        return (AbstractProductService) getService(productType.getClass(), productType.name());
    }

    public AbstractRouterFactory getRouterFactory(RouterType routerType) {
        return (AbstractRouterFactory) getService(RouterType.class, routerType.name());
    }

    public Object getService(Class<? extends Enum> bizEnum, String bizName) {
        Object handler = HANDLER_MAP.get(bizEnum.getName()).get(bizName);
        return checkHandler(handler);
    }

    private Object checkHandler(Object handler) {
        if (Objects.isNull(handler)) {
            throw new RuntimeException("请先实现业务处理类");
        }
        return handler;
    }
}


package com.demo.router.adapter;

import com.demo.router.base.annotation.Router;
import com.demo.router.base.enums.RouterType;
import com.demo.router.base.factory.AbstractRouterFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class ServiceAdapter implements InitializingBean {
    @Autowired
    private Map<String, AbstractRouterFactory> rawRouterMap;
    private Map<RouterType, AbstractRouterFactory> routerMap = new HashMap<>();

    public List<AbstractRouterFactory> getAllRouters() {
        return new ArrayList<>(routerMap.values());
    }

    public AbstractRouterFactory getRouter(RouterType routerType) {
        return (AbstractRouterFactory) checkHandler(routerMap.get(routerType));
    }

    private Object checkHandler(Object handler) {
        if (Objects.isNull(handler)) {
            throw new RuntimeException("请先实现业务处理类");
        }
        return handler;
    }

    @Override
    public void afterPropertiesSet() {
        addHandler(rawRouterMap, routerMap);
    }

    private <T> void addHandler(Map<String, T> rawHandlerMap, Map<RouterType, T> handlerMap) {
        if (Objects.isNull(rawHandlerMap)) {
            return;
        }

        rawHandlerMap.values()
            .forEach(rawHandler -> {
                Router router = rawHandler.getClass().getAnnotation(Router.class);
                if (Objects.nonNull(router)) {
                    handlerMap.put(router.value(), rawHandler);
                }
            });
    }
}

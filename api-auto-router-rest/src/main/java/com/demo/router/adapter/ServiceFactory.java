package com.demo.router.adapter;

import com.demo.router.base.annotation.RouterNew;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 存管异步通知后回调处理类
 *
 * @author bowen.yan
 * @date 2018-03-20
 */
@Component
public class ServiceFactory implements ApplicationContextAware {
    // 保存每个组下面的策略子类的类型，确保每个组下面的类型都是一致的
    private static Set<String> BEAN_SET = new HashSet<>();
    private static Map<String, Map<String, Object>> HANDLER_MAP = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        Map<String, Object> beanMap = ac.getBeansWithAnnotation(RouterNew.class);
        for (String key : beanMap.keySet()) {
            Object bean = beanMap.get(key);

            System.out.println(String.format("ServiceFactory bean -> beanName:%s, bean:%s", key, bean));

            RouterNew routerNew = bean.getClass().getAnnotation(RouterNew.class);
            String groupKey = getGroupKey(routerNew.bizGroup(), routerNew.bizEnum());
            String serviceKey = routerNew.bizEnumName();

            // 检验bean必须唯一
            String beanUniqueName = String.format("%s_%s", groupKey, serviceKey);
            if (!BEAN_SET.contains(beanUniqueName)) {
                BEAN_SET.add(beanUniqueName);
            } else {
                throw new RuntimeException(
                    String.format("策略冲突，不同的策略子类请使用不同的策略枚举bizEnum或者策略组bizGroup -> bizGroup:%s, bizEnum:%s, bizEnumName:%s, beanName:%s",
                        routerNew.bizGroup(), routerNew.bizEnum(), serviceKey, bean.getClass().getName())
                );
            }

            // 检查枚举值合法性
            if (Stream.of(routerNew.bizEnum().getEnumConstants()).noneMatch(enumItem -> enumItem.name().equals(serviceKey))) {
                throw new RuntimeException(
                    String.format("策略命名不合法，请使用bizEnum.name()枚举值作为策略类命名 -> bizGroup:%s, bizEnum:%s, bizEnumName:%s, beanName:%s",
                        routerNew.bizGroup(), routerNew.bizEnum(), serviceKey, bean.getClass().getName())
                );
            }

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

    public Object getService(Class<? extends Enum> bizEnum, String bizName) {
        return getService("", bizEnum, bizName);
    }

    public Object getService(String bizGroup, Class<? extends Enum> bizEnum, String bizName) {
        String groupKey = getGroupKey(bizGroup, bizEnum);
        Object handler = HANDLER_MAP.get(groupKey).get(bizName);
        return checkHandler(handler);
    }

    private Object checkHandler(Object handler) {
        if (Objects.isNull(handler)) {
            throw new RuntimeException("请先实现业务处理类");
        }
        return handler;
    }

    private String getGroupKey(String bizGroup, Class<? extends Enum> bizEnum) {
        String groupSplitStr = StringUtils.isEmpty(bizGroup) ? "" : "_";
        return String.format("%s%s%s", bizGroup, groupSplitStr, bizEnum.getName());
    }
}

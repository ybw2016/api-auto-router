package com.demo.router.bj.facade;

import com.demo.router.base.facade.ProductService;
import com.demo.router.base.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BjProductServiceImpl implements ProductService {
    @Override
    public List<ProductVo> getProducts() {
        return Arrays.asList(
            ProductVo.of().productCode("P100001").productName("北京烤鸭"),
            ProductVo.of().productCode("P100002").productName("冰糖葫芦"),
            ProductVo.of().productCode("P100002").productName("京酱肉丝")
        );
    }
}
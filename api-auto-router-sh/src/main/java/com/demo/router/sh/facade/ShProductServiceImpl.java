package com.demo.router.sh.facade;

import com.demo.router.base.facade.ProductService;
import com.demo.router.base.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ShProductServiceImpl implements ProductService {
    @Override
    public List<ProductVo> getProducts() {
        return Arrays.asList(
            ProductVo.of().productCode("P310001").productName("南汇水蜜桃"),
            ProductVo.of().productCode("P310002").productName("南翔小笼包")
        );
    }
}
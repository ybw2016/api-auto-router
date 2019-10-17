package com.demo.router.base.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor(staticName = "of")
@Accessors(fluent = true)
@Data
public class ProductVo {
    private String productCode;
    private String productName;
}

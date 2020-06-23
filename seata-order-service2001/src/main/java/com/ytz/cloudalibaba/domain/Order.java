package com.ytz.cloudalibaba.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName: Order
 * @Description: TODO  订单实体类
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = -1178910181321011001L;
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态 0:创建中,1:已完结
     */
    private Integer status;
}

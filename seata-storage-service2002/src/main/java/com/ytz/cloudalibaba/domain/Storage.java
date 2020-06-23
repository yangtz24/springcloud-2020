package com.ytz.cloudalibaba.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Order
 * @Description: TODO  订单实体类
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
public class Storage implements Serializable {

    private static final long serialVersionUID = 2519171733004269297L;
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}

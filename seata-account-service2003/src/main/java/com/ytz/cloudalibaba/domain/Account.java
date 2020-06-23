package com.ytz.cloudalibaba.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Order
 * @Description: TODO  用户账户实体类
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
public class Account implements Serializable {


    private static final long serialVersionUID = -3387687353835171855L;

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private Integer totalAmount;

    /**
     * 已用额度
     */
    private Integer usedAmount;

    /**
     * 剩余额度
     */
    private Integer residueAmount;
}

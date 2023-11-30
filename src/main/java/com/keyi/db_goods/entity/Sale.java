package com.keyi.db_goods.entity;

import lombok.Data;

@Data
public class Sale {
    private Integer sale_id;
    private Integer good_id;
    private Integer client_id;
    private Integer sale_unit;
    private Integer sale_num;
    private Integer sale_price;
}

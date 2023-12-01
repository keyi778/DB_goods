package com.keyi.db_goods.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Restock {
    private Integer restock_id;
    private Integer good_id;
    private Integer restock_num;
    private Integer restock_price;
    private Timestamp restock_date;
}

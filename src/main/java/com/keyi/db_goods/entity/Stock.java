package com.keyi.db_goods.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "stock")
public class Stock {
    @TableId(value = "goodId")
    private Integer good_id;
    @TableField(value = "stockNum")
    private Integer stock_num;
}

package com.keyi.db_goods.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "goods")
public class Good {
    @TableId(value = "goodId")
    private Integer goodId;
    @TableField(value = "goodName")
    private String goodName;
    @TableField(value = "goodPrice")
    private Double goodPrice;
}

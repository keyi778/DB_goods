package com.keyi.db_goods.mapper;

import com.keyi.db_goods.entity.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {
    // 1、增加
    Integer add(Good good);

    // 2、删除
    Integer deleteById(Integer good_id);
    Integer deleteByName(String name);

    // 3、修改
    Integer update(Good good);
    Integer incrementReset();
    // 4、查询
    List<Good> getGoodAll(); // 查询所有商品的信息
    Integer TotalPageNum(); // 查询总页数
    // List<Good> selectPage(Integer pageNum,Integer pageSize); // 有条件的查询
    Integer isExistByName(String name); // 根据good_name，判断商品是否存在
    Integer isExistById(Integer id); // 根据good_id，判断商品是否存在
}

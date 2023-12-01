package com.keyi.db_goods.service;

import com.keyi.db_goods.entity.Good;
import com.keyi.db_goods.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodService {
    @Autowired
    private GoodMapper goodMapper;

    // 1、增加
    public String insert(Good good) {
        if (goodMapper.isExistByName(good.getGood_name()) == 0) {
            goodMapper.insert(good);
            return "保存成功";
        } else {
            return "该商品已存在";
        }
    }

    // 2、删除
    public String deleteById(Integer id) {
        if (goodMapper.isExistById(id) == 1) {
            goodMapper.deleteById(id);
            goodMapper.incrementReset();
            return "删除成功";
        } else {
            return "该商品不存在";
        }
    }

    public String deleteByName(String name) {
        if (goodMapper.isExistByName(name) == 1) {
            goodMapper.deleteByName(name);
            goodMapper.incrementReset();
            return "删除成功";
        } else {
            return "该商品不存在";
        }
    }

    // 3、修改
    public String update(Good good) {
        if (goodMapper.isExistById(good.getGood_id()) == 1) {
            goodMapper.update(good);
            return "修改成功";
        } else {
            return "该商品不存在";
        }
    }

    // 4、查询

}

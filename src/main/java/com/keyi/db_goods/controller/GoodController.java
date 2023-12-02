package com.keyi.db_goods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keyi.db_goods.entity.Good;
import com.keyi.db_goods.service.GoodService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    // 1、增加
    @PostMapping
    public boolean save(@RequestBody Good good) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("goodId", good.getGoodId());
        if (goodService.exists(wrapper))
            return false;
        else
            return goodService.save(good);
    }

    // 2、删除
    @DeleteMapping("/id/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("goodId", id);
        return goodService.remove(wrapper);
    }

    @DeleteMapping("/name/{name}")
    public boolean deleteByName(@PathVariable String name) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("goodName", name);
        return goodService.remove(wrapper);
    }

    // 3、修改
    @PostMapping("/update")
    public boolean update(@RequestBody Good good) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("goodId", good.getGoodId());
        if (goodService.exists(wrapper))
            return goodService.updateById(good);
        else
            return false;
    }

    // 4、查询
    @GetMapping("/")
    public List<Good> getGoodAll() {
        return goodService.list();
    }

    @GetMapping("/page")
    public IPage<Good> getPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String goodId,
                               @RequestParam(defaultValue = "") String goodName) {
        IPage<Good> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Good> queryWrapper = new QueryWrapper<>();
        if(!"".equals(goodId))
        {
            if(NumberUtils.isParsable(goodId))
                queryWrapper.eq("goodId",Integer.valueOf(goodId));
            else
                queryWrapper.eq("goodId",-1);
        }
        if (!"".equals(goodName))
            queryWrapper.like("goodName", goodName);
        return goodService.page(page, queryWrapper);
    }
}

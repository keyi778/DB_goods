package com.keyi.db_goods.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.keyi.db_goods.entity.Good;
import com.keyi.db_goods.mapper.GoodMapper;
import org.springframework.stereotype.Service;

@Service
public class GoodService extends ServiceImpl<GoodMapper, Good> {
}

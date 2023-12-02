package com.keyi.db_goods.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.keyi.db_goods.entity.Client;
import com.keyi.db_goods.mapper.ClientMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends ServiceImpl<ClientMapper, Client> {
}

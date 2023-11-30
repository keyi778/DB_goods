package com.keyi.db_goods.service;

import com.keyi.db_goods.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientMapper clientMapper;
}

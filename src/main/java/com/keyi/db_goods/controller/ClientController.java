package com.keyi.db_goods.controller;

import com.keyi.db_goods.entity.Client;
import com.keyi.db_goods.mapper.ClientMapper;
import com.keyi.db_goods.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//用于标识以下函数是一个接口
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ClientService clientService;


    @GetMapping("/")
    public List<Client> getClientAll() {
        return clientMapper.getClientAll();
    }
}

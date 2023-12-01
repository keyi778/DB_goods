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
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public List<Client> getClientAll() {
        return clientMapper.getClientAll();
    }

    @GetMapping("/add")
    public String add() {
        Client client = new Client();
        client.setClient_id(1145);
        client.setClient_name("许小飞是傻呗");
        client.setClient_mobile("13048699018");
        return clientService.add(client);
    }

    @GetMapping("/delete")
    public String delete() {
        Integer client_id = 114514;
        return clientService.delete(client_id);
    }

    @GetMapping("/update")
    public String update() {
        Client client = new Client();
        client.setClient_id(1145);
        client.setClient_name("许大飞");
        client.setClient_mobile("13048699018");
        return clientService.update(client);
    }

}

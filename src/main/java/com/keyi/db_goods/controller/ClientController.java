package com.keyi.db_goods.controller;

import com.keyi.db_goods.entity.Client;
import com.keyi.db_goods.mapper.ClientMapper;
import com.keyi.db_goods.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//用于标识以下函数是一个接口
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ClientService clientService;

    // 1、增加
    @GetMapping("/insert")
    public String insert() {
        Client client = new Client();
        client.setClient_id(1145);
        client.setClient_name("许小飞是傻呗");
        client.setClient_mobile("13048699018");
        return clientService.insert(client);
    }

    // 2、删除
    @GetMapping("/delete")
    public String delete() {
        Integer client_id = 114514;
        return clientService.delete(client_id);
    }

    // 3、修改
    @GetMapping("/update")
    public String update() {
        Client client = new Client();
        client.setClient_id(1145);
        client.setClient_name("许大飞");
        client.setClient_mobile("13048699018");
        return clientService.update(client);
    }

    // 4、查询
    @GetMapping("/page")
    public Map<String, Object> getByPage(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize
                                         ) {
        pageNum = (pageNum - 1) * pageSize;
        List<Client> data = clientMapper.getClientAll(pageNum, pageSize);
        Integer total = clientMapper.clientTotalNum();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

}

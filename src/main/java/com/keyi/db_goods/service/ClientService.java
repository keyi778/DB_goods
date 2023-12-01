package com.keyi.db_goods.service;

import com.keyi.db_goods.entity.Client;
import com.keyi.db_goods.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientMapper clientMapper;

    public String add(Client client) {
        if(clientMapper.getClientNum(client.getClient_id()) == 0) {
            clientMapper.add(client);
            return "保存成功";
        }else {
            return "该客户已存在";
        }
    }

    public String delete(Integer client_id) {
        if(clientMapper.getClientNum(client_id) == 1) {
            clientMapper.delete(client_id);
            return "删除成功";
        }else {
            return "该客户不存在";
        }
    }

    public String update(Client client) {
        if(clientMapper.getClientNum(client.getClient_id()) == 1) {
            clientMapper.update(client);
            return "修改成功";
        }else {
            return "该客户不存在";
        }
    }
}

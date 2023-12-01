package com.keyi.db_goods.service;

import com.keyi.db_goods.entity.Client;
import com.keyi.db_goods.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientMapper clientMapper;

    // 1、增加
    public String insert(Client client) {
        if(clientMapper.isExitById(client.getClient_id()) == 0) {
            clientMapper.insert(client);
            return "保存成功";
        } else {
            return "该客户已存在";
        }
    }

    // 2、删除
    public String delete(Integer client_id) {
        if(clientMapper.isExitById(client_id) == 1) {
            clientMapper.delete(client_id);
            clientMapper.incrementReset();
            return "删除成功";
        } else {
            return "该客户不存在";
        }
    }

    // 3、修改
    public String update(Client client) {
        if(clientMapper.isExitById(client.getClient_id()) == 1) {
            clientMapper.update(client);
            return "修改成功";
        } else {
            return "该客户不存在";
        }
    }

    // 4、查询

}

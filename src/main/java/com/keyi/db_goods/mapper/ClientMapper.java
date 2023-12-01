package com.keyi.db_goods.mapper;


import com.keyi.db_goods.entity.Client;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {

    //查询所有用户记录
    List<Client> getClientAll();

    //查询用户数量
    Integer getClientNum(Integer client_id);

    Integer add(Client client);

    Integer delete(Integer clientId);

    Integer update(Client client);
}

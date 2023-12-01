package com.keyi.db_goods.mapper;


import com.keyi.db_goods.entity.Client;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {

    // 1、增加
    Integer insert(Client client);

    // 2、删除
    Integer delete(Integer clientId);

    // 3、修改
    Integer update(Client client);

    Integer incrementReset();
    // 4、查询
    List<Client> getClientAll(Integer pageNum,Integer pageSize);//查询所有用户记录

    Integer isExitById(Integer client_id);//查询用户数量

    Integer clientTotalNum();//查询用户总数
}

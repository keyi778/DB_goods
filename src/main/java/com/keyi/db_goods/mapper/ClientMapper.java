package com.keyi.db_goods.mapper;


import com.keyi.db_goods.entity.Client;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {

    List<Client> getClientAll();
}

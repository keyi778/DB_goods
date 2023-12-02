package com.keyi.db_goods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keyi.db_goods.entity.Client;
import com.keyi.db_goods.mapper.ClientMapper;
import com.keyi.db_goods.service.ClientService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // 1、增加
    @PostMapping
    public boolean save(@RequestBody Client client) {
        return clientService.save(client);
    }

    // 2、删除
    @DeleteMapping("/id/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        QueryWrapper<Client> wrapper = new QueryWrapper<>();
        wrapper.eq("clientId", id);
        return clientService.remove(wrapper);
    }

    // 3、修改
    @PostMapping("/update")
    public boolean update(@RequestBody Client client) {
        return clientService.updateById(client);
    }

    // 4、查询
    @GetMapping("/")
    public List<Client> getGoodAll() {
        return clientService.list();
    }

    @GetMapping("/page")
    public IPage<Client> getPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String clientId,
                               @RequestParam(defaultValue = "") String clientName,
                               @RequestParam(defaultValue = "") String clientMobile) {
        IPage<Client> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Client> queryWrapper = new QueryWrapper<>();
        if (!"".equals(clientId))
        {
            if(NumberUtils.isParsable(clientId))
            {
                queryWrapper.eq("clientId",Integer.valueOf(clientId));
            }
        }
        if (!"".equals(clientName))
            queryWrapper.like("clientName", clientName);
        if (!"".equals(clientMobile))
            queryWrapper.like("clientMobile", clientMobile);
        return clientService.page(page, queryWrapper);
    }

}

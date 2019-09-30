package com.lunz.cpfw.web.controllers;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.Type;
import com.lunz.cpfw.web.entities.tb_product_vehiclekind;
import com.lunz.cpfw.web.entities.tb_product_vehicletype;
import com.lunz.cpfw.web.interfaces.Itb_product_vehiclekindService;
import com.lunz.cpfw.web.interfaces.Itb_product_vehicletypeService;
import com.lunz.cpfw.web.mappers.CommonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "车辆类别")
public class tb_product_vehicletypeController extends BaseV1Controller {
    @Autowired
    Itb_product_vehiclekindService vehiclekindService;
    @Autowired
    Itb_product_vehicletypeService vehiclektypeService;
    @Autowired
    CommonMapper commonMapper;

    /**
     * 保存
     */
    @PostMapping("/saveVehicle")
    @ApiOperation("保存车辆类别")
    public WebApiResult saveVehicle(@RequestBody Type type) {

        tb_product_vehicletype vehicletype = new tb_product_vehicletype();
        if (vehicletype.getId() == null) {
            //新建
            String ppvt = commonMapper.GeneratorKey("PPVT");
            vehicletype.setId(ppvt);
            vehicletype.setCreatedat(new Date());
            vehicletype.setDeleted(false);
        } else {
            //修改
            vehicletype.setId(type.getId());
        }
        vehicletype.setCode(type.getCode());
        vehicletype.setName(type.getName());
        vehicletype.setJsonstring(null);
        vehicletype.setJsonstring(JSON.toJSONString(vehicletype));
        vehiclektypeService.insert(vehicletype);
        return WebApiResult.ok();

    }

    @ApiOperation("根据id查询")
    @GetMapping("/selsctByid/{id}")
    public WebApiResult selectByid(@RequestParam String id) {
        tb_product_vehicletype vehicletype = vehiclektypeService.selectById(id);
        Type type = new Type();
        type.setCode(vehicletype.getCode());
        type.setName(vehicletype.getName());
        type.setId(vehicletype.getId());
        return WebApiResult.ok(type);
    }

    @ApiOperation("停用")
    @GetMapping("/stopVehicle/{id}")
    public WebApiResult stopVehicle(@RequestParam String id) {
        WebApiResult result = null;
        List<tb_product_vehiclekind> vehiclekindList = vehiclekindService.selectList(null);
        ArrayList<Object> list = new ArrayList<>();
        for (tb_product_vehiclekind vehiclekind : vehiclekindList) {
            List<String> listType = JSON.parseArray(vehiclekind.getType(), String.class);
            if (!CollectionUtils.isEmpty(listType)) {
                for (String str : listType) {
                    list.add(str);
                }

            }
        }
        if (list.contains(id)) {
            result = WebApiResult.error("id正在被使用!!");
        } else {
            tb_product_vehicletype vehicletype = vehiclektypeService.selectById(id);
            vehicletype.setIsdisable(true);
            vehicletype.setJsonstring(null);
            vehicletype.setJsonstring(JSON.toJSONString(vehicletype));
            EntityWrapper<tb_product_vehicletype> wrapper = new EntityWrapper<>();
            wrapper.eq("id", vehicletype.getId());
            vehiclektypeService.update(vehicletype, wrapper);
            result = WebApiResult.ok();

        }
        return result;
    }

}

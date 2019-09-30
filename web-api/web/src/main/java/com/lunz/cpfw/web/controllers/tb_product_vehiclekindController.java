package com.lunz.cpfw.web.controllers;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lunz.cpfw.core.interaction.PagingOptions;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.Vehicle;
import com.lunz.cpfw.web.entities.tb_product_vehiclekind;
import com.lunz.cpfw.web.entities.tb_product_vehicletype;
import com.lunz.cpfw.web.interfaces.Itb_product_vehiclekindService;
import com.lunz.cpfw.web.interfaces.Itb_product_vehicletypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

@RestController
@Api(tags = "车辆管理")
public class tb_product_vehiclekindController extends BaseV1Controller {

    @Autowired
    Itb_product_vehiclekindService vehiclekindService;

    @Autowired
    Itb_product_vehicletypeService vehiclektypeService;

    /**
     * 分页查询
     */
    @ApiOperation("分页查询所有")
    @PostMapping("/findByPage")
    public WebApiResult findByPage(@RequestBody PagingOptions pagingOptions) throws Exception {
//        PagingOptions pageOptions = new PagingOptions();
//        pageOptions.setPageIndex(pageIndex);
//        pageOptions.setPageSize(pageSize);
        Future<WebApiResult> result = vehiclekindService.queryPagingResult(pagingOptions);
        return result.get();
    }

    @ApiOperation("新建页面")
    @GetMapping("/saveToPage")
    public WebApiResult saveToPage() {
        List<tb_product_vehicletype> selectList = vehiclektypeService.selectList(null);
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();
        for (tb_product_vehicletype tpv : selectList) {
            if (tpv.getIsdisable() == true) {
                map.put(tpv.getId(), tpv.getName());
            }
        }
        list.add(map);
        return WebApiResult.ok(list);

    }

//    /**
//     * 新建保存
//     *
//     * @param
//     * @return
//     */
//    @ApiOperation("新建保存")
//    @PostMapping("/insert")
//    public WebApiResult insert(@RequestBody Vehicle vehicle) {
//        tb_product_vehiclekind vehiclekind = new tb_product_vehiclekind();
//        vehiclekind.setName(vehicle.getName());
//        vehiclekind.setPositiverentbaseinterestrate(vehicle.getPositiverentbaseinterestrate());
//        vehiclekind.setLeasebackbaseinterestrate(vehicle.getLeasebackbaseinterestrate());
//        vehiclekind.setType(JSON.toJSONString(vehicle.getList()));
//        vehiclekindService.addVehiclekind(vehiclekind);
//        return WebApiResult.ok();
//    }

//    @ApiOperation("修改保存")
//    @PostMapping("/edit")
//    public WebApiResult edit(@RequestBody Vehicle vehicle) {
//        tb_product_vehiclekind vehiclekind = new tb_product_vehiclekind();
//        vehiclekind.setId(vehicle.getId());
//        vehiclekind.setName(vehicle.getName());
//        vehiclekind.setPositiverentbaseinterestrate(vehicle.getPositiverentbaseinterestrate());
//        vehiclekind.setLeasebackbaseinterestrate(vehicle.getLeasebackbaseinterestrate());
//        vehiclekind.setType(JSON.toJSONString(vehicle.getList()));
//        vehiclekindService.updateVehiclekind(vehiclekind);
//        return WebApiResult.ok();
//    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public WebApiResult save(@RequestBody Vehicle vehicle) {
        tb_product_vehiclekind vehiclekind = new tb_product_vehiclekind();
        vehiclekind.setName(vehicle.getName());
        vehiclekind.setPositiverentbaseinterestrate(vehicle.getPositiverentbaseinterestrate());
        vehiclekind.setLeasebackbaseinterestrate(vehicle.getLeasebackbaseinterestrate());
        vehiclekind.setType(JSON.toJSONString(vehicle.getList()));
        if (vehicle.getId() != null) {
            //修改
            vehiclekind.setId(vehicle.getId());
            vehiclekindService.updateVehiclekind(vehiclekind);
            return WebApiResult.ok();
        } else {
            //新建
            vehiclekindService.addVehiclekind(vehiclekind);
            return WebApiResult.ok();
        }
    }

    @ApiOperation("修改根据id查询")
    @GetMapping("/selectById/{id}")
    public WebApiResult selectById(@PathVariable String id) {
        EntityWrapper<tb_product_vehiclekind> wrapper = new EntityWrapper<>();
        wrapper.eq("id", id);
        tb_product_vehiclekind vehiclekind = vehiclekindService.selectOne(wrapper);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setName(vehiclekind.getName());
        List<String> arrayLists = JSON.parseArray(vehiclekind.getType(), String.class);
        vehicle.setList(arrayLists);
        vehicle.setPositiverentbaseinterestrate(vehiclekind.getPositiverentbaseinterestrate());
        vehicle.setLeasebackbaseinterestrate(vehiclekind.getLeasebackbaseinterestrate());
        return WebApiResult.ok(vehicle);

    }

}

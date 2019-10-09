package com.lunz.cpfw.web.controllers;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lunz.cpfw.core.interaction.PagingOptions;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.tb_product_vehiclekind;
import com.lunz.cpfw.web.entities.tb_product_vehicletype;
import com.lunz.cpfw.web.interfaces.Itb_product_vehiclekindService;
import com.lunz.cpfw.web.interfaces.Itb_product_vehicletypeService;
import com.lunz.cpfw.web.model.Type;
import com.lunz.cpfw.web.model.Vehicle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.String;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        Future<WebApiResult> result = vehiclekindService.queryPagingResult(pagingOptions );
        int i=1;
        return result.get();
    }


    @ApiOperation("新建页面")
    @GetMapping("/saveToPage")
    public WebApiResult saveToPage() {
        List<tb_product_vehicletype> selectList = vehiclektypeService.selectList(null);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();
        for (tb_product_vehicletype tpv : selectList) {
            if ( tpv.getIsdisable() != null && tpv.getIsdisable() == true) {
                map.put(String.valueOf(tpv.getId()), tpv.getName());
            }
        }
        list.add(map);
        return WebApiResult.ok(list);

    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public WebApiResult save(@RequestBody Vehicle vehicle) {
        WebApiResult result =null;
        tb_product_vehiclekind vehiclekind = new tb_product_vehiclekind();
        vehiclekind.setName(vehicle.getName());
        vehiclekind.setPositiverentbaseinterestrate(vehicle.getPositiverentbaseinterestrate());
        vehiclekind.setLeasebackbaseinterestrate(vehicle.getLeasebackbaseinterestrate());
        vehiclekind.setType(JSON.toJSONString(vehicle.getList()));
        List<tb_product_vehiclekind> list = vehiclekindService.selectList(null);
        List<Object> objects = new ArrayList();
        for (tb_product_vehiclekind tpv : list) {
            objects.add(tpv.getId());
        }
        for(Object str:objects ) {
            if (str.equals(vehicle.getId())) {
                //修改
                vehiclekind.setId(vehicle.getId());

                vehiclekindService.updateVehiclekind(vehiclekind);
               result =  WebApiResult.ok();
            } else {
                //新建
                try {
                    vehiclekindService.addVehiclekind(vehiclekind);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                result= WebApiResult.ok();
                break;
            }
        }
        return  result;
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
        List<java.lang.String> arrayLists = JSON.parseArray(vehiclekind.getType(), String.class);
        vehicle.setList(arrayLists);
        vehicle.setPositiverentbaseinterestrate(vehiclekind.getPositiverentbaseinterestrate());
        vehicle.setLeasebackbaseinterestrate(vehiclekind.getLeasebackbaseinterestrate());
        return WebApiResult.ok(vehicle);

    }



    /**
     * 车辆类别维护
     */
    @ApiOperation("车辆类别维护")
    @GetMapping("/selectToType")
    public WebApiResult selectToType() {
        List<tb_product_vehicletype> vehicletypeList = vehiclektypeService.selectList(null);
        ArrayList<Type> types = new ArrayList<>();
        for (tb_product_vehicletype vehicletype : vehicletypeList) {
            Type type = new Type();
            type.setId(String.valueOf(vehicletype.getId()));
            type.setName(vehicletype.getName());
            type.setCode(String.valueOf(vehicletype.getCode()));
            types.add(type);
        }
        return WebApiResult.ok(types);
    }

    /**
     * 停用
     */
    @ApiOperation("停用")
    @GetMapping("/stop/{id}")
    public WebApiResult stopVehiclekind(@PathVariable String id) {
        WebApiResult result = vehiclekindService.stopVehicle(id);
        return result;
    }

    /**
     * 启用
     */
    @ApiOperation("启用")
    @GetMapping("/start/{id}") //kind的id;
    public WebApiResult startVehiclekind(@PathVariable String id) {
        WebApiResult result = vehiclekindService.startVehicle(id);
        return result;
    }

}
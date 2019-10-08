package com.lunz.cpfw.web.services;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lunz.cpfw.core.interaction.PagingOptions;
import com.lunz.cpfw.core.interaction.Query;
import com.lunz.cpfw.core.service.ServiceBase;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.tb_product_vehiclekind;
import com.lunz.cpfw.web.entities.tb_product_vehicletype;
import com.lunz.cpfw.web.interfaces.Itb_product_vehiclekindService;
import com.lunz.cpfw.web.mappers.CommonMapper;
import com.lunz.cpfw.web.mappers.tb_product_vehiclekindMapper;
import com.lunz.cpfw.web.mappers.tb_product_vehicletypeMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.execchain.TunnelRefusedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.lang.String;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class tb_product_vehiclekindService extends ServiceBase<tb_product_vehiclekindMapper, tb_product_vehiclekind>
        implements Itb_product_vehiclekindService {
    @Autowired
    tb_product_vehiclekindMapper mapper;
    @Autowired
    tb_product_vehicletypeMapper vehicletypeMapper;
    @Autowired
    CommonMapper commonMapper;

    /**
     * 分页查询
     *
     * @param pagingOptions
     * @return
     */
    public Future<WebApiResult> queryPagingResult(PagingOptions pagingOptions) {
        AsyncResult<WebApiResult> result = null;

        try {
            Query<tb_product_vehiclekind> query = new Query<tb_product_vehiclekind>(mapper, pagingOptions);
            WebApiResult resList = query.buildResult();
            List<tb_product_vehiclekind> vehiclekindList = (List<tb_product_vehiclekind>) resList.get("data");
            for (tb_product_vehiclekind vehiclekind : vehiclekindList) {
                List<String> jsonArray = JSON.parseArray(vehiclekind.getType(), String.class);
                ArrayList<Object> arrayList = new ArrayList<>();
                if (jsonArray != null) {
                    for (String id : jsonArray) {
                        tb_product_vehicletype vehicletype = vehicletypeMapper.selectById(id);

                        arrayList.add(vehicletype.getName());
                    }
                    String join = StringUtils.join(arrayList.toArray(), ",");
                    vehiclekind.setType(join);
                }
            }

            result = new AsyncResult<WebApiResult>(resList);
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }

        return result;
    }

    /**
     * 添加
     *
     * @param vehiclekind
     * @return
     */
    public Integer addVehiclekind(tb_product_vehiclekind vehiclekind) {

        String ppvk = commonMapper.GeneratorKey("PPVK");
        vehiclekind.setId(ppvk);
        String puvk = commonMapper.GeneratorKey("PUVK");
        vehiclekind.setUniqueid(puvk);
        vehiclekind.setIsdisable(false);
        vehiclekind.setCreatedat(new Date());
        vehiclekind.setUpdatedat(new Date());
        vehiclekind.setJsonstring(JSON.toJSONString(vehiclekind));
        return mapper.insert(vehiclekind);
    }

    /**
     * 修改
     */
    public Integer updateVehiclekind(tb_product_vehiclekind vehiclekind) {
        EntityWrapper<tb_product_vehiclekind> wrapper = new EntityWrapper<>();
        wrapper.eq("id", vehiclekind.getId());
        vehiclekind.setUpdatedat(new Date());
        vehiclekind.setJsonstring(null);
        vehiclekind.setJsonstring(JSON.toJSONString(vehiclekind));
        Integer update = mapper.update(vehiclekind, wrapper);
        return update;
    }


    /**
     * 启用
     */
    public WebApiResult startVehicle(String id) {
        WebApiResult result = null;
        tb_product_vehiclekind vehiclekind = mapper.selectById(id);
        List list = new ArrayList();
        List<String> stringList = JSON.parseArray(vehiclekind.getType(), String.class);
        int i = 0; // 停用的循环的次数 ,若该次数等于type中类别的个数，则证明全都是停用的，否则就没有停用。
        for (String str : stringList) {
            tb_product_vehicletype vehicletype = vehicletypeMapper.selectById(str);
            if (vehicletype.getIsdisable() == true){
                list.add(vehicletype.getName());
            } else{
                i++;
            }
        }
//        System.out.println(i);
        if (i == stringList.size()) {
            vehiclekind.setIsdisable(false);
            vehiclekind.setJsonstring(null);
            vehiclekind.setJsonstring(JSON.toJSONString(vehiclekind));
            EntityWrapper<tb_product_vehiclekind> wrapper = new EntityWrapper<>();
            wrapper.eq("id", id);
            mapper.update(vehiclekind, wrapper);
            result = WebApiResult.ok();
        } else {
            String join = StringUtils.join(list.toArray(), ",");
            result = WebApiResult.error(join);
        }

        return result;
    }

    /**
     * 停用
     * @param id
     * @return
     */
    public WebApiResult stopVehicle(String id) {
        WebApiResult result = null;
        List list = new ArrayList();
        tb_product_vehiclekind vehiclekind = mapper.selectById(id);
        List<String> stringList = JSON.parseArray(vehiclekind.getType(), String.class);
        int i = 0 ;
        if(!CollectionUtils.isEmpty(stringList)){
        for (String str : stringList) {
            tb_product_vehicletype vehicletype = vehicletypeMapper.selectById(str);
            if (vehicletype.getIsdisable() == false) {
                list.add(vehicletype.getName());
            }else {
                i++;
            }

        }
        }
        if (i == stringList.size()) {
            vehiclekind.setIsdisable(true);
            vehiclekind.setJsonstring(null);
            vehiclekind.setJsonstring(JSON.toJSONString(vehiclekind));
            EntityWrapper<tb_product_vehiclekind> wrapper = new EntityWrapper<>();
            wrapper.eq("id", id);
            mapper.update(vehiclekind, wrapper);
            result = WebApiResult.ok();
        }else{
            String join = StringUtils.join(list.toArray(), ",");
            result = WebApiResult.error(join);
        }
        return result;
    }

}

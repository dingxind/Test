package com.lunz.cpfw.web.services;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lunz.cpfw.core.service.ServiceBase;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.tb_product_vehiclekind;
import com.lunz.cpfw.web.entities.tb_product_vehicletype;
import com.lunz.cpfw.web.interfaces.Itb_product_vehiclekindService;
import com.lunz.cpfw.web.interfaces.Itb_product_vehicletypeService;
import com.lunz.cpfw.web.mappers.tb_product_vehicletypeMapper;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class tb_product_vehicletypeService extends ServiceBase<tb_product_vehicletypeMapper, tb_product_vehicletype>
        implements Itb_product_vehicletypeService {
    @Autowired
    Itb_product_vehiclekindService vehiclekindService;
    @Autowired
    tb_product_vehicletypeMapper vehicletypeMapper;

    /**
     * 停用
     *
     * @param id
     * @return
     */
    public WebApiResult stopVehicle(String id) {
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
            ArrayList<String> stringList = new ArrayList<>();
            StringBuffer buffer = new StringBuffer();
            String join = null;
            HashMap<String, List> map = new HashMap<>();

            for (tb_product_vehiclekind vehiclekind : vehiclekindList) {
                List<String> listType = JSON.parseArray(vehiclekind.getType(), String.class);
                map.put(vehiclekind.getId(), listType);
            }
            Iterator<Map.Entry<String, List>> iterator = map.entrySet().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Map.Entry<String, List> next = iterator.next();
                List nextValue = next.getValue();
                if(nextValue != null) {
                    if(nextValue.contains(id)){
                        stringList.add(next.getKey());
                        join = StringUtil.join(Arrays.asList(stringList.toArray()), ",");
                    }
                }

            }
            result = WebApiResult.error(join);

        } else {

            tb_product_vehicletype vehicletype = vehicletypeMapper.selectById(id);
            if (vehicletype != null) {
                vehicletype.setIsdisable(true);
                vehicletype.setJsonstring(null);
                vehicletype.setJsonstring(JSON.toJSONString(vehicletype));
                EntityWrapper<tb_product_vehicletype> wrapper = new EntityWrapper<>();
                wrapper.eq("id", vehicletype.getId());
                vehicletypeMapper.update(vehicletype, wrapper);
                result = WebApiResult.ok();
            } else {
                result = WebApiResult.error("没有指定数据");
            }

        }
        return result;
    }

    /**
     * 启用
     *
     * @param id
     * @return
     */

    public WebApiResult startVehicle(String id) {
        WebApiResult result = null;
        tb_product_vehicletype vehicletype = vehicletypeMapper.selectById(id);
        if (vehicletype != null) {
            vehicletype.setIsdisable(false);
            vehicletype.setJsonstring(null);
            vehicletype.setJsonstring(JSON.toJSONString(vehicletype));
            EntityWrapper<tb_product_vehicletype> wrapper = new EntityWrapper<tb_product_vehicletype>();
            wrapper.eq("id", id);
            vehicletypeMapper.update(vehicletype, wrapper);
            result = WebApiResult.ok();
        } else {
            result = WebApiResult.error("没有此数据");
        }
        return result;
    }

}

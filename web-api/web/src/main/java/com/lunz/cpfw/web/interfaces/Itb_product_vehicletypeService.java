package com.lunz.cpfw.web.interfaces;

import com.baomidou.mybatisplus.service.IService;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.tb_product_vehicletype;

public interface Itb_product_vehicletypeService extends IService<tb_product_vehicletype> {
    /**
     * 停用
     * @param id
     * @return
     */
    WebApiResult stopVehicle(String id);

    /**
     * 启用
     * @param id
     * @return
     */
    WebApiResult startVehicle(String id);
}

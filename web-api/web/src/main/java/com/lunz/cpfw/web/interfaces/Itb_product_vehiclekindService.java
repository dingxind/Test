package com.lunz.cpfw.web.interfaces;

import com.baomidou.mybatisplus.service.IService;
import com.lunz.cpfw.core.interaction.PagingOptions;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.tb_product_vehiclekind;

import java.util.List;
import java.util.concurrent.Future;

public interface Itb_product_vehiclekindService extends IService<tb_product_vehiclekind> {
    /**
     * 查询
     *
     * @param pagingOptions
     * @return
     */
    Future<WebApiResult> queryPagingResult(PagingOptions pagingOptions);

    /**
     * 添加
     *
     * @param vehiclekind
     * @return
     */
    Integer addVehiclekind(tb_product_vehiclekind vehiclekind);

    /**
     * 修改
     *
     * @param vehiclekind
     * @return
     */
    Integer updateVehiclekind(tb_product_vehiclekind vehiclekind);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<?> likePagingResult(String name);

    /**
     * 启用
     * @param id
     * @return
     */
    WebApiResult startVehicle(String id);

    /**
     * 停用
     * @param id
     * @return
     */
    WebApiResult stopVehicle(String id);
}

/**
 * Copyright (C), 2015-2019,
 * FileName: MyMetaObjectHandler
 * Author:   Administrator
 * Date:     2019/10/8 0008 8:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lunz.cpfw.web.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler extends MetaObjectHandler {
    public void insertFill(MetaObject metaObject) {
        Object createDate = this.getFieldValByName("createdat", metaObject);
        if (null == createDate) {
            /**
             * 设置实体属性setter进去的值，优先级要高于自动填充的值。
             * 如果实体没有设置该属性，就给默认值，防止entity的setter值被覆盖。
             */
            this.setFieldValByName("createdat", new Date(), metaObject);
        }
        Object modifyDate = this.getFieldValByName("updatedat", metaObject);
        if (null == modifyDate) {
            this.setFieldValByName("updatedat", new Date(), metaObject);
        }
    }
    public void updateFill(MetaObject metaObject) {
        Object modifyDate = this.getFieldValByName("updatedat", metaObject);
        if (null == modifyDate) {
            this.setFieldValByName("updatedat", new Date(), metaObject);
        }
    }
}


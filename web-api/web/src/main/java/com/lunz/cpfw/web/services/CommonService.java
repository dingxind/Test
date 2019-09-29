package com.lunz.cpfw.web.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CommonService {

    /**
     * 比较两个实体属性值组织"编辑"日志
     */
    public String getEditRemark(Map<String, List<Object>> map, String message) {
        try {
            StringBuilder sb = new StringBuilder();
            if (message == null) {
                message = "";
            } else {
                message = message + "，";
            }
            sb.append(message);
            if (map != null && map.size() > 0) {
                Set<String> keySet = map.keySet();
                for (String key : keySet) {
                    if (map.get(key) == null) {
                        sb.append(key + "产生修改；");
                    } else {
                        List<Object> list = map.get(key);
                        sb.append(key + "由【" + list.get(0) + "】修改为【" + list.get(1) + "】；");
                    }
                }
            }

            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 根据一个实体的每个属性组织"新建"日志
     */
    public String getAddRemark(Map<String, Object> map, String message) {
        try {
            if (message == null) {
                message = "";
            } else {
                message = message + "，";
            }
            if (map != null && map.size() > 0) {
                Set<String> keySet = map.keySet();
                for (String key : keySet) {
                    Object value = map.get(key);
                    message = message + key + "：【" + value + "】；";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return message;
    }
}
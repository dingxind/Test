package com.lunz.cpfw.web.utils;

import org.springframework.stereotype.Service;

import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ReflectionUtil {

    /**
     * 比较两个实体属性值
     * 
     * @param obj1
     * @param obj2
     * @param ignoreArr 忽略比较的属性数组
     */
    public static <T> Map<String, List<Object>> compareFields(Object obj1, Object obj2, String[] ignoreArr) {
        BigDecimal d1 = null;
        BigDecimal d2 = null;
        Object o1 = new Object();
        Object o2 = new Object();
        try {
            Map<String, List<Object>> map = new HashMap<String, List<Object>>();
            List<String> ignoreList = null;
            if (ignoreArr != null && ignoreArr.length > 0) {
                // array转化为list
                ignoreList = Arrays.asList(ignoreArr);
            }
            if (obj1.getClass() == obj2.getClass()) {// 只有两个对象都是同一类型的才有可比性
                Class<?> clazz1 = obj1.getClass();

                List<Field> fields = new ArrayList<>();
                while (clazz1 != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
                    fields.addAll(Arrays.asList(clazz1.getDeclaredFields()));// 获取所有属性
                    clazz1 = clazz1.getSuperclass(); // 得到父类,然后赋给自己
                }

                for (Field field : fields) {
                    field.setAccessible(true);// 设置这些属性是可以访问的
                    String key = field.getName();// 属性名
                    String name = null;
                    if (ignoreList != null && ignoreList.contains(key)) {// 如果当前属性选择忽略比较，跳到下一次循环
                        continue;
                    }

                    ApiModelProperty property = field.getAnnotation(ApiModelProperty.class);// 获取属性指定注解
                    if (property != null) {
                        name = property.value();
                        o1 = field.get(obj1);
                        o2 = field.get(obj2);// 得到此属性的值
                        if (property.dataType().equals("model")) {
                            Map<String, List<Object>> modelMap = compareFields(o1, o2, null);
                            Set<String> keySet = modelMap.keySet();
                            for (String item : keySet) {
                                map.put(item, modelMap.get(item));
                            }
                            continue;
                        } else if (property.dataType().equals("list")) {
                            if (!ListUtil.isCommon((List<T>) o1, (List<T>) o2)) {
                                map.put(name, null);
                            }
                        }
                    }

                    if (name != null) {
                        List<Object> list = new ArrayList<Object>();
                        if (o1 instanceof BigDecimal) {
                            d1 = (BigDecimal) o1;
                        }
                        if (o2 instanceof BigDecimal) {
                            d2 = (BigDecimal) o2;
                        }
                        if (o1 instanceof BigDecimal && o2 instanceof BigDecimal) {
                            if (d1.compareTo(d2) == 0) {
                                continue;
                            } else {
                                o1 = d1.stripTrailingZeros().toPlainString();
                                o2 = d2.stripTrailingZeros().toPlainString();
                                list.add(o1);
                                list.add(o2);
                                map.put(name, list);
                                continue;
                            }
                        }

                        if (o1 instanceof Timestamp) {
                            o1 = new Date(((Timestamp) o1).getTime());
                        }
                        if (o2 instanceof Timestamp) {
                            o2 = new Date(((Timestamp) o2).getTime());
                        }

                        if (o1 == null && o2 == null) {
                            continue;
                        } else if (o1 == null) {
                            o1 = "";
                        } else if (o2 == null) {
                            o2 = "";
                        }

                        if (!o1.equals(o2)) {
                            list.add(o1);
                            list.add(o2);
                            map.put(name, list);
                        }
                    }
                }
            }
            return map;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 获取一个实体的每个属性的名称和值
     * 
     * @param obj
     * @param ignoreArr 忽略的属性数组
     */
    public static Map<String, Object> getKeyAndValue(Object obj, String[] ignoreArr) {
        String name = null;
        Object val = new Object();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<String> ignoreList = null;
            if (ignoreArr != null && ignoreArr.length > 0) {
                // array转化为list
                ignoreList = Arrays.asList(ignoreArr);
            }
            // 得到类对象
            Class<?> clazz = obj.getClass();
            /* 得到类中的所有属性集合 */
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true); // 设置这些属性是可以访问的

                String key = field.getName();// 属性名
                if (ignoreList != null && ignoreList.contains(key)) {// 如果当前属性选择忽略，跳到下一次循环
                    continue;
                }

                ApiModelProperty property = field.getAnnotation(ApiModelProperty.class);// 获取属性指定注解
                if (property != null) {
                    val = field.get(obj);// 得到此属性的值
                    if (property.dataType().equals("model")) {
                        Map<String, Object> modelMap = getKeyAndValue(val, null);
                        Set<String> keySet = modelMap.keySet();
                        for (String item : keySet) {
                            map.put(item, modelMap.get(item));
                        }
                        continue;
                    }
                    name = property.value();
                }

                if (name != null && val != null && val != "") {
                    map.put(name, val);// 设置键值
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return map;
    }
}
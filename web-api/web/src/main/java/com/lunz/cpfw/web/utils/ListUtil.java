package com.lunz.cpfw.web.utils;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;

@Service
public class ListUtil {

    /**
     * 比较两个list是否相等
     * 
     * @param list1
     * @param list2
     */
    public static <T> boolean isCommon(List<T> list1, List<T> list2) {
        try {
            if (list1 != null && list1.size() == 0) {
                list1 = null;
            }

            if (list2 != null && list2.size() == 0) {
                list2 = null;
            }

            if (list1 == list2) {
                return true;
            }

            if (list1 == null && list2 == null) {
                return true;
            }

            if (list1 == null || list2 == null) {
                return false;
            }

            if (list1.size() != list2.size()) {
                return false;
            }

            String json1 = JSON.toJSONString(list1);
            String json2 = JSON.toJSONString(list2);
            for (Object o : list1) {
                String jsonObj = JSON.toJSONString(o);
                if (!json2.contains(jsonObj))
                    return false;
            }
            for (Object o : list2) {
                String jsonObj = JSON.toJSONString(o);
                if (!json1.contains(jsonObj))
                    return false;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return true;
    }

    /**
     * 判断list是否有重复值
     */
    public static <T> boolean checkDuplicate(List<T> list) {
        boolean result = false;
        if (list != null && list.size() > 0) {
            Set<T> set = new HashSet<>(list);
            if (list.size() != set.size()) {
                result = true;
            }
        }

        return result;
    }

    // /**
    // * 找出两个list不同之处
    // *
    // * @param list1
    // * @param list2
    // */
    // public static <T> List<T> getDifferent(List<T> list1, List<T> list2) {
    // try {
    // Map<T, Integer> map = new HashMap<T, Integer>(list1.size() + list2.size());
    // List<T> diff = new ArrayList<T>();
    // List<T> maxList = list1;
    // List<T> minList = list2;
    // if (list2.size() > list1.size()) {
    // maxList = list2;
    // minList = list1;
    // }
    // for (T item : maxList) {
    // map.put(item, 1);
    // }
    // for (T item : minList) {
    // Integer cc = map.get(item);
    // if (cc != null) {
    // map.put(item, ++cc);
    // continue;
    // }
    // map.put(item, 1);
    // }
    // for (Map.Entry<T, Integer> entry : map.entrySet()) {
    // if (entry.getValue() == 1) {
    // diff.add(entry.getKey());
    // }
    // }
    // return diff;
    // } catch (Exception ex) {
    // return null;
    // }
    // }
}
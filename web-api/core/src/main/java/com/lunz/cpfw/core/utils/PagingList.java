package com.lunz.cpfw.core.utils;

import java.util.List;

public class PagingList {
    public static <T> List<T> GetPagingData(Integer pageSize, Integer pageIndex, List<T> data) throws Exception {
        if (pageSize != null && pageIndex != null && pageSize > 0) {
            int fromIndex = pageIndex * pageSize;
            int toIndex = (pageIndex + 1) * pageSize;
            data = data.subList(fromIndex, toIndex);
        }

        return data;
    }
}
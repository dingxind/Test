package com.lunz.cpfw.core.interaction;

import java.io.Serializable;
import java.util.List;

public class PagingOptions implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageIndex;
    private Integer pageSize;
    private List<PagingSort> sorts;
    private List<PagingFilter> filters;

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setSorts(List<PagingSort> sorts) {
        this.sorts = sorts;
    }

    public List<PagingSort> getSorts() {
        return this.sorts;
    }

    public void setFilters(List<PagingFilter> filters) {
        this.filters = filters;
    }

    public List<PagingFilter> getFilters() {
        return this.filters;
    }
}
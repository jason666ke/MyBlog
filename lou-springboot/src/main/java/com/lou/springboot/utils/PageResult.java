package com.lou.springboot.utils;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {

    // total count
    private int totalCount;
    // count each page
    private int pageSize;
    // page num
    private int totalPage;
    // cur page index
    private int curPage;
    // list data
    private List<?> list;

    /**
     * page device
     * @param totalCount
     * @param pageSize
     * @param totalPage
     * @param curPage
     * @param list
     */
    public PageResult(int totalCount, int pageSize, int curPage, List<?> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
        this.curPage = curPage;
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}

package com.lou.springboot.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class PageUtil extends LinkedHashMap<String, Object> {

    // cur page index
    private int page;
    // list size on each page
    private int limit;

    public PageUtil(Map<String, Object> params) {
        this.putAll(params);

        // paging parameter
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("start", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}

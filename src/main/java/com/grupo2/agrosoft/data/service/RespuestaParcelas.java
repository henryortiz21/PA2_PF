package com.grupo2.agrosoft.data.service;

import com.grupo2.agrosoft.data.entity.Parcelas;

import java.util.List;

public class RespuestaParcelas {
    private List<Parcelas> items;
    private boolean hashMore;
    private int limit;
    private int offset;
    private int count;

    public List<Parcelas> getItems() {
        return items;
    }

    public void setItems(List<Parcelas> items) {
        this.items = items;
    }

    public boolean isHashMore() {
        return hashMore;
    }

    public void setHashMore(boolean hashMore) {
        this.hashMore = hashMore;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

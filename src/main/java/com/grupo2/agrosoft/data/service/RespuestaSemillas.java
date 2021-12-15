package com.grupo2.agrosoft.data.service;

import java.util.List;

import com.grupo2.agrosoft.data.entity.Semilla;

public class RespuestaSemillas {
    private List<Semilla> items;
    private boolean hashMore;
    private int limit;
    private int offset;
    private int count;

    public List<Semilla> getItems() {
        return items;
    }

    public void setItems(List<Semilla> items) {
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

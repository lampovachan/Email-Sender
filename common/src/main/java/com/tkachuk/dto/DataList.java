package com.tkachuk.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents storage for dto so it would be easy to keep.
 * @author Svitlana Tkachuk
 */
public class DataList {
    private List<Data> data = new ArrayList<>();

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}

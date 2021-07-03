package com.tkachuk.producer.rest.services;

import com.tkachuk.dto.Data;

import java.util.List;

public interface ApiService {
    List<Data> getData(Integer limit);
}

package com.tkachuk.producer.rest.services;

import com.tkachuk.dto.Data;
import com.tkachuk.dto.DataList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * This class implements method for receiving data using RestTemplate.
 * @author Svitlana Tkachuk
 */
@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;
    private String apiUrl;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api_url}")String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @Override
    public List<Data> getData(Integer limit) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(apiUrl)
                .queryParam("limit", limit);

        DataList data = restTemplate.getForObject(builder.toUriString(), DataList.class);
        return data.getData();
    }
}

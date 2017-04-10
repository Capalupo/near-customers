package com.capalupo.intercom.nc.repository.http;

import com.capalupo.intercom.nc.repository.RepositoryImpl;
import com.capalupo.intercom.nc.repository.query.HttpQuery;
import com.capalupo.intercom.nc.repository.query.IQuery;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class HttpRepository extends RepositoryImpl{

    private Logger LOGGER = LoggerFactory.getLogger(HttpRepository.class);

    @Override
    public List<String> read(IQuery query) {

        if (null == query || !(query instanceof HttpQuery)) throw new IllegalArgumentException("Invalid Query Type. Expected: HttpQuery");
        HttpQuery httpQuery = (HttpQuery) query;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(httpQuery.toString());

        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            throw new IllegalArgumentException("Problem during customer data file from[" +
                                             httpQuery.toString() + "]");
        }

        List<String> customerList = new ArrayList<>();

        try {
            customerList = IOUtils.readLines(response.getEntity().getContent(), "utf-8");
        } catch (IOException e) {

            LOGGER.error("Error during data request. URL{}", httpQuery.toString());

        }

        return customerList;
    }
}

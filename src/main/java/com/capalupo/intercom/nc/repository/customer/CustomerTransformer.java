package com.capalupo.intercom.nc.repository.customer;

import com.capalupo.intercom.nc.model.Customer;
import com.google.gson.Gson;

import java.util.function.Function;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class CustomerTransformer implements Function<String, Customer>{

    @Override
    public Customer apply(String s) {
        return new Gson().fromJson(s, Customer.class);
    }
}

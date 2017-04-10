package com.capalupo.intercom.nc.repository.customer;

import com.capalupo.intercom.nc.model.Customer;

import java.util.List;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public interface ICustomer {

    List<Customer> extractNearCustomers(String url);
}

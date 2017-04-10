package com.capalupo.intercom.nc.repository.customer;

import com.capalupo.intercom.nc.model.Customer;

import java.util.Comparator;

/**
 * Created by Igor Capalupo on 10/04/2017.
 */
public class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

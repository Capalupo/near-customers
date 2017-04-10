package com.capalupo.intercom.nc.repository.customer;

import com.capalupo.intercom.nc.model.Customer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class CustomerTransformerTest {
    @Test
    public void apply() {
        String sampleJSON = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}";
        CustomerTransformer ct = new CustomerTransformer();
        Customer c1 = ct.apply(sampleJSON);
        Customer c2 = new Customer(12L,"Christina McArdle", 52.986375D, -6.043701D);
        Assert.assertEquals(c1, c2);
        Assert.assertEquals(c1.getDistanceFromBase(), c2.getDistanceFromBase());

    }

}
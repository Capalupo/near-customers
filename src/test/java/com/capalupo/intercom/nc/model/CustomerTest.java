package com.capalupo.intercom.nc.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class CustomerTest {
@Test
public void isNearBase_positive() {
        Customer c1 = new Customer(1L,"IGOR", 53.3393,-6.2576841);
        Assert.assertEquals(c1.isNearBase(), true);
    }

    @Test
    public void isNearBase_negative() {
        Customer c1 = new Customer(1L,"IGOR", 12.3393,-6.2576841);
        Assert.assertEquals(c1.isNearBase(), false);
    }

}
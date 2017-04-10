package com.capalupo.intercom.nc.repository.customer;

import com.capalupo.intercom.nc.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.isA;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class CustomerCollectorTest {

    private static CustomerCollector collector;

    @Before
    public void setup(){

        collector = new CustomerCollector();

    }

    @Test
    public void supplier() {

        Supplier<ArrayList<Customer>> sp = ArrayList::new;
        Assert.assertThat(collector.supplier(),isA(Supplier.class));
        Assert.assertThat(collector.supplier().get(), isA(ArrayList.class));
        Assert.assertThat(collector.supplier().get().size(), equalTo(sp.get().size()));


    }


    @Test
    public void combiner() {
        ArrayList<Customer> list1 = new ArrayList<>();
        Customer c1 = new Customer(1L, "IGOR", 30D, -6D);
        list1.add(c1);

        ArrayList<Customer> list2 = new ArrayList<>();
        collector.combiner().apply(list2, list1);

        Assert.assertTrue(list2.contains(c1));
        Assert.assertTrue(list2.size() == 1);

    }

    @Test
    public void finisher() {
        ArrayList<Customer> list1 = new ArrayList<>();
        Customer c1 = new Customer(1L, "IGOR", 30D, -6D);
        list1.add(c1);
        Assert.assertThat(collector.finisher().apply(list1),isA(List.class));

    }


}
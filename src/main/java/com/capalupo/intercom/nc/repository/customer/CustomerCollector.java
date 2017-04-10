package com.capalupo.intercom.nc.repository.customer;

import com.capalupo.intercom.nc.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class CustomerCollector implements Collector <Customer, ArrayList<Customer>, ArrayList<Customer>>{


    @Override
    public Supplier<ArrayList<Customer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<Customer>, Customer> accumulator() {
        return ArrayList::add;
    }

    @Override
    public BinaryOperator<ArrayList<Customer>> combiner() {
        return (accumulatorList, moreData) ->{
            accumulatorList.addAll(moreData);
            return accumulatorList;
        };
    }

    @Override
    public Function<ArrayList<Customer>, ArrayList<Customer>> finisher() {
        return (accumulatorList) -> {
            Collections.sort(accumulatorList, new CustomerComparator());
            return accumulatorList;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}

package com.capalupo.intercom.nc.service;

import com.capalupo.intercom.nc.repository.customer.CustomerRepository;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class NearCustomersService {

    public static void main(String[] args) {

        CustomerRepository repo = new CustomerRepository();

        String url ="https://gist.githubusercontent.com/brianw/19896c50afa89ad4dec3/raw/6c11047887a03483c50017c1d451667fd62a53ca/gistfile1.txt";

        System.out.println("CONGRATULATIONS, YOU'VE FOUND YOUR NEAREST CUSTOMERS!\n");
        repo.extractNearCustomers(url).forEach(System.out::println);

    }
}

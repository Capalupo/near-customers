package com.capalupo.intercom.nc.repository.customer;

import com.capalupo.intercom.nc.model.Customer;
import com.capalupo.intercom.nc.repository.Repository;
import com.capalupo.intercom.nc.repository.http.HttpRepository;
import com.capalupo.intercom.nc.repository.query.HttpQuery;

import java.util.List;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */

public class CustomerRepository extends Repository<Customer> implements ICustomer {

    private HttpRepository httpRepository = new HttpRepository();

    private CustomerTransformer customerTransformer = new CustomerTransformer();

    private CustomerCollector collector = new CustomerCollector();

    @Override
    public List<Customer> extractNearCustomers(String fileUrl) {

        HttpQuery httpQuery = new HttpQuery(fileUrl);

        return httpRepository.read(httpQuery).stream()
                                             .parallel()
                                             .map(c -> customerTransformer.apply(c))
                                             .filter(Customer::isNearBase)
                                             .collect(collector);
    }

    public void setHttpRepository(HttpRepository httpRepository) {
        this.httpRepository = httpRepository;
    }
}

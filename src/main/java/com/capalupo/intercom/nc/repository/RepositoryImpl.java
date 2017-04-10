package com.capalupo.intercom.nc.repository;

import com.capalupo.intercom.nc.repository.query.IQuery;

import java.util.List;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public abstract class RepositoryImpl {

    public abstract <T> List<T> read(IQuery query);

}

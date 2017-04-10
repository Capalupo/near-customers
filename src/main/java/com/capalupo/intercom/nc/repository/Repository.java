package com.capalupo.intercom.nc.repository;

import com.capalupo.intercom.nc.repository.query.IQuery;

import java.util.List;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class Repository<T> implements IRepository<T>{

    private RepositoryImpl repositoryImpl;

    public List<T> read(IQuery query){
        return repositoryImpl.read(query);
    }

}

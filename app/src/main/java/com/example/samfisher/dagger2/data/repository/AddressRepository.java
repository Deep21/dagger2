package com.example.samfisher.dagger2.data.repository;

import com.example.samfisher.dagger2.data.entity.Address;
import com.example.samfisher.dagger2.data.DataSource;
import com.example.samfisher.dagger2.data.remote.AddressDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 26/09/2017.
 */

public class AddressRepository implements DataSource<Address> {

    private AddressDataSource remoteService;

    @Inject
    public AddressRepository(AddressDataSource remoteService) {
        this.remoteService = remoteService;
    }

    @Override
    public Observable<List<Address>> getList() {
        return remoteService.getList();
    }

    @Override
    public Observable<Address> getDetail(int id) {
        return null;
    }
}

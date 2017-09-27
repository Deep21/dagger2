package com.example.samfisher.dagger2.interactor.address;

import com.example.samfisher.dagger2.Address;
import com.example.samfisher.dagger2.data.remote.AddressDataSource;
import com.example.samfisher.dagger2.interactor.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 29/09/2017.
 */

public class AddressListInteractor extends BaseInteractor<List<Address>, Void> {

    private final AddressDataSource remoteService;

    @Override
    public Observable<List<Address>> getObservable() {
        return remoteService.getList();
    }

    @Inject
    public AddressListInteractor(AddressDataSource remoteService) {
        this.remoteService = remoteService;
    }

}

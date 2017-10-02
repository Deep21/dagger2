package com.example.samfisher.dagger2.interactor.address;

import com.example.samfisher.dagger2.data.entity.Address;
import com.example.samfisher.dagger2.data.repository.AddressRepository;
import com.example.samfisher.dagger2.interactor.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 29/09/2017.
 */

public class AddressListInteractor extends BaseInteractor<List<Address>, Void> {

    private final AddressRepository addressRepository;

    @Override
    public Observable<List<Address>> getObservable(Void aVoid) {
        return addressRepository.getList();
    }

    @Inject
    public AddressListInteractor(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

}

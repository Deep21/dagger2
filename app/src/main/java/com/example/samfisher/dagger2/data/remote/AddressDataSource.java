package com.example.samfisher.dagger2.data.remote;

import com.example.samfisher.dagger2.Address;
import com.example.samfisher.dagger2.InvoiceApi;
import com.example.samfisher.dagger2.data.DataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 26/09/2017.
 */

public class AddressDataSource implements DataSource<Address> {

    private InvoiceApi invoiceApi;

    @Inject
    public AddressDataSource(InvoiceApi invoiceApi) {
        this.invoiceApi = invoiceApi;
    }

    @Override
    public Observable<List<Address>> getList() {
        return invoiceApi.getListAddress();
    }

    @Override
    public Observable<Address> getDetail(int id) {
        return null;
    }
}

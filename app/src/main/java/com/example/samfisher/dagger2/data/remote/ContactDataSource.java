package com.example.samfisher.dagger2.data.remote;

import com.example.samfisher.dagger2.data.entity.Address;
import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.InvoiceApi;
import com.example.samfisher.dagger2.data.DataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 26/09/2017.
 */

public class ContactDataSource implements DataSource<Contact> {

    private InvoiceApi invoiceApi;

    @Inject
    public ContactDataSource(InvoiceApi invoiceApi) {
        this.invoiceApi = invoiceApi;
    }

    @Override
    public Observable<List<Contact>> getList() {
        return invoiceApi.getListContacts();
    }

    @Override
    public Observable<Contact> getDetail(int id) {
        return invoiceApi.getContact(id);
    }

    public Observable<List<Address>> getAddress() {
        return invoiceApi.getListAddress();
    }
}

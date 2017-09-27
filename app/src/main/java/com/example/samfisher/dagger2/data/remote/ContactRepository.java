package com.example.samfisher.dagger2.data.remote;

import com.example.samfisher.dagger2.Contact;
import com.example.samfisher.dagger2.data.DataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 26/09/2017.
 */

public class ContactRepository implements DataSource<Contact> {

    private ContactDataSource remoteService;

    @Inject
    public ContactRepository(ContactDataSource remoteService) {
        this.remoteService = remoteService;
    }

    @Override
    public Observable<List<Contact>> getList() {
        return remoteService.getList();
    }

    @Override
    public Observable<Contact> getDetail() {
        return remoteService.getDetail();
    }
}

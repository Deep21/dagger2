package com.example.samfisher.dagger2.data.repository;

import com.example.samfisher.dagger2.data.ContactModel;
import com.example.samfisher.dagger2.data.entity.Address;
import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.data.DataSource;
import com.example.samfisher.dagger2.data.remote.ContactDataSource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import timber.log.Timber;

/**
 * Created by Samfisher on 26/09/2017.
 */

public class ContactRepository implements IContactRepository {

    private ContactDataSource contactDataSource;

    @Inject
    public ContactRepository(ContactDataSource contactDataSource) {
        this.contactDataSource = contactDataSource;
    }

    @Override
    public Observable<List<ContactModel>> getList() {
        return contactDataSource.getList().flatMap(new Function<List<Contact>, ObservableSource<List<Address>>>() {
            @Override
            public ObservableSource<List<Address>> apply(@NonNull List<Contact> contacts) throws Exception {
                return contactDataSource.getAddress();
            }
        }).map(new Function<List<Address>, List<ContactModel>>() {
            @Override
            public List<ContactModel> apply(@NonNull List<Address> addresses) throws Exception {
                return null;
            }
        })

                ;
    }

    @Override
    public Observable<ContactModel> getDetail(int id) {
        return contactDataSource.getDetail(id).map(new Function<Contact, ContactModel>() {
            @Override
            public ContactModel apply(@NonNull Contact contact) throws Exception {
                return null;
            }
        });
    }
}

package com.example.samfisher.dagger2.data.repository;

import com.example.samfisher.dagger2.data.mapper.UserDataMapper;
import com.example.samfisher.dagger2.presenter.model.ContactModel;
import com.example.samfisher.dagger2.data.entity.Address;
import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.data.remote.ContactDataSource;

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
    private UserDataMapper userDataMapper;

    @Inject
    public ContactRepository(ContactDataSource contactDataSource, UserDataMapper userDataMapper) {
        this.contactDataSource = contactDataSource;
        this.userDataMapper = userDataMapper;
    }

    @Override
    public Observable<List<ContactModel>> getList() {
        return contactDataSource
                .getList()
                .map(new Function<List<Contact>, List<ContactModel>>() {
                    @Override
                    public List<ContactModel> apply(@NonNull List<Contact> contacts) throws Exception {
                        return userDataMapper.mapCollection(contacts);
                    }
                });

    }

    @Override
    public Observable<ContactModel> getDetail(int id) {
        return contactDataSource
                .getDetail(id)
                .map(new Function<Contact, ContactModel>() {
            @Override
            public ContactModel apply(@NonNull Contact contact) throws Exception {
                return userDataMapper.map(contact);
            }
        });
    }
}

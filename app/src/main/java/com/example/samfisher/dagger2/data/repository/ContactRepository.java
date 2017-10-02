package com.example.samfisher.dagger2.data.repository;

import com.example.samfisher.dagger2.data.ContactModel;
import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.data.DataSource;
import com.example.samfisher.dagger2.data.remote.ContactDataSource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
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
        return contactDataSource.getList()
                .map(new Function<List<Contact>, List<ContactModel>>() {
                    @Override
                    public List<ContactModel> apply(@NonNull List<Contact> contacts) throws Exception {
                        List<ContactModel> contactModels = new ArrayList<>();
                        for (Contact contact : contacts) {
                            ContactModel contactModel = new ContactModel();
                            contactModel.setFirstname(contact.getFirstname());
                            contactModel.setLastname(contact.getLastname());
                            contactModel.setEmail(contact.getEmail());
                            contactModel.setCompany(contact.getCompany());
                            contactModel.setBirthday(contact.getBirthday());
                            contactModels.add(contactModel);
                        }
                        return contactModels;
                    }
                });
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

package com.example.samfisher.dagger2.interactor.contact;

import com.example.samfisher.dagger2.Contact;
import com.example.samfisher.dagger2.data.remote.ContactDataSource;
import com.example.samfisher.dagger2.data.remote.ContactRepository;
import com.example.samfisher.dagger2.interactor.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 29/09/2017.
 */

public class ContactDetailInteractor extends BaseInteractor<Contact, Void> {

    private ContactRepository contactRepository;

    @Inject
    public ContactDetailInteractor(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Observable<Contact> getObservable() {
        return contactRepository.getDetail();
    }


}

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

public class ContactDetailInteractor extends BaseInteractor<Contact, ContactDetailInteractor.Params> {

    private ContactRepository contactRepository;

    @Inject
    public ContactDetailInteractor(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Observable<Contact> getObservable(Params params) {
        return contactRepository.getDetail(params.contactId);
    }

    public static final class Params {

        private final int contactId;

        private Params(int contactId) {
            this.contactId = contactId;
        }

        public static Params forContact(int contactId) {
            return new Params(contactId);
        }
    }

}

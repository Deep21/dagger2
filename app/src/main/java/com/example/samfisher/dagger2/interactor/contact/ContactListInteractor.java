package com.example.samfisher.dagger2.interactor.contact;

import com.example.samfisher.dagger2.data.ContactModel;
import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.data.repository.ContactRepository;
import com.example.samfisher.dagger2.interactor.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 29/09/2017.
 */

public class ContactListInteractor extends BaseInteractor<List<ContactModel>, Void> {

    private ContactRepository contactRepository;

    @Inject
    public ContactListInteractor(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Observable<List<ContactModel>> getObservable(Void aVoid) {
        return contactRepository.getList();
    }

}

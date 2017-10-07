package com.example.samfisher.dagger2.data;

import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.presenter.model.ContactModel;

import javax.inject.Inject;

/**
 * Created by Samfisher on 07/10/2017.
 */

public class UserDataMapper implements EntityDataMapper<Contact, ContactModel> {

    @Inject
    public UserDataMapper() {
    }

    @Override
    public ContactModel transform(Contact contact) {
        return null;
    }
}

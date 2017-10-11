package com.example.samfisher.dagger2.data.mapper;

import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.presenter.model.ContactModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Samfisher on 07/10/2017.
 */

public class UserDataMapper implements EntityMapper<Contact, ContactModel> {

    @Inject
    public UserDataMapper() {
    }

    @Override
    public ContactModel map(Contact contact) {
        ContactModel contactModel = new ContactModel();
        contactModel.setId(contact.getId());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setLastname(contact.getLastname());
        contactModel.setEmail(contact.getEmail());
        contactModel.setCompany(contact.getCompany());
        contactModel.setBirthday(contact.getBirthday());
        return contactModel;
    }

    @Override
    public List<ContactModel> mapCollection(Collection<Contact> contacts) {
        List<ContactModel> contactModels = new ArrayList<>();
        for (Contact contact : contacts) {
            ContactModel contactModel = new ContactModel();
            contactModel.setId(contact.getId());
            contactModel.setFirstname(contact.getFirstname());
            contactModel.setLastname(contact.getLastname());
            contactModel.setEmail(contact.getEmail());
            contactModel.setCompany(contact.getCompany());
            contactModel.setBirthday(contact.getBirthday());
            contactModels.add(contactModel);
        }
        return contactModels;
    }


}

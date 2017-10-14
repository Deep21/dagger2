package com.example.samfisher.dagger2.data.mapper;

import com.example.samfisher.dagger2.data.local.entity.ContactRealmObject;
import com.example.samfisher.dagger2.presenter.model.ContactModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import io.realm.RealmResults;
import timber.log.Timber;

/**
 * Created by Samfisher on 07/10/2017.
 */

public class LocalContactDataMapper implements RealmEntityMapper<ContactRealmObject, ContactModel> {

    @Inject
    public LocalContactDataMapper() {
    }

    @Override
    public List<ContactModel> mapCollection(RealmResults<ContactRealmObject> contactRealmObjects) {
        List<ContactModel> contactModelList = new ArrayList<>();
        for (ContactRealmObject contactRealmObject : contactRealmObjects) {
            ContactModel contactModel = new ContactModel();
            contactModel.setCompany(contactRealmObject.getCompany());
            contactModel.setFirstname(contactRealmObject.getFirstName());
            contactModel.setLastname(contactRealmObject.getLastName());
            contactModel.setCompany(contactRealmObject.getCompany());
            contactModelList.add(contactModel);
        }
        return contactModelList;
    }

    @Override
    public ContactModel map(ContactRealmObject contactRealmObject) {
        return null;
    }


}

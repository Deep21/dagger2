package com.example.samfisher.dagger2.data.repository;

import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.data.local.LocalContactDataSource;
import com.example.samfisher.dagger2.data.local.entity.ContactRealmObject;
import com.example.samfisher.dagger2.data.mapper.LocalContactDataMapper;
import com.example.samfisher.dagger2.data.mapper.UserDataMapper;
import com.example.samfisher.dagger2.data.remote.ContactDataSource;
import com.example.samfisher.dagger2.presenter.model.ContactModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.realm.RealmResults;
import timber.log.Timber;

/**
 * Created by Samfisher on 26/09/2017.
 */

public class ContactRepository implements IContactRepository {

    private ContactDataSource contactDataSource;
    private LocalContactDataSource localDataSource;
    private UserDataMapper userDataMapper;
    private LocalContactDataMapper localContactDataMapper;

    @Inject
    public ContactRepository(ContactDataSource contactDataSource, LocalContactDataSource localDataSource, UserDataMapper userDataMapper, LocalContactDataMapper localContactDataMapper) {
        this.contactDataSource = contactDataSource;
        this.localDataSource = localDataSource;
        this.userDataMapper = userDataMapper;
        this.localContactDataMapper = localContactDataMapper;
    }

    //TODO créer uns ervice qui gère ca
    @Override
    public Observable<List<ContactModel>> getList() {
        return localDataSource.getList()
                .map(new Function<RealmResults<ContactRealmObject>, List<ContactModel>>() {
                    @Override
                    public List<ContactModel> apply(@NonNull RealmResults<ContactRealmObject> contactRealmObjects) throws Exception {
                        return localContactDataMapper.mapCollection(contactRealmObjects);
                    }
                })
                ;
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

    @Override
    public Observable<Void> post() {
        return null;
    }
}

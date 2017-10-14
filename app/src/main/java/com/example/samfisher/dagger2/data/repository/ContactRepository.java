package com.example.samfisher.dagger2.data.repository;

import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.data.local.LocalContactDataSource;
import com.example.samfisher.dagger2.data.local.entity.ContactRealmObject;
import com.example.samfisher.dagger2.data.mapper.LocalContactDataMapper;
import com.example.samfisher.dagger2.data.mapper.UserDataMapper;
import com.example.samfisher.dagger2.data.remote.ContactRemoteDataSource;
import com.example.samfisher.dagger2.presenter.model.ContactModel;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.realm.Realm;
import io.realm.RealmResults;
import okhttp3.ResponseBody;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Samfisher on 26/09/2017.
 */

public class ContactRepository implements IContactRepository {

    private ContactRemoteDataSource contactRemoteDataSource;
    private LocalContactDataSource localDataSource;
    private UserDataMapper userDataMapper;
    private LocalContactDataMapper localContactDataMapper;

    @Inject
    public ContactRepository(ContactRemoteDataSource contactRemoteDataSource, LocalContactDataSource localDataSource, UserDataMapper userDataMapper, LocalContactDataMapper localContactDataMapper) {
        this.contactRemoteDataSource = contactRemoteDataSource;
        this.localDataSource = localDataSource;
        this.userDataMapper = userDataMapper;
        this.localContactDataMapper = localContactDataMapper;
    }

    @Override
    public Observable<List<ContactModel>> getList() {
        return null;
    }

    @Override
    public Observable<ContactModel> getDetail(int id) {
        return null;
    }

    @Override
    public Observable<Response<ResponseBody>> post() {
        Contact contact = new Contact();
        contact.setEmail("puma@hotmail.fr");
        contact.setBirthday("1988-08-03");
        return contactRemoteDataSource.post(contact);
    }
}

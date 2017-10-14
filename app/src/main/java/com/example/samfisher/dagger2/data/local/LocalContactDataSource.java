package com.example.samfisher.dagger2.data.local;

import android.content.Context;
import android.widget.Toast;

import com.example.samfisher.dagger2.data.ILocalRepository;
import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.data.DataSource;
import com.example.samfisher.dagger2.data.local.entity.ContactRealmObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import timber.log.Timber;

/**
 * Created by Samfisher on 26/09/2017.
 */

public class LocalContactDataSource implements ILocalRepository {

    private Context context;

    @Inject
    public LocalContactDataSource(Context context) {
        this.context = context;
    }

    @Override
    public Observable<RealmResults<ContactRealmObject>> getList() {
        return Observable.create(new ObservableOnSubscribe<RealmResults<ContactRealmObject>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<RealmResults<ContactRealmObject>> e) throws Exception {
                Realm realm = Realm.getDefaultInstance();
                RealmResults<ContactRealmObject> contactRealmResults = realm.where(ContactRealmObject.class).findAll();
                e.onNext(contactRealmResults);
                e.onComplete();
            }
        });
    }

    public void save(List<Contact> contacts) {
        Observable.create(new ObservableOnSubscribe<List<Contact>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Contact>> e) throws Exception {
                try {
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    ContactRealmObject contactRealmObject = realm.createObject(ContactRealmObject.class, 1);
                    Timber.d("%s", contactRealmObject);
                    contactRealmObject.setCompany("");
                    contactRealmObject.setLastName("Wickrema");
                    contactRealmObject.setFirstName("Deeptha");
                    realm.commitTransaction();
                } catch (Throwable ed) {
                    Timber.d("%s", ed);
                }
                List<Contact> r = new ArrayList<>();
                Contact contact = new Contact();
                contact.setCompany("Pumaa");
                r.add(contact);
                e.onNext(r);
                e.onComplete();
            }
        });
    }
}

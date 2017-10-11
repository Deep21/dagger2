package com.example.samfisher.dagger2.data;

import com.example.samfisher.dagger2.data.local.entity.ContactRealmObject;

import io.reactivex.Observable;
import io.realm.RealmResults;

/**
 * Created by deept on 10/10/2017.
 */

public interface ILocalRepository {

    Observable<RealmResults<ContactRealmObject>> getList();
}

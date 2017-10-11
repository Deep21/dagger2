package com.example.samfisher.dagger2.data.mapper;

import java.util.List;

import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by deept on 07/10/2017.
 */

public interface RealmEntityMapper<T extends RealmObject, V> {

    List<V> mapCollection(RealmResults<T> t);
}

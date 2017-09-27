package com.example.samfisher.dagger2.data;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Samfisher on 29/09/2017.
 */

public interface DataSource<T> {

    Observable<List<T>> getList();

    Observable<T> getDetail();
}

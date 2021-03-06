package com.example.samfisher.dagger2.data.repository;

import com.example.samfisher.dagger2.data.ContactModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by deept on 06/10/2017.
 */

public interface IContactRepository {

    Observable<List<ContactModel>> getList();

    Observable<ContactModel> getDetail(int id);
}

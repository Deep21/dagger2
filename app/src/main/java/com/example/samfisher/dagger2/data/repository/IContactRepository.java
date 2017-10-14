package com.example.samfisher.dagger2.data.repository;

import com.example.samfisher.dagger2.presenter.model.ContactModel;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by deept on 06/10/2017.
 */

public interface IContactRepository {

    Observable<List<ContactModel>> getList();

    Observable<ContactModel> getDetail(int id);

    Observable<Response<ResponseBody>> post();
}

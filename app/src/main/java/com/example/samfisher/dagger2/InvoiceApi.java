package com.example.samfisher.dagger2;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Samfisher on 11/09/2017.
 */

public interface InvoiceApi {

    @GET("contacts")
    Observable<List<Contact>> getListContacts();

    @GET("contact/{id}")
    Observable<Contact> getContact(@Path("id") int id);

    @GET("address")
    Observable<List<Address>> getListAddress();
}

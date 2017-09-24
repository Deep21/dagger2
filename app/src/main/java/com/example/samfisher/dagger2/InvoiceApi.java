package com.example.samfisher.dagger2;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Samfisher on 11/09/2017.
 */

public interface InvoiceApi {

    @GET("contacts")
    Observable<List<Contact>> getListContacts();
}

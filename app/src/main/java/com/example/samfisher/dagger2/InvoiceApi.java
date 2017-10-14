package com.example.samfisher.dagger2;

import com.example.samfisher.dagger2.data.entity.Address;
import com.example.samfisher.dagger2.data.entity.Contact;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @POST("contact")
    Observable<Response<ResponseBody>> post(@Body Contact contact);
}

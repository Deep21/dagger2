package com.example.samfisher.dagger2.interactors;

import com.example.samfisher.dagger2.Contact;
import com.example.samfisher.dagger2.InvoiceApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Samfisher on 22/09/2017.
 */

public class ContactInteractor {

    private InvoiceApi invoiceApi;

    @Inject
    public ContactInteractor(InvoiceApi invoiceApi) {
        this.invoiceApi = invoiceApi;
    }

    public Disposable execute(DisposableObserver<List<Contact>> listDisposableObserver) {
         return invoiceApi.getListContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(listDisposableObserver);

    }
}

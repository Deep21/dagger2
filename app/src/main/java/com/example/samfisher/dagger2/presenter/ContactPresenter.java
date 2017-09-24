package com.example.samfisher.dagger2.presenter;

import com.example.samfisher.dagger2.Contact;
import com.example.samfisher.dagger2.interactors.ContactInteractor;
import com.example.samfisher.dagger2.views.ContactView;
import com.example.samfisher.dagger2.views.View;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

/**
 * Created by Samfisher on 22/09/2017.
 */

public class ContactPresenter implements BasePresenter {

    private ContactInteractor contactInteractor;
    private ContactView view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public ContactPresenter(ContactInteractor contactInteractor) {
        this.contactInteractor = contactInteractor;
    }

    @Override
    public void onBindView(View view) {

    }

    @Override
    public void onDestroyView() {

    }

    public void getListContact()
    {
        DisposableObserver<List<Contact>> observer =  new DisposableObserver<List<Contact>>() {
            @Override
            public void onNext(@NonNull List<Contact> contacts) {
                view.onSuccess(contacts);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Timber.e("%s", e);

            }

            @Override
            public void onComplete() {
                Timber.i("onComplete");
            }
        };

        Disposable disposable = contactInteractor.execute(observer);
        compositeDisposable.add(disposable);

    }


}

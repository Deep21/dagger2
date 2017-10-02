package com.example.samfisher.dagger2.presenter;

import com.example.samfisher.dagger2.data.ContactModel;
import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.interactor.contact.ContactListInteractor;
import com.example.samfisher.dagger2.views.ContactView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

/**
 * Created by Samfisher on 22/09/2017.
 */

public class ContactListPresenter implements BasePresenter<ContactView> {

    private ContactListInteractor contactInteractor;
    private ContactView view;

    @Inject
    public ContactListPresenter(ContactListInteractor contactInteractor) {
        this.contactInteractor = contactInteractor;

    }

    @Override
    public void onBindView(ContactView view) {
        this.view = view;

    }

    @Override
    public void onDestroyView() {
        this.view = null;
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onStop() {
        contactInteractor.dispose();
    }


    public void getListContact() {
        contactInteractor.excecute(new DisposableObserver<List<ContactModel>>() {
            @Override
            public void onNext(@NonNull List<ContactModel> contactModels) {
                Timber.d("%s", contactModels);
                view.onSuccess(contactModels);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, null);

    }

    public void onClick(Contact contact) {

    }
}

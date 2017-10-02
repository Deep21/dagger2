package com.example.samfisher.dagger2.presenter;

import com.example.samfisher.dagger2.data.ContactModel;
import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.interactor.contact.ContactDetailInteractor;
import com.example.samfisher.dagger2.views.ContactDetailView;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

/**
 * Created by Samfisher on 22/09/2017.
 */

public class ContactDetailPresenter implements BasePresenter<ContactDetailView> {

    private ContactDetailInteractor contactInteractor;
    private ContactDetailView view;

    @Inject
    public ContactDetailPresenter(ContactDetailInteractor contactInteractor) {
        this.contactInteractor = contactInteractor;

    }

    @Override
    public void onBindView(ContactDetailView view) {
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


    public void getContact(int id) {
        contactInteractor.excecute(new ContactDisposable(), ContactDetailInteractor.Params.forContact(id));
    }

    private final class ContactDisposable extends DisposableObserver<ContactModel> {

        @Override
        public void onNext(@NonNull ContactModel contact) {
            //view.onSuccess(contact);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            Timber.d("%s", e);
        }

        @Override
        public void onComplete() {
            Timber.d("%s", "onComplete");
        }
    }

}

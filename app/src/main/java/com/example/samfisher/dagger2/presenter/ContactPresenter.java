package com.example.samfisher.dagger2.presenter;

import com.example.samfisher.dagger2.interactor.contact.ContactInteractor;
import com.example.samfisher.dagger2.views.ContactDetailView;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Samfisher on 22/09/2017.
 */

public class ContactPresenter implements BasePresenter<ContactDetailView> {

    private ContactInteractor contactInteractor;
    private ContactDetailView view;

    @Inject
    public ContactPresenter(ContactInteractor contactInteractor) {
        this.contactInteractor = contactInteractor;

    }

    @Override
    public void onBindView(ContactDetailView view) {
        this.view = view;
    }

    @Override
    public void onDestroyView() {
        view = null;
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onStop() {
        contactInteractor.dispose();
        view = null;
    }

    public void post() {
        Timber.d("%s", "post");
        contactInteractor.excecute(new ContactDisposable(), null);
    }

    private final class ContactDisposable extends DisposableObserver<Response<ResponseBody>> {

        @Override
        public void onNext(@NonNull Response<ResponseBody> responseBodyResponse) {
            Timber.d("%s", responseBodyResponse);
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

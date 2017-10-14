package com.example.samfisher.dagger2.interactor.contact;

import com.example.samfisher.dagger2.data.repository.ContactRepository;
import com.example.samfisher.dagger2.interactor.BaseInteractor;
import com.example.samfisher.dagger2.presenter.model.ContactModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Samfisher on 29/09/2017.
 */

public class ContactInteractor extends BaseInteractor<Response<ResponseBody>, ContactInteractor.Params> {

    private ContactRepository contactRepository;

    @Inject
    public ContactInteractor(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Observable<Response<ResponseBody>> getObservable(Params params) {
        Timber.d("%s", "getObservable");
        return contactRepository.post();
    }

    public static final class Params {
        int contactId;

        private Params(int contactId) {
            this.contactId = contactId;
        }

        public static Params forContact(int contactId) {
            return new Params(contactId);
        }
    }

}

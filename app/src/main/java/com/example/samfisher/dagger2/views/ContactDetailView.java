package com.example.samfisher.dagger2.views;

import com.example.samfisher.dagger2.presenter.model.ContactModel;

/**
 * Created by deept on 02/10/2017.
 */

public interface ContactDetailView extends View {

    void showError();

    void showSuccessful();

    void onSuccess(ContactModel contact);
}

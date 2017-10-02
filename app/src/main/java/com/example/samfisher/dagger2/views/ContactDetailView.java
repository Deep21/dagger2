package com.example.samfisher.dagger2.views;

import com.example.samfisher.dagger2.data.entity.Contact;

/**
 * Created by deept on 02/10/2017.
 */

public interface ContactDetailView extends View {

    void showError();

    void showSuccessful();

    void onSuccess(Contact contact);
}

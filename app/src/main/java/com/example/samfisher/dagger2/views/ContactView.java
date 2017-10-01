package com.example.samfisher.dagger2.views;

import com.example.samfisher.dagger2.Contact;

import java.util.List;

/**
 * Created by Samfisher on 22/09/2017.
 */

public interface ContactView extends View {

    void showError();
    void showSuccessful();
    void onSuccess(List<Contact> list);
}

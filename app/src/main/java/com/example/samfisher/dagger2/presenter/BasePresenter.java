package com.example.samfisher.dagger2.presenter;

import com.example.samfisher.dagger2.views.ContactView;
import com.example.samfisher.dagger2.views.View;

/**
 * Created by Samfisher on 22/09/2017.
 */

public interface BasePresenter {

    void onBindView(ContactView view);
    void onDestroyView();
    void onDestroy();
    void onStop();
}

package com.example.samfisher.dagger2.presenter;

import com.example.samfisher.dagger2.views.ContactView;
import com.example.samfisher.dagger2.views.View;

/**
 * Created by Samfisher on 22/09/2017.
 */

public interface BasePresenter<T> {

    void onBindView(T view);
    void onDestroyView();
    void onDestroy();
    void onStop();
}

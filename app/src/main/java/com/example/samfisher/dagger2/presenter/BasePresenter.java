package com.example.samfisher.dagger2.presenter;

import com.example.samfisher.dagger2.views.View;

/**
 * Created by Samfisher on 22/09/2017.
 */

public interface BasePresenter {

    void onBindView(View view);
    void onDestroyView();
}

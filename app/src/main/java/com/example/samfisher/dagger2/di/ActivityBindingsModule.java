package com.example.samfisher.dagger2.di;

import com.example.samfisher.dagger2.views.activities.ContactActivity;
import com.example.samfisher.dagger2.views.activities.MainActivity;
import com.example.samfisher.dagger2.views.fragments.ContactDetailFragment;
import com.example.samfisher.dagger2.views.fragments.ContactFormFragment;
import com.example.samfisher.dagger2.views.fragments.ContactListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Samfisher on 04/09/2017.
 */

@Module
abstract class ActivityBindingsModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MainActivity bindActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ContactActivity bindContactActivity();

    @ContributesAndroidInjector
    abstract ContactDetailFragment bindDetailFragment();

    @ContributesAndroidInjector
    abstract ContactListFragment bindContactListFragment();

}

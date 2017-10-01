package com.example.samfisher.dagger2.views.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.samfisher.dagger2.R;
import com.example.samfisher.dagger2.views.fragments.ContactDetailFragment;
import com.example.samfisher.dagger2.views.fragments.ContactFormFragment;
import com.example.samfisher.dagger2.views.fragments.ContactListFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import timber.log.Timber;

public class ContactActivity extends AppCompatActivity implements
        ContactListFragment.OnFragmentInteractionListener,
        ContactDetailFragment.OnFragmentInteractionListener,
        HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> androidInjector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.contentContainer, ContactListFragment.newInstance(), ContactListFragment.TAG)
                .addToBackStack(null)
                .commit();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onFragmentInteraction(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentContainer, ContactDetailFragment.newInstance(position), ContactDetailFragment.TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return androidInjector;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

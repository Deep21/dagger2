package com.example.samfisher.dagger2.views;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.samfisher.dagger2.Contact;
import com.example.samfisher.dagger2.InvoiceApi;
import com.example.samfisher.dagger2.R;
import com.example.samfisher.dagger2.adapters.ContactListAdapter;
import com.example.samfisher.dagger2.presenter.ContactPresenter;
import com.example.samfisher.dagger2.views.fragments.ContactFormFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements ContactFormFragment.OnFragmentInteractionListener, HasSupportFragmentInjector, ContactView {
    @Inject
    DispatchingAndroidInjector<Fragment> androidInjector;

    @Inject
    ContactListAdapter contactListAdapter;

    @BindView(R.id.contact_recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    ContactPresenter contactPresenter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Timber.d("%s", contactPresenter);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<Contact> contacts = new ArrayList<>();
        Contact contact = new Contact();
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();
        contact.setEmail("eefzefzeffzefzeff");
        contact1.setEmail("eefzefzeffzefzeff");
        contact2.setEmail("eefzefzeffzefzeff");
        contacts.add(contact);
        contacts.add(contact1);
        contacts.add(contact2);
        contactListAdapter.setContactList(contacts);
        mRecyclerView.setAdapter(contactListAdapter);
        contactListAdapter.notifyDataSetChanged();
        contactPresenter.getListContact();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return androidInjector;
    }

    @Override
    public void showError() {

    }

    @Override
    public void showSuccessful() {

    }

    @Override
    public void onSuccess(List<Contact> list) {
        Timber.d("%s", list);
    }
}

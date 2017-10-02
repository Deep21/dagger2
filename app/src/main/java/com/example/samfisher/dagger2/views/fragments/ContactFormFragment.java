package com.example.samfisher.dagger2.views.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.samfisher.dagger2.data.entity.Contact;
import com.example.samfisher.dagger2.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactFormFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactFormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFormFragment extends Fragment implements HasSupportFragmentInjector{
    public static final String TAG = "ContactFormFragment";

    @Inject
    DispatchingAndroidInjector<Fragment> androidInjector;

    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.editText2)
    EditText editText2;

    @BindView(R.id.editText3)
    EditText editText3;

    @Inject
    Context context;

    private OnFragmentInteractionListener mListener;
    private Unbinder unbinder;

    @OnClick(R.id.button)
    public void postContact(Button button) {
        Contact contact = new Contact();
        contact.setEmail(editText.getText().toString());
    }

    public ContactFormFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ContactFormFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFormFragment newInstance(int position) {
        ContactFormFragment fragment = new ContactFormFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact_form, container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return androidInjector;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

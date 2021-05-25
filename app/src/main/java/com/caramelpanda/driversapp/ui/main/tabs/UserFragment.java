package com.caramelpanda.driversapp.ui.main.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.caramelpanda.driversapp.R;
import com.caramelpanda.driversapp.data.Account;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class UserFragment extends Fragment {

    TextView firstNameTextView;
    TextView secondNameTextView;
    TextView workingAtTextView;
    TextView statusTextView;

    Account account;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        account = (Account) getArguments().getSerializable("user");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getView() == null)
            return;


        firstNameTextView = getView().findViewById(R.id.firstNameTW);
        secondNameTextView = getView().findViewById(R.id.secondNameTW);
        workingAtTextView = getView().findViewById(R.id.WorkingAtTW);
        statusTextView = getView().findViewById(R.id.statusTW);


        final String status = "STATUS: " + (account.getDriver().isDisponibil() ? "ON DELIVERY" : "WAITING");
        final String workingAt = "Working at: " + account.getInstitution().getName();

        workingAtTextView.setText(workingAt);
        statusTextView.setText(status);

//        workingAtTextView.setText(account.getInstitution().getName());
//        statusTextView.setText(account.getDriver().isDisponibil() ? "WAITING" : "DELIVERING");
    }
}
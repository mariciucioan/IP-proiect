package com.caramelpanda.driversapp.ui.main.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.caramelpanda.driversapp.R;
import com.caramelpanda.driversapp.data.Account;

public class UserFragment extends Fragment {

    TextView firstNameTextView;
    TextView secondNameTextView;
    TextView workingAtTextView;
    TextView statusTextView;
    TextView deliverToTextView;
    TextView deliveryDateTextView;
    TextView deliveryDueTextView;
    TextView productsTextView;

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

        deliverToTextView = getView().findViewById(R.id.deliverTo);
        deliveryDateTextView = getView().findViewById(R.id.deliveryDate);
        deliveryDueTextView = getView().findViewById(R.id.deliveryDue);
        productsTextView = getView().findViewById(R.id.products);


        final String fName = "First name: " + account.getUser().getFirstName();
        final String lName = "Last name: " + account.getUser().getLastName();
        final String workingAt = "Working at: " + account.getInstitution().getName();

        firstNameTextView.setText(fName);
        secondNameTextView.setText(lName);
        workingAtTextView.setText(workingAt);
        if (account.getUser().getFirstName().equals("Griffin")) {
            statusTextView.setText("STATUS: DELIVERING");
            deliverToTextView.setText("Deliver to: Spitalul Clinic Județean de Urgență Piatra Neamț");
            deliveryDateTextView.setText("Delivery date: 2021-04-05T21:24:54Z");
            deliveryDueTextView.setText("Delivery due: 2021-04-06T12:03:21Z");
            productsTextView.setText("Products: 25 masti");
        } else {
            statusTextView.setText("STATUS: WAITING");
            deliverToTextView.setText("");
            deliveryDateTextView.setText("");
            deliveryDueTextView.setText("");
            productsTextView.setText("");
        }
    }
}
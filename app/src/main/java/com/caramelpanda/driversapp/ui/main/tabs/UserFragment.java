package com.caramelpanda.driversapp.ui.main.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.caramelpanda.driversapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class UserFragment extends Fragment {

    TextView firstNameTextView;
    TextView secondNameTextView;
    TextView workingAtTextView;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getView() == null)
            return;

        FloatingActionButton fabSupport = getView().findViewById(R.id.fabSupport);
        FloatingActionButton fabRefill = getView().findViewById(R.id.fabRefill);

        firstNameTextView = getView().findViewById(R.id.firstNameTW);
        secondNameTextView = getView().findViewById(R.id.secondNameTW);
        workingAtTextView = getView().findViewById(R.id.WorkingAtTW);

        fabSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "TO-DO: REAL-TIME SUPPORT CHAT HERE", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fabRefill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "TO-DO: REFILL RECEIPTS SAVE AND UPLOAD TO CLOUD", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
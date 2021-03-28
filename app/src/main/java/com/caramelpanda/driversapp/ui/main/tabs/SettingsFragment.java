package com.caramelpanda.driversapp.ui.main.tabs;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.caramelpanda.driversapp.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}
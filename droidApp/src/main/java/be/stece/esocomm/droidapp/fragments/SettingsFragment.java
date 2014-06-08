package be.stece.esocomm.droidapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.stece.esocomm.droidapp.activities.R;

/**
 * Created by Stece on 8/06/2014.
 */
public class SettingsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_screen, container, false);
        return view;
    }
}

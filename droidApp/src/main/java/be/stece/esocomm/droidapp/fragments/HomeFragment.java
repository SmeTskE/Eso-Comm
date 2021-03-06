package be.stece.esocomm.droidapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import be.stece.esocomm.droidapp.activities.BuildConfig;
import be.stece.esocomm.droidapp.activities.R;
import be.stece.esocomm.droidapp.managers.SettingsManager;

/**
 * Created by Stece on 8/06/2014.
 */
public class HomeFragment extends Fragment {


    private TextView mWelcomeTextView;
    private Button mAdminButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_screen, container, false);
        mWelcomeTextView = (TextView) view.findViewById(R.id.hs_welcome);
        mWelcomeTextView.setText(getString(R.string.hs_welcome, SettingsManager.usernameFromSettings(getActivity())));

        mAdminButton = (Button) view.findViewById(R.id.hs_admin_button);

        enableAdmin();

        return view;
    }

    private void enableAdmin(){
        if(BuildConfig.FLAVOR.equals("admin")) { mAdminButton.setVisibility(View.VISIBLE);}
    }
}

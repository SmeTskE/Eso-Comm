package be.stece.esocomm.droidapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import be.stece.esocomm.droidapp.activities.R;
import be.stece.esocomm.droidapp.managers.SettingsManager;
import be.stece.esocomm.droidapp.models.EsoServerEnum;

/**
 * Created by Stece on 7/06/2014.
 */
public class UserSetupFragment extends Fragment implements View.OnClickListener {

    private EditText mUsernameEditText;
    private Spinner mEsoServerSpinner;
    private Button mSaveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setup_screen, container, false);

        mUsernameEditText = (EditText) view.findViewById(R.id.us_username_edittext);

        mEsoServerSpinner = (Spinner) view.findViewById(R.id.us_server_spinner);
        mEsoServerSpinner.setAdapter(new ArrayAdapter<EsoServerEnum>(view.getContext(), android.R.layout.simple_spinner_item, EsoServerEnum.values()));

        mSaveButton = (Button) view.findViewById(R.id.us_save_button);
        mSaveButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.us_save_button:
                saveUserSettings();
        }
    }

    private void saveUserSettings(){
        SettingsManager.storeEsoServerSetting(getActivity(), (EsoServerEnum) mEsoServerSpinner.getSelectedItem()); // => Possible not the correct way
        SettingsManager.storeUsernameSetting(getActivity(), mUsernameEditText.getText().toString());
    }
}

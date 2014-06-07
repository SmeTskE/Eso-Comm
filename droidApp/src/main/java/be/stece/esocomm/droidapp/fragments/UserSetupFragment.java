package be.stece.esocomm.droidapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
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
        return inflater.inflate(R.layout.settings_screen, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUsernameEditText = (EditText) getActivity().findViewById(R.id.us_username_edittext);
        mEsoServerSpinner = (Spinner) getActivity().findViewById(R.id.us_server_spinner);
        mSaveButton = (Button) getActivity().findViewById(R.id.us_save_button);

        mEsoServerSpinner.setAdapter(new ArrayAdapter<EsoServerEnum>(getActivity(), android.R.layout.simple_spinner_item, EsoServerEnum.values()));
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

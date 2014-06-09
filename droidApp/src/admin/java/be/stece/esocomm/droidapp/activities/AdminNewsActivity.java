package be.stece.esocomm.droidapp.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import be.stece.esocomm.droidapp.fragments.UserSetupFragment;

/**
 * Created by Stece on 9/06/2014.
 */
public class AdminNewsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setup); // TODO: user actual admin screen.
        Fragment fragment = new UserSetupFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_container, fragment).commit();
    }
}

package be.stece.esocomm.droidapp.fragments;

import android.app.Fragment;
import android.util.Log;
import android.widget.Button;

/**
 * Created by Stece on 9/06/2014.
 */
public class HomeFragmentSuper extends Fragment {

    protected Button adminButton;

    protected void enableAdmin(){
        Log.d("NOPE", "NOPE YOU ARE NOT ADMIN");
    }

}

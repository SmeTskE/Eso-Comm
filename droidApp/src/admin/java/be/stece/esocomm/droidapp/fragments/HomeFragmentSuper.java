package be.stece.esocomm.droidapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import be.stece.esocomm.droidapp.activities.AdminNewsActivity;
import be.stece.esocomm.droidapp.activities.R;

/**
 * Created by Stece on 9/06/2014.
 */
public class HomeFragmentSuper extends Fragment implements View.OnClickListener {

    protected Button adminButton;

    protected void enableAdmin(){
       adminButton.setVisibility(View.VISIBLE);
       adminButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hs_admin_button:
                Intent intent = new Intent(getActivity(), AdminNewsActivity.class);
                startActivity(intent);
                break;
        }
    }
}

package be.stece.esocomm.droidapp.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import be.stece.esocomm.droidapp.fragments.NewsAddEditFragment;

/**
 * Created by Stece on 14/06/2014.
 */
public class AdminNewsItemActivity extends Activity {

    public static final String PARAM_EDIT_ITEM = "EDIT_NEW_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_framecontainer);
        Fragment fragment = new NewsAddEditFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_container, fragment).commit();

        // Check if we need to add or edit a news item
        Intent intent = getIntent();
        if (intent.hasExtra(PARAM_EDIT_ITEM)){
            // todo: fetch the news item we need to edit
        }
    }
}

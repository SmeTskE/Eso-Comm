package be.stece.esocomm.droidapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import be.stece.esocomm.droidapp.activities.R;
import be.stece.esocomm.droidapp.managers.SettingsManager;
import be.stece.esocomm.droidapp.models.EsoServerEnum;

/**
 * Created by Stece on 7/06/2014.
 */
public class NewsAddEditFragment extends Fragment implements View.OnClickListener {


    private Button mSaveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_add_edit_screen, container, false);

        mSaveButton = (Button) view.findViewById(R.id.aen_save_button);
        mSaveButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aen_save_button:
                saveNewsItem();
                break;
            default:
                break;
        }
    }

    private void saveNewsItem(){
        // todo: finish function
    }
}

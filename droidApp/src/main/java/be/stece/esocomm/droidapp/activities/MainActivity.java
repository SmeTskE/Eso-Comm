package be.stece.esocomm.droidapp.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import be.stece.esocomm.droidapp.fragments.HomeFragment;
import be.stece.esocomm.droidapp.fragments.PublishGuildFragment;
import be.stece.esocomm.droidapp.fragments.SearchGuildsFragment;
import be.stece.esocomm.droidapp.fragments.SettingsFragment;
import be.stece.esocomm.droidapp.managers.SettingsManager;
import be.stece.esocomm.droidapp.models.DrawerMenuEnum;

/**
 * Created by Stece on 7/06/2014.
 */
public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private static final int REQUEST_USERSETUP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.slider_list);

        ArrayAdapter<DrawerMenuEnum> adapter = new ArrayAdapter<DrawerMenuEnum>(this,
                android.R.layout.simple_list_item_1, DrawerMenuEnum.values());
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(this);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.app_name,R.string.app_name) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(R.string.app_name);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(R.string.app_name);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            updateDisplay(DrawerMenuEnum.HOME_SCREEN);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (SettingsManager.usernameFromSettings(this).isEmpty()){
            Intent intent = new Intent(this, UserSetupActivity.class);
            startActivityForResult(intent, REQUEST_USERSETUP);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_USERSETUP && resultCode == Activity.RESULT_OK){
            updateDisplay(DrawerMenuEnum.HOME_SCREEN);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DrawerMenuEnum selectedFromList =(DrawerMenuEnum) (mDrawerList.getItemAtPosition(position));
        updateDisplay(selectedFromList);
    }

    /**
     * Method to show a specific Fragment
     * @Author: Stece
     * @Date: 8/06/2014
     * @param screen
     */
    private void updateDisplay(DrawerMenuEnum screen){
        Fragment fragment = null;
        switch (screen){
            case HOME_SCREEN:
                fragment = new HomeFragment();
                break;
            case PUBLISH_GUILD_SCREEN:
                fragment = new PublishGuildFragment();
                break;
            case SEARCH_GUILDS_SCREEN:
                fragment = new SearchGuildsFragment();
                break;
            case SETTINGS_SCREEN:
                fragment = new SettingsFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
            // update selected item and title, then close the drawer
            setTitle(screen.toString());
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }else{
            return false;
        }
    }

    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}

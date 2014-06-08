package be.stece.esocomm.droidapp.managers;

import android.content.Context;
import android.content.SharedPreferences;

import be.stece.esocomm.droidapp.models.EsoServerEnum;

/**
 * Created by Stece on 7/06/2014.
 */
public class SettingsManager {

    private static final String PREF_FILE = "ESO_COMM_PREFERENCES";
    private static final String KEY_USERNAME = "ESO_USERNAME";
    private static final String KEY_ESO_SERVER = "ESO_SERVER";

    public static String usernameFromSettings (Context context){
        SharedPreferences prefs = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        return prefs.getString(KEY_USERNAME, "");
    }

    public static void storeUsernameSetting(Context context, String username){
        SharedPreferences prefs = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        prefs.edit().putString(KEY_USERNAME, username).commit();
    }

    public static EsoServerEnum esoServerFromSettings (Context context){
        SharedPreferences prefs = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        return EsoServerEnum.valueOf(prefs.getString(KEY_ESO_SERVER, EsoServerEnum.AMERICAN.name()));
    }

    public static void storeEsoServerSetting(Context context, EsoServerEnum esoServer){
        SharedPreferences prefs = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        prefs.edit().putString(KEY_ESO_SERVER, esoServer.name()).commit();
    }
}

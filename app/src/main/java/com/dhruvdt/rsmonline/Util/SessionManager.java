package com.dhruvdt.rsmonline.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class SessionManager {
    private static final String PREF_NAME = "marketingApp";
    private static final String KEY_SELECT_LANGUAGE = "language";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private SharedPreferences pref;
    private Editor editor;
    private Context _context;
    private int PRIVATE_MODE = 0;

    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);

    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public void setUserLanguage(String userLanguage) {
        editor.putString(KEY_SELECT_LANGUAGE, userLanguage);
        editor.commit();
    }

    public String getUserLanguage(){
        return pref.getString(KEY_SELECT_LANGUAGE, " ");
    }

}
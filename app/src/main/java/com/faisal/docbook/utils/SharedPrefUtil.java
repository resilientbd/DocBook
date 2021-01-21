/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       : faisal.hossain.pk@gmail.com
 * Created Date	  : 1/19/21 9:38 PM
 * Last edited by :  imac
 * Edited time    : 1/19/21 9:36 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */
package com.faisal.docbook.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil {
    public static final String DEFAULT_NAME = "note_pref";

    public static void ADD_STRING_PREFERENCE(Context context, String name, String value) {

        SharedPreferences pref = context.getSharedPreferences(DEFAULT_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(name, value);
        editor.commit();
    }
    public static void ADD_BOOLEAN_PREFERENCE(Context context, String name, boolean value) {

        SharedPreferences pref = context.getSharedPreferences(DEFAULT_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(name, value);
        editor.commit();
    }

    public static void ADD_INTEGER_PREFERENCE(Context context, String name, int value) {

        SharedPreferences pref = context.getSharedPreferences(DEFAULT_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(name, value);
        editor.commit();
    }

    public static void CLEAR_PREFERENCE(Context context) {

        SharedPreferences pref = context.getSharedPreferences(DEFAULT_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

    public static String GET_STRING_PREFERENCE(Context context, String name) {
        SharedPreferences pref = context.getSharedPreferences(DEFAULT_NAME, Context.MODE_PRIVATE);
        String value = pref.getString(name, "");
        return value;
    }
    public static boolean GET_BOOLEAN_PREFERENCE(Context context, String name) {
        SharedPreferences pref = context.getSharedPreferences(DEFAULT_NAME, Context.MODE_PRIVATE);
        boolean value = pref.getBoolean(name,false);
        return value;
    }
    public static int GET_INTEGER_PREFERENCE(Context context, String name) {
        SharedPreferences pref = context.getSharedPreferences(DEFAULT_NAME, Context.MODE_PRIVATE);
        int value = pref.getInt(name,-1);
        return value;
    }

}

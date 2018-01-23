package com.example.eduardoalejandro.encuesta;

import android.content.SharedPreferences;

/**
 * Created by Saul on 23/01/2018.
 */

public class MetodosSharedPreference {
    public static String getSociedadPref(SharedPreferences prs){
        return prs.getString("sociedad",null);
    }
    public static String getSucursalPref(SharedPreferences prs){
        return prs.getString("sucursal",null);
    }
}

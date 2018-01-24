package com.example.eduardoalejandro.encuesta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences prs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        Intent intentLogin = new Intent(SplashActivity.this, LoginActivity.class);
        Intent intentFactura = new Intent(SplashActivity.this, Inicio.class);

        if (!TextUtils.isEmpty(MetodosSharedPreference.getSociedadPref(prs))
                && !TextUtils.isEmpty(MetodosSharedPreference.getSociedadPref(prs))){
            startActivity(intentFactura);
        }else{
            startActivity(intentLogin);
        }
        finish();
    }
}

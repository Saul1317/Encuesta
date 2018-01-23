package com.example.eduardoalejandro.encuesta;

import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Saul on 23/01/2018.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
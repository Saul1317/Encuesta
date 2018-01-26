package com.example.eduardoalejandro.encuesta.encuesta;

import android.app.Application;
import android.os.SystemClock;

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
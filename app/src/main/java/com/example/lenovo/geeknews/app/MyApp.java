package com.example.lenovo.geeknews.app;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    public static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static Context getInstance() {
        return app;
    }
}

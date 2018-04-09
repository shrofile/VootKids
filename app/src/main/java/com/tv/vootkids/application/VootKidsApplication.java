package com.tv.vootkids.application;


import android.app.Application;

public class VootKidsApplication extends Application{

    private static VootKidsApplication sInstance;

    public static VootKidsApplication getsInstance() {
        return sInstance;
    }


}

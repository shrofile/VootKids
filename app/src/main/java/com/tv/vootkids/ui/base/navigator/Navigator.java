package com.tv.vootkids.ui.base.navigator;


import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

public interface Navigator {

    void replaceFragment(@IdRes int containerId, @NonNull Fragment fragment);

}

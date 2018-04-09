package com.tv.vootkids.ui.base.navigator;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class ActivityNavigator implements Navigator{

    protected final FragmentActivity activity;

    public ActivityNavigator(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void replaceFragment(int containerId, @NonNull Fragment fragment) {
        replaceFragmentInternal(activity.getSupportFragmentManager(), containerId, fragment, null, null, false, null);
    }


    protected final void replaceFragmentInternal(FragmentManager fm, @IdRes int containerId, Fragment fragment, String fragmentTag, Bundle args, boolean addToBackstack, String backstackTag) {
        if (activity.isFinishing()) return;

        if (args != null) {
            fragment.setArguments(args);
        }
        FragmentTransaction ft = fm.beginTransaction().replace(containerId, fragment, fragmentTag);
        if (addToBackstack) {
            ft.addToBackStack(backstackTag).commitAllowingStateLoss();
            fm.executePendingTransactions();
        } else {
            ft.commitAllowingStateLoss();
        }
    }
}

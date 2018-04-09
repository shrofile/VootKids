package com.tv.vootkids.injection.module;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.tv.vootkids.injection.scope.RequestScope;
import com.tv.vootkids.ui.base.navigator.ActivityNavigator;
import com.tv.vootkids.ui.base.navigator.Navigator;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    @RequestScope
    Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @RequestScope
    FragmentManager provideFragmentManager() {
        return mActivity.getSupportFragmentManager();
    }

    @Provides
    @RequestScope
    Navigator provideNavigator() {
        return new ActivityNavigator(mActivity);
    }

}

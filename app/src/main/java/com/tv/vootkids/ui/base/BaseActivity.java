package com.tv.vootkids.ui.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tv.vootkids.injection.component.DaggerNavigatorComponent;
import com.tv.vootkids.injection.component.NavigatorComponent;
import com.tv.vootkids.injection.module.ActivityModule;
import com.tv.vootkids.ui.base.navigator.Navigator;
import com.tv.vootkids.ui.common.widget.VootKidsToolBar;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity{
    abstract protected int getLayoutId();

    public abstract int getChildContainerId();

    public abstract int getHomeContainerId();

    abstract protected void initViews();

    public abstract void showProgressBar();

    public abstract void hideProgressBar();

    public abstract int getRootView();

    protected abstract VootKidsToolBar getToolBar();

    @Inject
    Navigator mAppNavigator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        initViews();

        initDagger();
    }

    private void initDagger() {
        NavigatorComponent mNavigatorComponent = DaggerNavigatorComponent.builder()
                .activityModule(new ActivityModule(this))
                .build();
        mNavigatorComponent.inject(this);
    }

    /**
     * Set ActionBar for the base layout
     */
    protected void setupActionBar() {
        if (getToolBar() != null) {
            setSupportActionBar(getToolBar());
            if (getSupportActionBar() != null) {
                getSupportActionBar().setHomeButtonEnabled(true);
            }
        }
    }

}

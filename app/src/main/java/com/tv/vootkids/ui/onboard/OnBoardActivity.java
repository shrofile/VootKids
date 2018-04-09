package com.tv.vootkids.ui.onboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.tv.vootkids.R;
import com.tv.vootkids.ui.base.BaseActivity;
import com.tv.vootkids.ui.common.widget.VootKidsToolBar;
import com.tv.vootkids.ui.home.HomeActivity;

import butterknife.BindView;

public class OnBoardActivity extends BaseActivity {

    @BindView(R.id.on_board_progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.onboard_toolbar)
    VootKidsToolBar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_onboard;
    }

    @Override
    public int getChildContainerId() {
        return -1;
    }

    @Override
    public int getHomeContainerId() {
        return R.id.onBoard_container;
    }

    @Override
    protected void initViews() {
        setupActionBar();

        launchHomeScreen();
    }

    private void launchHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public int getRootView() {
        return R.id.root;
    }

    @Override
    protected VootKidsToolBar getToolBar() {
        return mToolbar;
    }


}

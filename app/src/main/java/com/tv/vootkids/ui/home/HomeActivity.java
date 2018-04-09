package com.tv.vootkids.ui.home;


import android.view.View;
import android.widget.ProgressBar;

import com.tv.vootkids.R;
import com.tv.vootkids.ui.base.BaseActivity;
import com.tv.vootkids.ui.common.widget.VootKidsToolBar;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.on_board_progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.onboard_toolbar)
    VootKidsToolBar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
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

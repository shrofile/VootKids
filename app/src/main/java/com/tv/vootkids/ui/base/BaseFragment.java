package com.tv.vootkids.ui.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    protected static final String TAG = BaseFragment.class.getSimpleName();

    private Unbinder mUnBinder;

    abstract protected int getFragmentLayoutId();

    protected abstract void initViews(View view);

    protected abstract void initDagger();


    public String getScreenName() {
        return "";
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayoutId(), container, false);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initDagger();

        View view = inflateView(inflater, container, savedInstanceState);

        setRetainInstance(true);

        mUnBinder = ButterKnife.bind(this, view);

        getBundleData();

        initViews(view);

        return view;
    }

    protected void getBundleData() {

    }

    @Override
    public void onDestroyView() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
            mUnBinder = null;
        }
        super.onDestroyView();
    }

    protected void showProgressBar() {
        ((BaseActivity) getActivity()).showProgressBar();
    }

    protected void hideProgressBar() {
        ((BaseActivity) getActivity()).hideProgressBar();
    }

}

package com.tv.vootkids.ui.base;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tv.vootkids.data.model.UiHelper;
import com.tv.vootkids.utils.constants.ApiConstants;

public abstract class BaseViewModelFragment extends BaseFragment {

    public abstract BaseViewModel getViewModel();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        observeLiveData();
    }

    private void observeLiveData() {
        BaseViewModel viewModel = getViewModel();
        viewModel.getUiLiveData().observe(this, new Observer<UiHelper>() {
            @Override
            public void onChanged(@Nullable UiHelper uiHelper) {
                if (uiHelper.isMbShowProgress())
                    showProgressBar();
                else
                    hideProgressBar();

                if (uiHelper.getError() != null && uiHelper.getError().getCode() != ApiConstants.CODE_SUCCESS &&
                        uiHelper.getError().getCode() != 0) {
                }
            }
        });
    }

}

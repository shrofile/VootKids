package com.tv.vootkids.ui.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.tv.vootkids.data.model.UiHelper;
import com.tv.vootkids.data.remote.Error;

public class BaseViewModel extends AndroidViewModel {

    MutableLiveData<UiHelper> mUiLiveData = new MutableLiveData<>();


    public MutableLiveData<UiHelper> getUiLiveData() {
        return mUiLiveData;
    }

    public BaseViewModel(Application application) {
        super(application);
    }

    /**
     * shows progress bar
     */
    protected void showProgress() {
        mUiLiveData.setValue(new UiHelper.UiHelperBuilder().showProgress(true).build());
    }

    /**
     * hides progress bar
     */
    protected void hideProgress() {
        mUiLiveData.setValue(new UiHelper.UiHelperBuilder().showProgress(false).build());
    }

    /**
     * Sets Error code
     *
     * @param code
     */
    protected void setErrorCode(Error code) {
        UiHelper helper = new UiHelper.UiHelperBuilder().setError(code).build();
        mUiLiveData.setValue(helper);
    }

}

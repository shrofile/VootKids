package com.tv.vootkids.data.model;

import com.tv.vootkids.data.remote.Error;

public class UiHelper extends BaseModel {
    boolean mbShowProgress = false;
    Error error;

    public boolean isMbShowProgress() {
        return mbShowProgress;
    }

    public Error getError() {
        return error;
    }

    UiHelper(UiHelperBuilder builder) {
        mbShowProgress = builder.mbShowProgress;
        this.error = builder.error;
    }

    public static class UiHelperBuilder {
        boolean mbShowProgress;
        Error error;
        boolean mbShowEmptyView;

        public UiHelperBuilder showProgress(boolean show) {
            mbShowProgress = show;
            return this;
        }

        public UiHelperBuilder setMbShowProgress(boolean mbShowProgress) {
            this.mbShowProgress = mbShowProgress;
            return this;
        }

        public UiHelperBuilder setError(Error error) {
            this.error = error;
            return this;
        }

        public UiHelperBuilder setMbShowEmptyView(boolean mbShowEmptyView) {
            this.mbShowEmptyView = mbShowEmptyView;
            return this;
        }

        public UiHelper build() {
            return new UiHelper(this);
        }

    }
}

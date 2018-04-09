package com.tv.vootkids.injection.module;

import com.tv.vootkids.injection.scope.ApplicationScope;
import com.tv.vootkids.ui.base.rxbus.RxBus;
import com.tv.vootkids.ui.base.rxbus.RxBusImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RxBusModule {
    @ApplicationScope
    @Provides
    public RxBus provideRxBus() {
        return new RxBusImpl();
    }
}

package com.tv.vootkids.injection.component;

import com.tv.vootkids.injection.module.ActivityModule;
import com.tv.vootkids.injection.scope.RequestScope;
import com.tv.vootkids.ui.base.BaseActivity;

import dagger.Component;

@RequestScope
@Component(modules = {ActivityModule.class})
public interface NavigatorComponent {

    void inject(BaseActivity appNavigator);
}

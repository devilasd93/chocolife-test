package com.diss.chocolife_test.dagger.modules.components;

import com.diss.chocolife_test.dagger.modules.AppModule;
import com.diss.chocolife_test.dagger.modules.NetModule;
import com.diss.chocolife_test.mvc.controllers.activities.ActDiscountDescription;
import com.diss.chocolife_test.mvc.controllers.activities.ActMainScreen;
import com.diss.chocolife_test.mvc.controllers.fragments.FRdiscountsList;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dmitry on 20.09.16.
 */


@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    void inject(ActMainScreen actMainScreen);
    void inject(FRdiscountsList fRdiscountsList);
    void inject(ActDiscountDescription actDiscountDescription);

}

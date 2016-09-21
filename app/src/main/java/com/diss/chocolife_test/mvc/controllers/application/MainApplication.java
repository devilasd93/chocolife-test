package com.diss.chocolife_test.mvc.controllers.application;

import android.app.Application;

import com.diss.chocolife_test.dagger.modules.AppModule;
import com.diss.chocolife_test.dagger.modules.NetModule;
import com.diss.chocolife_test.dagger.modules.components.DaggerNetComponent;
import com.diss.chocolife_test.dagger.modules.components.NetComponent;
import com.diss.chocolife_test.mvc.support.Zvars;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by dmitry on 19.09.16.
 */

/**
 *Main application class
 * Use for init Dagger, Realm and another actions
*/

public class MainApplication extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .netModule(new NetModule(Zvars.M_BASE_URL))
                .appModule(new AppModule(this))
                .build();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this)
                .schemaVersion(Zvars.REALM_CURRENT_VERSION)
                .migration((realm, oldVersion, newVersion) -> {

                })
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    public NetComponent getmNetComponent() {
        return mNetComponent;
    }
}

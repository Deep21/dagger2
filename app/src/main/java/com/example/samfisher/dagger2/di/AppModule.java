package com.example.samfisher.dagger2.di;

import android.content.Context;

import com.example.samfisher.dagger2.App;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.Cache;

/**
 * Created by Samfisher on 04/09/2017.
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(App app) {
        return app;
    }


}

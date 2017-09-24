package com.example.samfisher.dagger2.di;

import android.content.Context;

import com.example.samfisher.dagger2.App;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Samfisher on 04/09/2017.
 */
@Module
abstract class AppModule {
    @Singleton
    @Binds
    abstract Context bindApp(App app);

}

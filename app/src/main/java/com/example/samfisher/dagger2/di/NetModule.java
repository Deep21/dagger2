package com.example.samfisher.dagger2.di;

import com.example.samfisher.dagger2.App;
import com.example.samfisher.dagger2.InvoiceApi;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Samfisher on 11/09/2017.
 */
@Module
public class NetModule {
    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Singleton
    @Provides
    Cache provideHttpCache(App application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }


    @Singleton
    @Provides
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return client.addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(logging)
                .cache(cache)
                .build();
    }

    @Singleton

    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://192.168.1.15/api/web/app_dev.php/api/v1/")
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    InvoiceApi provideMyService(Retrofit retrofit) {
        return retrofit.create(InvoiceApi.class);
    }
}

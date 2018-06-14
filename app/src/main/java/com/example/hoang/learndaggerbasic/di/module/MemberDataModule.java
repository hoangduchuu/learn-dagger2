package com.example.hoang.learndaggerbasic.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.hoang.learndaggerbasic.data.offline.MemberDataManager;
import com.example.hoang.learndaggerbasic.data.online.NetWorkManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hoang on 27/05/2018 nhe.
 */
@Module
public class MemberDataModule {
    Context context;

    public MemberDataModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return this.context;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this.context);
    }


    @Singleton
    @Provides
    NetWorkManager provideNetWorkManager() {
        return new NetWorkManager();
    }

    @Singleton
    @Named("local")
    @Provides
    MemberDataManager provideMemberDataManagerOffline(SharedPreferences sharedPreferences) {
        return new MemberDataManager(sharedPreferences);
    }

    @Singleton
    @Named("online")
    @Provides
    MemberDataManager provideMemberDataManagerOnline(SharedPreferences sharedPreferences, NetWorkManager netWorkManager) {
        return new MemberDataManager(sharedPreferences, netWorkManager);
    }
}

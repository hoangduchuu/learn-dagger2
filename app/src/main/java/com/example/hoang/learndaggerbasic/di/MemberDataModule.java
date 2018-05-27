package com.example.hoang.learndaggerbasic.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import com.example.hoang.learndaggerbasic.data.MemberDataManager;

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
    public Context provideContext(){
        return this.context;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(this.context);
    }

    @Singleton
    @Provides
    MemberDataManager provideMemberDataManager(SharedPreferences sharedPreferences) {
        return new MemberDataManager(sharedPreferences);
    }
}

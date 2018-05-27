package com.example.hoang.learndaggerbasic.di;

import com.example.hoang.learndaggerbasic.data.MemberDataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hoang on 27/05/2018 nhe.
 */
@Module
public class MemberDataModule {
    @Singleton
    @Provides
    MemberDataManager provideMemberDataManager() {
        return new MemberDataManager();
    }
}

package com.example.hoang.learndaggerbasic.di.module;

import com.example.hoang.learndaggerbasic.di.scope.WelComeScope;
import com.example.hoang.learndaggerbasic.models.MessageGenerator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hoang on 30/05/2018 nhe.
 */

@Module
public class MessageModule {
    @WelComeScope
    @Provides
    public MessageGenerator provideMessageGenerator() {

        return new MessageGenerator();
    }
}

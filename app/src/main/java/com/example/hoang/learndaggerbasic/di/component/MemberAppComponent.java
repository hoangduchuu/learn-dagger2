package com.example.hoang.learndaggerbasic.di.component;

import android.os.Message;

import com.example.hoang.learndaggerbasic.checkmember.MainActivity;
import com.example.hoang.learndaggerbasic.di.module.DateTimeModule;
import com.example.hoang.learndaggerbasic.di.module.MemberDataModule;
import com.example.hoang.learndaggerbasic.di.module.MessageModule;
import com.example.hoang.learndaggerbasic.di.scope.MyActivityScope;
import com.example.hoang.learndaggerbasic.welcome.WelcomeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hoang on 27/05/2018 nhe.
 */

@MyActivityScope
@Singleton
@Component(modules = {MemberDataModule.class,
        DateTimeModule.class})
public interface MemberAppComponent {
    void inject(MainActivity mainActivity);

}

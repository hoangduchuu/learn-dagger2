package com.example.hoang.learndaggerbasic.di.component;

import com.example.hoang.learndaggerbasic.di.module.MessageModule;
import com.example.hoang.learndaggerbasic.di.scope.WelComeScope;
import com.example.hoang.learndaggerbasic.welcome.WelcomeActivity;

import dagger.Component;

/**
 * Created by hoang on 30/05/2018 nhe.
 */
@WelComeScope
@Component(dependencies = MemberAppComponent.class, modules = MessageModule.class)
public interface WelcomeComponent {
    void inject(WelcomeActivity welcomeActivity);

}

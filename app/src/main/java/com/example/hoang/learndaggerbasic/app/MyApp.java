package com.example.hoang.learndaggerbasic.app;

import android.app.Application;

import com.example.hoang.learndaggerbasic.di.component.DaggerMemberAppComponent;
import com.example.hoang.learndaggerbasic.di.component.DaggerWelcomeComponent;
import com.example.hoang.learndaggerbasic.di.component.WelcomeComponent;
import com.example.hoang.learndaggerbasic.di.module.DateTimeModule;
import com.example.hoang.learndaggerbasic.di.component.MemberAppComponent;
import com.example.hoang.learndaggerbasic.di.module.MemberDataModule;
import com.example.hoang.learndaggerbasic.di.module.MessageModule;

/**
 * Created by hoang on 27/05/2018 nhe.
 */
public class MyApp extends Application {
    private static MyApp app;
    private MemberAppComponent memberAppComponent;
    private WelcomeComponent welcomeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        memberAppComponent = DaggerMemberAppComponent
                .builder()
                .memberDataModule(new MemberDataModule(getApplicationContext()))
                .dateTimeModule(new DateTimeModule())
                .build();

        welcomeComponent = DaggerWelcomeComponent
                .builder()
                .memberAppComponent(memberAppComponent) // becau welcomeComponent dependent memberAppComponent
                .messageModule(new MessageModule())
                .build();

    }

    public static MyApp getApp() {
        return app;
    }

    public MemberAppComponent getMemberAppComponent() {
        return memberAppComponent;
    }

    public WelcomeComponent getWelcomeComponent() {
        return welcomeComponent;
    }
}

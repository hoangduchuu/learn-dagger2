package com.example.hoang.learndaggerbasic.app;

import android.app.Application;

import com.example.hoang.learndaggerbasic.di.component.DaggerMemberAppComponent;
import com.example.hoang.learndaggerbasic.di.module.DateTimeModule;
import com.example.hoang.learndaggerbasic.di.component.MemberAppComponent;
import com.example.hoang.learndaggerbasic.di.module.MemberDataModule;

/**
 * Created by hoang on 27/05/2018 nhe.
 */
public class MyApp extends Application {
    private static MyApp app;
    private MemberAppComponent memberAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        memberAppComponent = DaggerMemberAppComponent
                .builder()
                .memberDataModule(new MemberDataModule(getApplicationContext()))
                .dateTimeModule(new DateTimeModule())
                .build();

    }

    public static MyApp getApp() {
        return app;
    }

    public MemberAppComponent getMemberAppComponent() {
        return memberAppComponent;
    }


}

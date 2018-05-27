package com.example.hoang.learndaggerbasic.app;

import android.app.Application;

import com.example.hoang.learndaggerbasic.di.DaggerMemberAppComponent;
import com.example.hoang.learndaggerbasic.di.MemberAppComponent;
import com.example.hoang.learndaggerbasic.di.MemberDataModule;

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
                .build();
    }

    public static MyApp getApp() {
        return app;
    }

    public MemberAppComponent getMemberAppComponent() {
        return memberAppComponent;
    }

}

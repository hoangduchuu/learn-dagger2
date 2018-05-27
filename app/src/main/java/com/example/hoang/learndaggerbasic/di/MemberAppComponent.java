package com.example.hoang.learndaggerbasic.di;

import com.example.hoang.learndaggerbasic.checkmember.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hoang on 27/05/2018 nhe.
 */


@Singleton
@Component(modules = MemberDataModule.class)
public interface MemberAppComponent {
    void inject(MainActivity mainActivity);
}

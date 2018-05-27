package com.example.hoang.learndaggerbasic.di;

import com.example.hoang.learndaggerbasic.checkmember.MainActivity;
import com.example.hoang.learndaggerbasic.dayer.DayFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hoang on 27/05/2018 nhe.
 */
@Singleton
@Component(modules = DateChooserModule.class)
public interface DateChooserComponent {
    void inject(DayFragment mainActivity);
}

package com.example.hoang.learndaggerbasic.di;

import com.example.hoang.learndaggerbasic.dayer.DayChooser;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hoang on 27/05/2018 nhe.
 */
@Module
public class DateChooserModule {
    @Singleton
    @Provides
    DayChooser provideDayChooser() {
        return new DayChooser();
    }
}

package com.example.hoang.learndaggerbasic.di.module;

import android.annotation.SuppressLint;

import com.example.hoang.learndaggerbasic.di.scope.MyActivityScope;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hoang on 28/05/2018 nhe.
 */
@Module
public class DateTimeModule {
    @MyActivityScope
    @Provides
    Calendar provideCalendar() {
        return Calendar.getInstance();
    }

    @Singleton
    @Named("dd-mm-yyy")
    @Provides
    public String provideCalendarType1(Calendar calendar) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sf = new SimpleDateFormat("dd-mm-yyy");
        return sf.format(calendar.getTime());
    }

    @MyActivityScope
    @Named("mm-dd-yyy")
    @Provides
    public String provideCalendarType2(Calendar calendar) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sf = new SimpleDateFormat("dd-mm-yyy");
        return sf.format(calendar.getTime());
    }

    @MyActivityScope
    @Named("mm-dd-yyy: HH:mm:ss")
    @Provides
    public String provideCalendarType3(Calendar calendar) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sf = new SimpleDateFormat("mm-dd-yyy: HH:mm:ss");
        return sf.format(calendar.getTime());
    }
}

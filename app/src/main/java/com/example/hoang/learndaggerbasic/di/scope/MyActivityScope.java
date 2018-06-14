package com.example.hoang.learndaggerbasic.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by hoang on 28/05/2018 nhe.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MyActivityScope {

}

package com.example.baseapp.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GlobalNavigation

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HomeNavigation

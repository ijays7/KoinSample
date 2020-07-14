package com.ijays.koinsample.di

import com.ijays.koinsample.navigator.AppNavigator
import com.ijays.koinsample.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by ijays on 2020/7/14.
 */
@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}
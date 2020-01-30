package com.ijays.koinsample.di

import com.ijays.koinsample.MainContract
import com.ijays.koinsample.database.AppDatabase
import com.ijays.koinsample.model.Data
import com.ijays.koinsample.presenter.MainPresenter
import com.ijays.koinsample.view.MainActivity
import org.koin.dsl.module

/**
 * Created by ijays on 2020/1/29.
 */
val applicationModule = module(override = true) {
    scope<MainActivity> {
        scoped<MainContract.Presenter<Data>> { (v: MainContract.View) ->
            MainPresenter(view = v)
        }
    }

    single {
        AppDatabase.getInstance()
    }
}
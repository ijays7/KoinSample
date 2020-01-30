package com.ijays.koinsample.repository

import com.ijays.koinsample.database.AppDatabase
import com.ijays.koinsample.model.Data
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by ijays on 2020/1/29.
 */
object AppRepository : KoinComponent {
    /**
     * 使用默认方式初始化 database
     */
//    private val database: AppDatabase by lazy {
//        AppDatabase.getInstance()
//    }

    /**
     * 使用 Koin 进行注入
     */
    private val database: AppDatabase by inject()


    fun save2DB(data: Data, callback: (String) -> Unit) {
        Observable.just(data)
            .map {
                database.dataDao().insertData(data)
                data
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback("Save to DB success")
            }, {
                callback(it.message.toString())
            })
    }

    fun queryFromDB(): Observable<List<Data>> {
        return database.dataDao().queryDataFromDB()
    }


}
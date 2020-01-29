package com.ijays.koinsample.repository

import com.ijays.koinsample.database.AppDatabase
import com.ijays.koinsample.model.Data
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ijays on 2020/1/29.
 */
object AppRepository {


    fun save2DB(data: Data, callback: (String) -> Unit) {
        Observable.just(data)
            .map {
                AppDatabase.getInstance().dataDao().insertData(data)
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
        return AppDatabase.getInstance().dataDao().queryDataFromDB()
    }


}
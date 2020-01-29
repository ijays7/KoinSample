package com.ijays.koinsample.presenter

import android.util.Log
import com.ijays.koinsample.MainContract
import com.ijays.koinsample.model.Data
import com.ijays.koinsample.repository.AppRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ijays on 2020/1/28.
 */
class MainPresenter(private val view: MainContract.View) : MainContract.Presenter<Data> {

    override fun saveToDB(str: String) {
        AppRepository.save2DB(Data(id = null, str = str)) {
            Log.e("ijays", "saveDB result==>$it")
        }
    }

    override fun queryFromDB() {
        AppRepository.queryFromDB().flatMap {
            val dataList = arrayListOf<String>()
            it.forEach { data ->
                dataList.add(data.str)
            }

            Observable.fromArray(dataList)

        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.displayDBList(it)
            }, {
                view.queryDBError(it.message ?: "")
            })
    }
}
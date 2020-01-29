package com.ijays.koinsample

/**
 * Created by ijays on 2020/1/29.
 */
interface MainContract {

    interface View {
        /**
         * 显示存入 DB 中的数据
         */
        fun displayDBList(list: MutableList<String>)

        /**
         * 读取 DB 错误
         */
        fun queryDBError(str: String)

    }

    interface Presenter<T> {
        /**
         * 将 [str] 保存到DB
         */
        fun saveToDB(str: String)

        /**
         * 从 DB 中读取数据
         */
        fun queryFromDB()
    }
}
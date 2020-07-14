package com.ijays.koinsample.data

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by ijays on 2020/7/14.
 */
class LoggerLocalDataSource(private val logDao: LogDao) {
    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)

    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    fun addLog(msg: String) {
        executorService.execute {
            logDao.insertAll(Log(msg, System.currentTimeMillis()))
        }
    }

    fun getAllLogs(callback: (List<Log>) -> Unit) {
        executorService.execute {
            val logs = logDao.getAll()
            mainThreadHandler.post { callback(logs) }
        }
    }

    fun removeLogs(){
        executorService.execute {
            logDao.nukeTable()
        }
    }
}
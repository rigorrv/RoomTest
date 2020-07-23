package com.github.roomtest

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class WorkManager11(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    private val dataDatabase: DataDatabase?
    override fun doWork(): Result {
        val title = inputData.getString("title")
        val message = inputData.getString("message")
        val data = "Title: $title Message: $message"
        saveData(data)
        return Result.success()
    }

    private fun saveData(data: String) {
        Completable.fromAction {
            val workdata = WorkData11(data)
            dataDatabase!!.dataDAO()!!.insert(workdata)
        }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {}
                override fun onComplete() {}
                override fun onError(e: Throwable) {}
            })
    }

    init {
        dataDatabase = DataDatabase.getInstance(applicationContext)
    }
}
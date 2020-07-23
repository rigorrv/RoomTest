package com.github.roomtest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private var schedule: Button? = null
    var dataDatabase: DataDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        schedule = findViewById<View>(R.id.schedule) as Button
        dataDatabase = DataDatabase.getInstance(this)
        readData()
        schedule!!.setOnClickListener { startWork() }
    }

    private fun readData() {
        dataDatabase!!.dataDAO()?.getlimituserList()?.observe(this, object : Observer<List<WorkData11?>?> {

            override fun onChanged(data: List<WorkData11?>?) {
                for (i in data!!.indices) {
                }
            }
        })
    }

    private fun startWork() {
        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(WorkManager11::class.java)
                .setInputData(createInputData("Inducesmile", "Hello world, work completed on time"))
                .setInitialDelay(3, TimeUnit.SECONDS).build()
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
    }

    private fun createInputData(title: String, message: String): Data {
        return Data.Builder()
                .putString("title", title)
                .putString("message", message)
                .build()
    }
}
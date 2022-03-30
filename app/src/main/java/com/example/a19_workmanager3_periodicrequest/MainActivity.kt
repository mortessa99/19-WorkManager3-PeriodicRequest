package com.example.a19_workmanager3_periodicrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonClick.setOnClickListener { setPeriodicWorkRequest() }
    }

    private fun setPeriodicWorkRequest(){
        val periodicWorkRequest = PeriodicWorkRequest.Builder(
            DbBackupScheduler::class.java,
            15, // minimum 15
            TimeUnit.MINUTES
        ).build()

        WorkManager.getInstance(applicationContext).enqueue(periodicWorkRequest)
    }
}
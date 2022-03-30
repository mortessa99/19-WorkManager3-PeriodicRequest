package com.example.a19_workmanager3_periodicrequest

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class DbBackupScheduler(context: Context, workerParameters: WorkerParameters) :
    Worker(context,workerParameters){
    override fun doWork(): Result {
        return try {
            for (i in 1..5000){ Log.i("mylog","Shrink data # $i")}
            Result.success()
        } catch (e:Exception){
            Result.failure()
        }
    }
}
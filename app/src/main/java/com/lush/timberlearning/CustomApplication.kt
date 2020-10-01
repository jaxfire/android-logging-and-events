package com.lush.timberlearning

import android.app.Application
import com.lush.timberlearning.logging.CloudReportingTree
import com.lush.timberlearning.logging.FilterableMessageDebugTree
import timber.log.Timber

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(FilterableMessageDebugTree("mySearchFilter"))
        } else {
            Timber.plant(CloudReportingTree())
        }
    }
}
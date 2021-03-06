package com.lush.timberlearning.logging

import android.util.Log
import timber.log.Timber

class CloudReportingTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

        // Crashlytics automatically collects crash reports

        if (priority == Log.WARN || priority == Log.ERROR) {
            FakeCloudLoggingLibrary.log(message, t)
        }
    }
}
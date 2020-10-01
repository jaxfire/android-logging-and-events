package com.lush.timberlearning.logging

import com.google.firebase.crashlytics.FirebaseCrashlytics

class FakeCloudLoggingLibrary private constructor() {
    companion object {
        fun log(message: String?, throwable: Throwable?) {
            val finalMessage = "Message: $message, Throwable's Message: ${throwable?.message}"
            FirebaseCrashlytics.getInstance()
                .recordException(LoggingException(finalMessage))
        }
        private class LoggingException(message: String?) : Exception(message)
    }
}
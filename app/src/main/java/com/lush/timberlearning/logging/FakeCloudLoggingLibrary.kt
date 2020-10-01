package com.lush.timberlearning.logging

class FakeCloudLoggingLibrary private constructor() {
    companion object {
        fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
            // TODO
        }

        fun logWarning(t: Throwable?) {
            // TODO
        }

        fun logError(t: Throwable?) {
            // TODO
        }
    }
}
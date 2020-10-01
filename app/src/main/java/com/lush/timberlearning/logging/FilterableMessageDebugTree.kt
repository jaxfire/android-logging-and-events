package com.lush.timberlearning.logging

import timber.log.Timber

class FilterableMessageDebugTree(private val filterTerm: String): Timber.DebugTree() {

    override fun log(priority: Int, t: Throwable?, message: String?, vararg args: Any?) {
        val updatedMessage = "${getCallingMethodName()} $filterTerm: $message"
        getCallingMethodName()
        super.log(priority, t, updatedMessage, *args)
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        val updatedMessage = "${getCallingMethodName()} $filterTerm: $message"
        super.log(priority, tag, updatedMessage, t)
    }

    private fun getCallingMethodName(): String {
        val stackTraceElements = Thread.currentThread().stackTrace
        return if (stackTraceElements.size >= 8) {
            stackTraceElements[8].methodName
        } else {
            "Method-name-not-found"
        }
    }
}
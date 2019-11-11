package com.example.retrofitwithmvvm.rx_utils

interface RxAPICallback<P> {
    fun onSuccess(t: P)

    fun onFailed(throwable: Throwable)
}
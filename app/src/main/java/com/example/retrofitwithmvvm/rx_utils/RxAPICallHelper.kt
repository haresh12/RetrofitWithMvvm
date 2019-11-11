package com.example.retrofitwithmvvm.rx_utils

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.schedulers.Schedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer


object RxAPICallHelper {


    fun <T> call(observable: Observable<T>?, rxAPICallback: RxAPICallback<T>?): Disposable {
        requireNotNull(observable) { "Observable must not be null." }

        requireNotNull(rxAPICallback) { "Callback must not be null." }

        return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> rxAPICallback.onSuccess(t) }, { throwable ->
                if (throwable != null) {
                    rxAPICallback.onFailed(throwable)
                } else {
                    rxAPICallback.onFailed(Exception("Error: Something went wrong in api call."))
                }
            })

    }
}
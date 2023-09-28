package com.solo4.kinoapp.common.utils

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    if (!isDisposed) add(disposable)
}

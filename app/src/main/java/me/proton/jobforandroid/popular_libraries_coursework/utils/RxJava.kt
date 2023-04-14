package me.proton.jobforandroid.popular_libraries_coursework.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

fun <T : Any> Single<T>.doCompletableIf(
    predicate: Boolean,
    completableCreate: (data: T) -> Completable,
): Single<T> {
    return if (predicate) {
        this.flatMap { completableCreate(it).andThen(Single.just(it)) }
    } else this
}

fun <T : Any> Single<T>.subscribeByDefault(): Single<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun Disposable.disposebleBy(bag: CompositeDisposable) {
    bag.add(this)
}
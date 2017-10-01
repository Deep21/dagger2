package com.example.samfisher.dagger2.interactor;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Samfisher on 27/09/2017.
 */

public abstract class BaseInteractor<T, Params> {
    CompositeDisposable compositeDisposable;

    public BaseInteractor() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public abstract Observable<T> getObservable(Params params);

    public void excecute(DisposableObserver<T> tDisposableObserver, Params params) {
        Disposable disposable = getObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(tDisposableObserver);
        compositeDisposable.add(disposable);

    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}

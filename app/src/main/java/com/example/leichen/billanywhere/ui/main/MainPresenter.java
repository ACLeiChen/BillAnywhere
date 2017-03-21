package com.example.leichen.billanywhere.ui.main;

import com.example.leichen.billanywhere.R;
import com.example.leichen.billanywhere.data.DataManager;
import com.example.leichen.billanywhere.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lei Chen on 2017/3/12.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        getCompositeDisposable().add(getDataManager()
                .seedDatabaseBills()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if(!isViewAttached()) {
                            return;
                        }
                        getMvpView().onError(R.string.some_error);
                    }
                }));
    }
    @Override
    public void onPlusButtonClick() {

    }

    @Override
    public void onOldBillItemClick() {

    }

    @Override
    public void onViewInitialized() {

    }
}

package com.example.leichen.billanywhere;

import com.example.leichen.billanywhere.data.DataManager;
import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.ui.main.MainMvpPresenter;
import com.example.leichen.billanywhere.ui.main.MainMvpView;
import com.example.leichen.billanywhere.ui.main.MainPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.inOrder;
/**
 * Created by Lei Chen on 2017/7/9.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {
    //Given
    @Mock
    MainMvpView mMockMainMvpView;
    @Mock
    DataManager mMockDataManager;

    private MainMvpPresenter<MainMvpView> mMainPresenter;

    @BeforeClass
    public static void onlyOnce() throws Exception {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler((schedulerCallable) -> {return Schedulers.trampoline();});
    }

    @Before
    public void setUp(){
        mMainPresenter = new MainPresenter<>(mMockDataManager, new CompositeDisposable());
        mMainPresenter.onAttach(mMockMainMvpView);
    }

    //When


    //Then
    @Test
    public void testViewInitialization(){
        List<Bill> bills = new ArrayList<>();

        when(mMockDataManager.seedDatabaseBills()).thenReturn(Completable.complete());
        when(mMockDataManager.getAllBills()).thenReturn(Observable.just(bills));

        mMainPresenter.onViewInitialized();

        InOrder inOrder = inOrder(mMockDataManager, mMockMainMvpView);
        inOrder.verify(mMockDataManager).seedDatabaseBills();
        inOrder.verify(mMockDataManager).getAllBills();
        inOrder.verify(mMockMainMvpView).refreshBills(bills);
    }



    @After
    public void tearDown() throws Exception {
        mMainPresenter.onDetach();
        RxAndroidPlugins.reset();
    }
}

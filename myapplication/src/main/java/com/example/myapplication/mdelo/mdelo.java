package com.example.myapplication.mdelo;

import android.util.Log;

import com.bumptech.glide.util.LogTime;
import com.example.myapplication.base.Result;
import com.example.myapplication.insert.IHome;
import com.example.myapplication.insert.ResultClass;
import com.example.myapplication.net.HTTPS;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class mdelo implements IHome.Mdelo {
    private static final String TAG = "mdelo";
    @Override
    public void getMdelo1(final ResultClass resultClass) {
        HTTPS.getInstance().getSevenApi()
                .getResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        Log.d(TAG, "onNext: "+result);
                        resultClass.onsere(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

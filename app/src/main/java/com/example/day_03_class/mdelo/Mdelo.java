package com.example.day_03_class.mdelo;

import android.util.Log;

import com.bumptech.glide.util.LogTime;
import com.example.day_03_class.base.Item;
import com.example.day_03_class.intergetr.ClassResc;
import com.example.day_03_class.intergetr.IHome;
import com.example.day_03_class.net.Https;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Mdelo implements IHome.Mdelo {
    private static final String TAG = "Mdelo";
    @Override
    public void getMdelo1(final ClassResc classResc) {
        Https.getHttps().getThomApi()
                .getItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Item>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Item item) {
                        Log.d(TAG, "onNext: "+item);
                        classResc.onSemm(item);
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

/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       : $faisal.hossain.pk@gmail.com
 * Created Date	  : 1/19/21 9:12 PM
 * Last edited by :  imac
 * Edited time    : 1/19/21 9:12 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */
package com.faisal.docbook.ui.links;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Links;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

public class LinksViewModel extends AndroidViewModel {
public MutableLiveData<List<Links>> listMutableLiveData = new MutableLiveData<>();

    public LinksViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    private void init() {
        AppDatabase.getDatabase(getApplication())
                .linksDao()
                .getList()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(links -> {
                    listMutableLiveData.postValue(links);
                });
    }
}
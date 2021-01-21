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
package com.faisal.docbook.ui.credentials;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Credentials;

import java.util.List;

public class CredentialsViewModel extends AndroidViewModel {

    public MutableLiveData<List<Credentials>> credentialsLiveData = new MutableLiveData<>();

    public CredentialsViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    private void init() {
        AppDatabase.getDatabase(getApplication()).credentialsDao().getList().subscribe(credentials -> {
            credentialsLiveData.postValue(credentials);
        });
    }
}
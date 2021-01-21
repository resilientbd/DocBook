/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/20/21 10:13 PM
 * Last edited by :  imac
 * Edited time    : 1/20/21 10:13 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.ui.doc;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Document;

import java.util.List;

public class DocFragmentViewModel extends AndroidViewModel {
    public MutableLiveData<List<Document>> documentMutableLiveData = new MutableLiveData<>();
    public DocFragmentViewModel(@NonNull Application application) {
        super(application);
        init();
    }
    private void init()
    {
        AppDatabase.getDatabase(getApplication()).docDao().getDoc().subscribe(documents -> {
            documentMutableLiveData.postValue(documents);
        });
    }
}

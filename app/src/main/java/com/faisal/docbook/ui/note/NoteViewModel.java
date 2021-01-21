/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/22/21 2:17 AM
 * Last edited by :  imac
 * Edited time    : 1/22/21 2:17 AM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.ui.note;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Note;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

public class NoteViewModel extends AndroidViewModel {
    public MutableLiveData<List<Note>> noteMutableLiveData = new MutableLiveData<>();
    public NoteViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    private void init() {
        AppDatabase.getDatabase(getApplication())
                .noteDao()
                .getNotes()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(notes -> {
                    noteMutableLiveData.postValue(notes);
                });
    }
}

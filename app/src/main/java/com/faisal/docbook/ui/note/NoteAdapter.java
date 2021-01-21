/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/22/21 1:25 AM
 * Last edited by :  imac
 * Edited time    : 1/22/21 1:25 AM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.ui.note;

import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.ItemNotesBinding;
import com.faisal.docbook.utils.base.BaseAdapter;
import com.faisal.docbook.utils.base.BaseViewHolder;
import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Note;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class NoteAdapter extends BaseAdapter<Note> {
    @Override
    public boolean isEqual(Note left, Note right) {
        return false;
    }

    @Override
    public BaseViewHolder<Note> newViewHolder(ViewGroup parent, int viewType) {
        return new DocAdapterViewHolder(inflate(parent, R.layout.item_notes));
    }
    private class DocAdapterViewHolder extends BaseAdapterViewHolder<Note>
    {
        ItemNotesBinding mItemBinding;
        public DocAdapterViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mItemBinding = (ItemNotesBinding) getViewDataBinding();
        }

        @Override
        public void bind(Note item) {
            mItemBinding.title.setText(item.getTitle());
            mItemBinding.subtitle.setText(item.getDescription());
            mItemBinding.btnRemove.setOnClickListener(v -> {
                Observable.fromCallable(() -> AppDatabase.getDatabase(mItemBinding.getRoot().getContext())
                        .noteDao().deleteNote(item))
                        .observeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io()).subscribe(aLong -> {

                });
            });
        }
    }
}

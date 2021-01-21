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

package com.faisal.docbook.ui.doc;

import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.ItemDocumentBinding;
import com.faisal.docbook.utils.base.BaseAdapter;
import com.faisal.docbook.utils.base.BaseViewHolder;
import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Document;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DocAdapter extends BaseAdapter<Document> {
    @Override
    public boolean isEqual(Document left, Document right) {
        return false;
    }

    @Override
    public BaseViewHolder<Document> newViewHolder(ViewGroup parent, int viewType) {
        return new DocAdapterViewHolder(inflate(parent, R.layout.item_document));
    }
    private class DocAdapterViewHolder extends BaseAdapterViewHolder<Document>
    {
        ItemDocumentBinding mItemBinding;
        public DocAdapterViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mItemBinding = (ItemDocumentBinding) getViewDataBinding();
        }

        @Override
        public void bind(Document item) {
            mItemBinding.title.setText(item.getTitle());
            mItemBinding.subtitle.setText(item.getDescription());
            mItemBinding.btnRemove.setOnClickListener(v -> {
                Observable.fromCallable(() -> AppDatabase.getDatabase(mItemBinding.getRoot().getContext())
                        .docDao().deleteDoc(item))
                        .observeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io()).subscribe(aLong -> {

                });
            });
        }
    }
}

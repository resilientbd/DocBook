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

package com.faisal.docbook.ui.credentials;

import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.ItemCredentialsBinding;
import com.faisal.docbook.utils.base.BaseAdapter;
import com.faisal.docbook.utils.base.BaseViewHolder;
import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Credentials;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CredentialsAdapter extends BaseAdapter<Credentials> {
    @Override
    public boolean isEqual(Credentials left, Credentials right) {
        return false;
    }

    @Override
    public BaseViewHolder<Credentials> newViewHolder(ViewGroup parent, int viewType) {
        return new CredentialsViewHolder(inflate(parent, R.layout.item_credentials));
    }
    private class CredentialsViewHolder extends BaseAdapterViewHolder<Credentials>
    {
        ItemCredentialsBinding mItemBinding;
        public CredentialsViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mItemBinding = (ItemCredentialsBinding) getViewDataBinding();
        }

        @Override
        public void bind(Credentials item) {
            mItemBinding.title.setText(item.getTitle());
            mItemBinding.subtitle.setText(item.getDescription());
            mItemBinding.btnRemove.setOnClickListener(v -> {
                Observable.fromCallable(() -> AppDatabase.getDatabase(mItemBinding.getRoot().getContext())
                        .credentialsDao().delete(item))
                        .observeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io()).subscribe(aLong -> {

                });
            });
        }
    }
}

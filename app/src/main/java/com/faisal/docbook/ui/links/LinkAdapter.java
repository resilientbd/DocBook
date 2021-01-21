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

package com.faisal.docbook.ui.links;

import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.ItemLinksBinding;
import com.faisal.docbook.utils.base.BaseAdapter;
import com.faisal.docbook.utils.base.BaseViewHolder;
import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Links;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class LinkAdapter extends BaseAdapter<Links> {
    @Override
    public boolean isEqual(Links left, Links right) {
        return false;
    }

    @Override
    public BaseViewHolder<Links> newViewHolder(ViewGroup parent, int viewType) {
        return new LinkAdapterViewHolder(inflate(parent, R.layout.item_links));
    }
    private class LinkAdapterViewHolder extends BaseAdapterViewHolder<Links>
    {
        ItemLinksBinding mItemBinding;
        public LinkAdapterViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mItemBinding = (ItemLinksBinding) getViewDataBinding();
        }

        @Override
        public void bind(Links item) {
            mItemBinding.title.setText(item.getTitle());
            mItemBinding.subtitle.setText(item.getDescription());
            mItemBinding.btnRemove.setOnClickListener(v -> {
                Observable.fromCallable(() -> AppDatabase.getDatabase(mItemBinding.getRoot().getContext())
                        .linksDao().delete(item))
                        .observeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io()).subscribe(aLong -> {

                });
            });
        }
    }
}

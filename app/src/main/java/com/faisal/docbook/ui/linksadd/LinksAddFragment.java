/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/19/21 11:56 PM
 * Last edited by :  imac
 * Edited time    : 1/19/21 11:56 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.ui.linksadd;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.FragmentLinksAddBinding;
import com.faisal.docbook.utils.base.BaseFragment;
import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Links;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class LinksAddFragment extends BaseFragment {
    private FragmentLinksAddBinding mBinding;
    private LinksAddViewModel viewModel;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_links_add;
    }

    @Override
    public void startUI() {
        mBinding = (FragmentLinksAddBinding) getViewDataBinding();
        viewModel = (LinksAddViewModel) getViewModel(LinksAddViewModel.class);

        mBinding.btnDone.setOnClickListener(v -> {
            Links links = new Links(mBinding.title.getText().toString().trim(),
                    mBinding.description.getText().toString().trim(),
                    mBinding.link.toString().trim());
            Observable.fromCallable(() -> AppDatabase.getDatabase(getContext())
                    .linksDao().insert(links))
                    .observeOn(Schedulers.io())
                    .subscribeOn(Schedulers.io()).subscribe(aLong -> {
                clearAll();

            });
        });
    }

    private void clearAll() {
        getActivity().runOnUiThread(() -> {
            mBinding.title.setText("");
            mBinding.description.setText("");
            mBinding.link.setText("");
        });
    }
}

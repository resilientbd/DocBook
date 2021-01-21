/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/19/21 11:59 PM
 * Last edited by :  imac
 * Edited time    : 1/19/21 11:59 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.ui.credentialsadd;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.FragmentCredentialsAddBinding;
import com.faisal.docbook.databinding.FragmentCredentialsBinding;
import com.faisal.docbook.utils.base.BaseFragment;
import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Credentials;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CredentialsAddFragment extends BaseFragment {
    private FragmentCredentialsAddBinding mBinding;
    private CredentialsViewModel viewModel;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_credentials_add;
    }

    @Override
    public void startUI() {
        mBinding = (FragmentCredentialsAddBinding) getViewDataBinding();
        viewModel = (CredentialsViewModel) getViewModel(CredentialsViewModel.class);
        mBinding.btnDone.setOnClickListener(v -> {
            Credentials credentials = new Credentials(mBinding.title.getText().toString().trim(),
                    mBinding.userid.getText().toString().trim(),
                    mBinding.password.getText().toString().trim(),
                    mBinding.description.getText().toString().trim());
            Observable.fromCallable(() -> AppDatabase.getDatabase(getContext())
                    .credentialsDao().insert(credentials))
                    .observeOn(Schedulers.io())
                    .subscribeOn(Schedulers.io()).subscribe(aLong -> {
                clearAll();

            });

        });
    }

    private void clearAll() {
        getActivity().runOnUiThread(() -> {
            mBinding.userid.setText("");
            mBinding.title.setText("");
            mBinding.password.setText("");
            mBinding.description.setText("");
        });
    }
}

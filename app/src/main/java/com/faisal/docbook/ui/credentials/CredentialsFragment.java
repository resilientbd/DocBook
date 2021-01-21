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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.FragmentCredentialsBinding;
import com.faisal.docbook.ui.main.MainActivity;
import com.faisal.docbook.utils.base.BaseFragment;


public class CredentialsFragment extends BaseFragment {
private FragmentCredentialsBinding mBinding;
private CredentialsViewModel viewModel;
private CredentialsAdapter mAdapter;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_credentials;
    }

    @Override
    public void startUI() {
        mBinding = (FragmentCredentialsBinding) getViewDataBinding();
        viewModel = (CredentialsViewModel) getViewModel(CredentialsViewModel.class);
        mAdapter = new CredentialsAdapter();
        mBinding.credentialsRecyclerView.setAdapter(mAdapter);
        mBinding.credentialsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.credentialsLiveData.observe(this,credentials -> {
            mAdapter.clear();
            mAdapter.addItems(credentials);
        });
        mBinding.floatingActionButton.setOnClickListener(v -> {
            ((MainActivity)getActivity()).route(R.id.action_nav_credentials_to_credentialsAddFragment,false);
        });
    }
}
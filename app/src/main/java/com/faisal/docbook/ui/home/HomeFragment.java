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
package com.faisal.docbook.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.FragmentHomeBinding;
import com.faisal.docbook.ui.main.MainActivity;
import com.faisal.docbook.utils.base.BaseFragment;


public class HomeFragment extends BaseFragment {
    private FragmentHomeBinding mBinding;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void startUI() {
        mBinding = (FragmentHomeBinding) getViewDataBinding();
        mBinding.docView.setOnClickListener(v -> {
            ((MainActivity) getActivity()).route(R.id.nav_documents,true);
        });
        mBinding.credentialsView.setOnClickListener(v -> {
            ((MainActivity) getActivity()).route(R.id.nav_credentials,true);
        });
        mBinding.linksView.setOnClickListener(v -> {
            ((MainActivity) getActivity()).route(R.id.nav_links,true);
        });
        mBinding.notesView.setOnClickListener(v -> {
            ((MainActivity) getActivity()).route(R.id.nav_notes,true);
        });
    }
}


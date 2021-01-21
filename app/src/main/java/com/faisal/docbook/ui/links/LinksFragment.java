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
package com.faisal.docbook.ui.links;

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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.FragmentLinksBinding;
import com.faisal.docbook.ui.doc.DocAdapter;
import com.faisal.docbook.ui.main.MainActivity;
import com.faisal.docbook.utils.base.BaseFragment;


public class LinksFragment extends BaseFragment {
    private FragmentLinksBinding mBinding;
    private LinksViewModel viewModel;
    private LinkAdapter mAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_links;
    }

    @Override
    public void startUI() {
        mBinding = (FragmentLinksBinding) getViewDataBinding();
        viewModel = (LinksViewModel) getViewModel(LinksViewModel.class);
        mAdapter = new LinkAdapter();
        mBinding.linkRecyclerView.setAdapter(mAdapter);
        mBinding.linkRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.listMutableLiveData.observe(this,links -> {
            mAdapter.clear();
            mAdapter.addItems(links);
        });
        mBinding.floatingActionButton.setOnClickListener(v -> {
            ((MainActivity)getActivity()).route(R.id.action_nav_links_to_linksAddFragment,false);
        });
    }
}
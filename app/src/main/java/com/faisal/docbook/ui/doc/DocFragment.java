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

package com.faisal.docbook.ui.doc;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.FragmentDocBinding;
import com.faisal.docbook.ui.main.MainActivity;
import com.faisal.docbook.utils.base.BaseFragment;

public class DocFragment extends BaseFragment {
    private FragmentDocBinding mBinding;
    private DocFragmentViewModel viewModel;
    private DocAdapter mAdapter;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_doc;
    }

    @Override
    public void startUI() {
        mBinding = (FragmentDocBinding) getViewDataBinding();
        viewModel = (DocFragmentViewModel) getViewModel(DocFragmentViewModel.class);
        mBinding.floatingActionButton.setOnClickListener(v -> {
            ((MainActivity)getActivity()).route(R.id.action_nav_documents_to_docAddFragment,false);
        });
        mAdapter = new DocAdapter();
        mBinding.docRecyclerView.setAdapter(mAdapter);
        mBinding.docRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.documentMutableLiveData.observe(this,documents -> {
            mAdapter.clear();
            mAdapter.addItems(documents);
        });
    }
}

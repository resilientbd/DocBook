/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       : $faisal.hossain.pk@gmail.com
 * Created Date	  : 1/19/21 9:11 PM
 * Last edited by :  imac
 * Edited time    : 1/19/21 9:11 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.ui.note;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.FragmentNoteBinding;
import com.faisal.docbook.ui.main.MainActivity;
import com.faisal.docbook.utils.base.BaseFragment;

public class NoteFragment extends BaseFragment {
    private FragmentNoteBinding mBinding;
    private NoteViewModel viewModel;
    private NoteAdapter mAdapter;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_note;
    }

    @Override
    public void startUI() {
        mBinding = (FragmentNoteBinding) getViewDataBinding();
        viewModel = (NoteViewModel) getViewModel(NoteViewModel.class);
        mAdapter = new NoteAdapter();
        mBinding.noteRecyclerView.setAdapter(mAdapter);
        mBinding.noteRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.noteMutableLiveData.observe(this,notes -> {
            mAdapter.clear();
            mAdapter.addItems(notes);
        });
        mBinding.floatingActionButton.setOnClickListener(v -> {
            ((MainActivity)getActivity()).route(R.id.action_nav_notes_to_noteAddFragment,false);
        });
    }
}

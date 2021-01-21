/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/19/21 11:58 PM
 * Last edited by :  imac
 * Edited time    : 1/19/21 11:58 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.ui.noteadd;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.FragmentNoteAddBinding;
import com.faisal.docbook.utils.base.BaseFragment;
import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Note;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class NoteAddFragment extends BaseFragment {
    private FragmentNoteAddBinding mBinding;
    private NoteAddViewModel viewModel;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_note_add;
    }

    @Override
    public void startUI() {
        mBinding = (FragmentNoteAddBinding) getViewDataBinding();
        viewModel = (NoteAddViewModel) getViewModel(NoteAddViewModel.class);

        mBinding.floatingActionButtonAdd.setOnClickListener(v -> {
            Note note = new Note(
                    mBinding.editTextTitle.getText().toString().trim(),
                    mBinding.editTextDescription.getText().toString().trim());

            Observable.fromCallable(() -> AppDatabase.getDatabase(getContext())
                    .noteDao().insertNote(note))
                    .observeOn(Schedulers.io())
                    .subscribeOn(Schedulers.io()).subscribe(aLong -> {
                clearAll();

            });
        });
    }

    private void clearAll() {
        getActivity().runOnUiThread(() -> {
            mBinding.editTextTitle.setText("");
            mBinding.editTextDescription.setText("");
        });
    }
}

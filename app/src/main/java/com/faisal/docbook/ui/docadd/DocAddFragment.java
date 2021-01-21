/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/19/21 11:55 PM
 * Last edited by :  imac
 * Edited time    : 1/19/21 11:55 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.ui.docadd;

import android.view.View;
import android.widget.AdapterView;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.FragmentDocAddBinding;
import com.faisal.docbook.utils.base.BaseFragment;
import com.faisal.docbook.utils.provider.room.database.AppDatabase;
import com.faisal.docbook.utils.provider.room.model.Document;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DocAddFragment extends BaseFragment {
    private FragmentDocAddBinding mBinding;
    private DocAddViewModel viewModel;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_doc_add;
    }

    @Override
    public void startUI() {
        mBinding = (FragmentDocAddBinding) getViewDataBinding();
        viewModel = (DocAddViewModel) getViewModel(DocAddViewModel.class);
        clearAll();
        initSpinner();
        mBinding.btnDone.setOnClickListener(v -> {
            Document document = new Document(mBinding.title.getText().toString().trim(),mBinding.description.getText().toString().trim(),"");
            Observable.fromCallable(() -> AppDatabase.getDatabase(getContext())
                    .docDao().insertDoc(document))
                    .observeOn(Schedulers.io())
                    .subscribeOn(Schedulers.io()).subscribe(aLong -> {
                clearAll();

            });

        });
        mBinding.spinnerSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(mBinding.spinnerSelect.getSelectedItem().equals("Document Type"))
                {
                    initSpinner();
                }
                else if(mBinding.spinnerSelect.getSelectedItem().equals("Image"))
                {
                    activeImageUpload();
                }
                else if(mBinding.spinnerSelect.getSelectedItem().equals("Doc/PDF"))
                {
                    activeDocUpload();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void initSpinner()
    {
        mBinding.btnAddDoc.setVisibility(View.GONE);
        mBinding.docname.setVisibility(View.GONE);
        mBinding.selectImg.setVisibility(View.GONE);
    }
    private void activeImageUpload()
    {
        mBinding.btnAddDoc.setVisibility(View.GONE);
        mBinding.docname.setVisibility(View.GONE);
        mBinding.selectImg.setVisibility(View.VISIBLE);
    }
    private void activeDocUpload()
    {
        mBinding.btnAddDoc.setVisibility(View.VISIBLE);
        mBinding.docname.setVisibility(View.VISIBLE);
        mBinding.selectImg.setVisibility(View.GONE);
    }
    private void clearAll()
    {
       getActivity().runOnUiThread(() -> {
           mBinding.title.setText("");
           mBinding.description.setText("");
           mBinding.spinnerSelect.setSelection(0);
       });
    }

}

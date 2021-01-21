/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/20/21 9:48 PM
 * Last edited by :  imac
 * Edited time    : 1/20/21 9:48 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.navigation.NavController;

import com.faisal.docbook.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivityViewModel extends AndroidViewModel {
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    void routeFragment(NavController navController, NavigationView navigationView, int targetNavId, boolean isParent) {
        if (isParent) {
            navigationView.setCheckedItem(targetNavId);
        }
        navController.navigate(targetNavId);

    }

}

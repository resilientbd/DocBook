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
package com.faisal.docbook.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.faisal.docbook.R;
import com.faisal.docbook.ui.main.MainActivity;
import com.faisal.docbook.utils.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void startUI() {
        startActivity(MainActivity.class);
    }

}
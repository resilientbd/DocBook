/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       : faisal.hossain.pk@gmail.com
 * Created Date	  : 1/19/21 9:12 PM
 * Last edited by :  imac
 * Edited time    : 1/19/21 9:12 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */
package com.faisal.docbook.ui.main;

import android.view.View;
import android.view.Menu;

import com.faisal.docbook.R;
import com.faisal.docbook.databinding.ActivityMainBinding;
import com.faisal.docbook.utils.base.BaseActivity;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends BaseActivity {
    NavController navController;
    private AppBarConfiguration mAppBarConfiguration;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding mBinding;
    NavigationView navigationView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void startUI() {

        mBinding = (ActivityMainBinding) getViewDataBinding();
        viewModel = (MainActivityViewModel) getViewModel(MainActivityViewModel.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_documents, R.id.nav_credentials, R.id.nav_links, R.id.nav_notes)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }


    public void route(int targetNavId,boolean isParent) {
        viewModel.routeFragment(navController,navigationView,targetNavId,isParent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
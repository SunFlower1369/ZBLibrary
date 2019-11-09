package com.example.yingweng.lalagame.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class SwithcFragment {
    private  FragmentTransaction fragmentTransaction ;
    public SwithcFragment(int layoutId, Fragment fragment, FragmentManager fragmentManager) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(layoutId, fragment);
        this.fragmentTransaction = fragmentTransaction;
    }
    public void commit(){
        this.fragmentTransaction.commit();
    }
}

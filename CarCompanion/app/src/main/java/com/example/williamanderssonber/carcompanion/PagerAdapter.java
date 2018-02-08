package com.example.williamanderssonber.carcompanion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by william.anderssonber on 2018-01-23.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;


    public PagerAdapter(FragmentManager fm, int NumOfTabs){
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BransleFragment tab1 = new BransleFragment();

                return tab1;
            case 1:
                BilFragment tab2 = new BilFragment();
                return tab2;
            case 2:
                ServiceFragment tab3 = new ServiceFragment();
                return tab3;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

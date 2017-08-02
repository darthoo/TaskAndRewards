package com.yolotasker.yolotasker.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.yolotasker.yolotasker.ui.fragment.BaseFragment;

import java.util.List;

/**
 * Created by AndroidDev on 02.08.2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragments;

    public ViewPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        if(fragments!=null){
            return fragments.size();
        }
        return 0;
    }

    public void setFragments(List<BaseFragment> fragments){
        this.fragments = fragments;
    }
}

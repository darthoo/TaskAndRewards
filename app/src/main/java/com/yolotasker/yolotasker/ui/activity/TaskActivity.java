package com.yolotasker.yolotasker.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import com.yolotasker.yolotasker.R;
import com.yolotasker.yolotasker.ui.adapter.ViewPagerAdapter;
import com.yolotasker.yolotasker.ui.fragment.BaseFragment;
import com.yolotasker.yolotasker.ui.fragment.CompletedTaskFragment;
import com.yolotasker.yolotasker.ui.fragment.TaskInProgressFragment;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends MainActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;

    private List<BaseFragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initDrawer();
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        fragmentList = initFragments();
        mAdapter.setFragments(fragmentList);
        mAdapter.notifyDataSetChanged();
        initTabs();
    }

    private void initTabs(){
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.in_progress_task_title)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.completed_task_title)));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private List<BaseFragment> initFragments(){
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new TaskInProgressFragment());
        fragments.add(new CompletedTaskFragment());
        return fragments;
    }
}

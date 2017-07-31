package com.yolotasker.yolotasker.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yolotasker.yolotasker.R;
import com.yolotasker.yolotasker.ui.adapter.CardViewAdapter;
import com.yolotasker.yolotasker.ui.component.ApplicationComponent;
import com.yolotasker.yolotasker.ui.model.RewardUiModel;
import com.yolotasker.yolotasker.ui.mvp.RewardPresenter;
import com.yolotasker.yolotasker.ui.mvp.RewardView;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by AndroidDev on 13.07.2017.
 */

public class RewardFragment extends BaseFragment implements RewardView {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private CardViewAdapter mAdapter;

    @Inject
    RewardPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(ApplicationComponent.class).inject(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task,null);

        layoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new CardViewAdapter();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(),layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(itemDecoration);
        mPresenter.setView(this);
        if(savedInstanceState == null){
            mPresenter.getRewards();
        }
        return v;
    }

    @Override
    public void setRewards(List<RewardUiModel> rewards) {
        mAdapter.setItems(rewards);
        mAdapter.notifyDataSetChanged();
    }
}

package com.yolotasker.yolotasker.ui.fragment;

import android.app.Fragment;
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
import com.yolotasker.yolotasker.ui.model.RewardUiModel;

import java.util.List;

/**
 * Created by AndroidDev on 13.07.2017.
 */

public class RewardFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private CardViewAdapter mAdapter;

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

        if(savedInstanceState == null){
            List<RewardUiModel> rewardUiModels = RewardUiModel.getRewards();
            mAdapter.setItems(rewardUiModels);
            mAdapter.notifyDataSetChanged();
        }
        return v;
    }
}

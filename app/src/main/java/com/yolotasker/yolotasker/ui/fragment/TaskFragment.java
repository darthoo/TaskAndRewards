package com.yolotasker.yolotasker.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yolotasker.yolotasker.R;
import com.yolotasker.yolotasker.ui.activity.CreateTaskActivity;
import com.yolotasker.yolotasker.ui.adapter.CardViewAdapter;
import com.yolotasker.yolotasker.ui.model.TaskUiModel;
import com.yolotasker.yolotasker.ui.mvp.TaskPresenter;
import com.yolotasker.yolotasker.ui.mvp.TaskView;
import com.yolotasker.yolotasker.ui.presenter.TaskPresenterImpl;

import java.util.List;

/**
 * Created by AndroidDev on 13.07.2017.
 */

public class TaskFragment extends Fragment implements View.OnClickListener, TaskView {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private CardViewAdapter mAdapter;
    private FloatingActionButton mAddTaskButton;
    private TaskPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task,null);

        mAddTaskButton = (FloatingActionButton) v.findViewById(R.id.btn_add_task);
        mAddTaskButton.setOnClickListener(this);
        layoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new CardViewAdapter();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(),layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(itemDecoration);

        mPresenter = new TaskPresenterImpl(this);

        if(savedInstanceState == null){
           mPresenter.getTasks();
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_task:
                startActivity(new Intent(getActivity(),CreateTaskActivity.class));
                break;
        }
    }

    @Override
    public void setTasks(List<TaskUiModel> tasks) {
        if(tasks!=null && !tasks.isEmpty()){
            mAdapter.setItems(tasks);
            mAdapter.notifyDataSetChanged();
        }
    }
}

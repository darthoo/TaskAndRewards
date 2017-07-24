package com.yolotasker.yolotasker.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yolotasker.yolotasker.R;
import com.yolotasker.yolotasker.ui.model.TaskUiModel;
import com.yolotasker.yolotasker.ui.model.BaseUiModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndroidDev on 15.07.2017.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    private List<? extends BaseUiModel> items = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.task_card_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BaseUiModel item = items.get(position);
        if(item!=null){
            holder.title.setText(item.getTitle());
            holder.price.setText(item.getPrice()+" coins");

            if(item instanceof TaskUiModel){
                TaskUiModel task = (TaskUiModel) item;
                holder.description.setText(task.getDescription());
                holder.startDate.setText(dateFormat.format(task.getStartDate()));
                holder.description.setVisibility(View.VISIBLE);
                holder.startDate.setVisibility(View.VISIBLE);
            }

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView startDate;
        TextView price;
        CardView cardView;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.task_title);
            description = (TextView) v.findViewById(R.id.task_description);
            startDate = (TextView) v.findViewById(R.id.task_start_date);
            price = (TextView) v.findViewById(R.id.price);
            cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }

    public void setItems(List<? extends BaseUiModel> items){
        this.items = items;
    }
}

package com.yolotasker.yolotasker.ui.model;

import android.content.Context;

import com.yolotasker.yolotasker.data.db.DBHelper;

import java.util.Date;
import java.util.List;

/**
 * Created by AndroidDev on 15.07.2017.
 */

public class TaskUiModel extends BaseUiModel {

    private Date startDate;

    private String description;

    private Context context;

    private static DBHelper dbHelper;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContext(Context context){
        this.context = context;
        dbHelper = new DBHelper(context);
    }
}

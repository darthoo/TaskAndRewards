package com.yolotasker.yolotasker.data.model;

import android.content.Context;

import com.yolotasker.yolotasker.data.db.DBHelper;

import java.util.Date;
import java.util.List;

/**
 * Created by AndroidDev on 15.07.2017.
 */

public class Task extends BaseModel {

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

    public static List<Task> getTasks(){
        if(dbHelper!=null){

        }


        /*for(int i=0; i<10;i++){
            TaskUiModel task = new TaskUiModel();
            task.setTitle("TaskUiModel title "+i);
            task.setDescription("This is description for "+task.getTitle()+". " +
                    "The developer try to make this cards better. But he need some time to do the magic. We will hope, that we" +
                    " will see new design ASAP.");
            task.setStartDate(new Date());
            tasks.add(task);
        }*/
        return null;
    }

    public void setContext(Context context){
        this.context = context;
        dbHelper = new DBHelper(context);
    }

}

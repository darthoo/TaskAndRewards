package com.yolotasker.yolotasker.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.yolotasker.yolotasker.data.model.BaseModel;
import com.yolotasker.yolotasker.data.model.Reward;
import com.yolotasker.yolotasker.data.model.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by AndroidDev on 11.07.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String TAG = DBHelper.class.getSimpleName();
    private static final String DB_NAME = "YOLO_tasker_database";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");

    private Context context;


    private static final String TASK_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TaskFields.TASK_TABLE_NAME
            + " ("
            + TaskFields.TASK_ID +      " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TaskFields.TASK_TITLE +  " TEXT,"
            + TaskFields.TASK_DESCRIPTION + " TEXT,"
            + TaskFields.TASK_PRICE +    " INTEGER,"
            + TaskFields.TASK_START_DATE +   " INTEGER"
            + ");";

    private static final String REWARD_TABLE = "CREATE TABLE IF NOT EXISTS "
            + RewardFields.REWARD_TABLE_NAME
            + " ("
            + RewardFields.REWARD_ID +      " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + RewardFields.REWARD_TITLE +  " TEXT,"
            + RewardFields.REWARD_PRICE + " INTEGER"
            + ");";

    @Inject
    public DBHelper(@NonNull Context context) {
        super(context.getApplicationContext(),DB_NAME,null,DB_VERSION);
        this.context = context.getApplicationContext();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TASK_TABLE);
        db.execSQL(REWARD_TABLE);
        Log.d(TAG,"DB creation complete");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertTaskOrReward(BaseModel model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        if(model instanceof Task){
            Task task = (Task) model;
            cv.put(TaskFields.TASK_TITLE,task.getTitle());
            cv.put(TaskFields.TASK_DESCRIPTION,task.getDescription());
            cv.put(TaskFields.TASK_PRICE,task.getPrice());
            cv.put(TaskFields.TASK_START_DATE,System.currentTimeMillis());
            db.insert(TaskFields.TASK_TABLE_NAME,null,cv);
        } else if(model instanceof Reward){
            Reward rewardUiModel = (Reward) model;
            cv.put(RewardFields.REWARD_TITLE, rewardUiModel.getTitle());
            cv.put(RewardFields.REWARD_PRICE, rewardUiModel.getPrice());
            db.insert(RewardFields.REWARD_TABLE_NAME,null,cv);
        } else {
            Log.e(TAG,"Incorrect model");
        }
    }

    public List<Task> selectAllTasks(){
        String sql = "Select* from "+TaskFields.TASK_TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        List<Task> tasks = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            for(int i=0; i<cursor.getCount();i++){
                Task task = new Task();
                task.setId(cursor.getInt(0));
                task.setTitle(cursor.getString(1));
                task.setDescription(cursor.getString(2));
                task.setPrice(cursor.getInt(3));
                task.setStartDate(new Date());
                //TODO Convert date from int
                tasks.add(task);
                cursor.moveToNext();
            }
        }

        return tasks;
    }
}

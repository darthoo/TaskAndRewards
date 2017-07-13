package com.yolotasker.yolotasker.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yolotasker.yolotasker.model.User;

/**
 * Created by AndroidDev on 11.07.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "YoloTaskerDb";
    private static final String TABLE_USER = "user";

    private static final String KEY_ID = "id";
    private static final String KEY_LOGIN = "login";
    private static final String KEY_PASSWORD = "password";

    private String [] COLUMNS = {KEY_ID,KEY_LOGIN,KEY_PASSWORD};

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

   /* public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, version);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user ("
                + "id integer primary key autoincrement,"
                + "login text,"
                + "password text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public User getUser(Integer id ){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_USER,
                        COLUMNS,
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            User user = new User();
            user.setId(cursor.getInt(0));
            user.setLogin(cursor.getString(1));
            user.setPassword(cursor.getString(2));
            db.close();
            return user;
        }
        db.close();
        return null;
    }

    public User getUserByLoginPassword(String login, String password){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_USER,
                        COLUMNS,
                        " login = ? and password = ?",
                        new String[] {login,password},
                        null,
                        null,
                        null,
                        null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            User user = new User();
            user.setId(cursor.getInt(0));
            user.setLogin(cursor.getString(1));
            user.setPassword(cursor.getString(3));
            return user;
        }
        return null;
    }

    public boolean checkUser(String login, String password) {

        // array of columns to fetch
        String[] columns = {
                KEY_ID
        };

        String selection = KEY_LOGIN + " = ?" + " AND " + KEY_PASSWORD + " = ?";

        SQLiteDatabase db = this.getReadableDatabase();

        String[] selectionArgs = {login, password};

        // query user table with conditions
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public void insert(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LOGIN, user.getLogin());
        values.put(KEY_PASSWORD, user.getPassword());
        db.insert(TABLE_USER, null, values);
        db.close();
    }
}

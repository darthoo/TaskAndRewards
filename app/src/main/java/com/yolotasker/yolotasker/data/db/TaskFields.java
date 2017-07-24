package com.yolotasker.yolotasker.data.db;

/**
 * Created by AndroidDev on 19.07.2017.
 */

public class TaskFields {

    public static final String TASK_TABLE_NAME = "task";

    public static final String TASK_ID = "id";

    public static final String TASK_TITLE = "title";

    public static final String TASK_DESCRIPTION = "description";

    public static final String TASK_START_DATE = "start_date";

    public static final String TASK_PRICE = "price";

    public static final String [] TASK_COLUMNS ={TASK_ID,TASK_TITLE,TASK_DESCRIPTION,TASK_PRICE,TASK_TABLE_NAME};
}

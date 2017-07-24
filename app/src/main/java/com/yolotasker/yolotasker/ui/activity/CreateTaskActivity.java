package com.yolotasker.yolotasker.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.yolotasker.yolotasker.R;
import com.yolotasker.yolotasker.ui.model.TaskUiModel;

import java.util.Date;

public class CreateTaskActivity extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private Button btnSubmitTask;
    private NumberPicker price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        title = (TextView) findViewById(R.id.tv_title);
        description = (TextView) findViewById(R.id.tv_description);
        price = (NumberPicker) findViewById(R.id.price_picker);

        btnSubmitTask = (Button) findViewById(R.id.btn_submit_task);

        btnSubmitTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskUiModel task = new TaskUiModel();
                task.setTitle(title.getText().toString());
                task.setDescription(description.getText().toString());
                task.setPrice(price.getValue());
                task.setStartDate(new Date());
                task.setContext(getApplicationContext());
                /*task.insert();*/
                finish();
            }
        });
    }

}

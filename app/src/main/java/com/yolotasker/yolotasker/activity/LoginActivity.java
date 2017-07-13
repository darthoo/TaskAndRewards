package com.yolotasker.yolotasker.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yolotasker.yolotasker.R;
import com.yolotasker.yolotasker.db.DBHelper;
import com.yolotasker.yolotasker.model.User;

public class LoginActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    private EditText mLogin;
    private EditText mPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DBHelper(this);

        if(dbHelper.getUser(1) ==null){
            User user = new User();
            user.setPassword("111");
            user.setLogin("admin");
            dbHelper.insert(user);
        }

        mLogin = (EditText) findViewById(R.id.login);
        mPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = mLogin.getText().toString();
                String password = mPassword.getText().toString();
                if(dbHelper.checkUser(login,password)){
                    Log.e("Login", "User founded");
                }
            }
        });



    }
}

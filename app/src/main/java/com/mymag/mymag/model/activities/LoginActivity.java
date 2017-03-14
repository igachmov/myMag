package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mymag.mymag.R;

public class LoginActivity extends AppCompatActivity {

    Button goToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
        goToRegister= (Button)findViewById(R.id.Button_Register);


        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(register);
            }
        });

    }
}
